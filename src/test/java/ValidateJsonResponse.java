import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.megogo.pojo.Program;
import com.megogo.pojo.TvChannel;
import com.megogo.utils.DateUtils;
import com.megogo.utils.JsonValidationUtils;
import com.megogo.utils.XmlUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;

/**
 * Created by Sergei on 06.01.2018.
 */
public class ValidateJsonResponse {

    private static final String XML_SCHEDULE_PATH = "http://www.vsetv.com/export/megogo/epg/3.xml";
    private static final String JSON_SCHEDULE_PATH = "http://epg.megogo.net/channel?external_id=295";
    private static final String JSON_SCHEMA_PATH = "megogo-channel-json-schema.json";
    private static final int ONE_DAY_IN_MS = 86400000;
    private static final String TEST_JSON_MISSING_FIELDS = "test-json-missing-fields.json";
    private static final String TEST_JSON_ADDITIONAL_FIELDS = "test-json-additional-fields.json";
    private static final String YYYY_MM_DD_HH_MM_SS_Z = "yyyy-MM-dd HH:mm:ss Z";

    @Test
    void validateCorrectJsonAgainstSchema() throws IOException, ProcessingException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL jsonUrl = new URL(JSON_SCHEDULE_PATH);
        File jsonSchemaFile = new File(classLoader.getResource(JSON_SCHEMA_PATH).getFile());

        JsonValidationUtils.validateJson(jsonSchemaFile, jsonUrl);
    }

    @Test
    void checkJsonWithMissingFieldsValidationFails() throws IOException, ProcessingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File brokenJsonPath = new File(classLoader.getResource(TEST_JSON_MISSING_FIELDS).getFile());
        File jsonSchemaFile = new File(classLoader.getResource(JSON_SCHEMA_PATH).getFile());

        JsonValidationUtils.validateJson(jsonSchemaFile, brokenJsonPath);
    }

    @Test
    void checkJsonWithAdditionalFieldsValidationFails() throws IOException, ProcessingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File brokenJsonPath = new File(classLoader.getResource(TEST_JSON_ADDITIONAL_FIELDS).getFile());
        File jsonSchemaFile = new File(classLoader.getResource(JSON_SCHEMA_PATH).getFile());

        JsonValidationUtils.validateJson(jsonSchemaFile, brokenJsonPath);
    }

    @Test
    void compareJsonAndXmlTvProgramSchedules() {
        Long currentTimestamp = DateUtils.getCurrentTimestampInSeconds() * 1000;
        Long timestampInOneDay = currentTimestamp + ONE_DAY_IN_MS;

        Map<Long, Long> completeScheduleFromXml = new TreeMap<>();
        Map<Long, Long> scheduleForDayForwardFromXml;
        Map<Long, Long> scheduleForDayForwardFromJson = new TreeMap<>();

        String completeXmlResponse = get(XML_SCHEDULE_PATH).asString();
        NodeList nodeList = XmlUtils.getNodeListFromXml(completeXmlResponse);
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                LocalDateTime ldtStartDate = LocalDateTime.parse(eElement.getAttribute("start"), DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS_Z));
                LocalDateTime ldtStopDate = LocalDateTime.parse(eElement.getAttribute("stop"), DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS_Z));
                Long startTimestamp = ldtStartDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                Long stopTimestamp = ldtStopDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                completeScheduleFromXml.put(startTimestamp, stopTimestamp);
            }
        }

        System.out.println("Current timestamp : " + currentTimestamp);
        System.out.println("Timestamp in 1 day : " + timestampInOneDay);
        System.out.println("\nXML schedule for day forward:");
        scheduleForDayForwardFromXml = new TreeMap<>(completeScheduleFromXml.entrySet().stream()
                .filter(entry -> entry.getValue() > currentTimestamp && entry.getKey() < timestampInOneDay)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        scheduleForDayForwardFromXml.forEach((k, v) -> System.out.println("start : " + k + " | stop : " + v));

        System.out.println("\nJSON schedule for day forward:");
        List<Program> jsonResponseProgramsList = get(JSON_SCHEDULE_PATH).as(TvChannel.class).getData().get(0).getPrograms();
        for (Program program : jsonResponseProgramsList) {
            scheduleForDayForwardFromJson.put(program.getStartTimestamp() * 1000, program.getEndTimestamp() * 1000);
            System.out.println("start : " + program.getStartTimestamp() * 1000 + " | stop : " + program.getEndTimestamp() * 1000);
        }

        Assert.assertTrue(scheduleForDayForwardFromXml.size() == scheduleForDayForwardFromJson.size()
                        && scheduleForDayForwardFromXml.entrySet().containsAll(scheduleForDayForwardFromJson.entrySet()),
                "Schedules for next day from xml and json responses are different");

    }
}
