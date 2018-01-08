package com.megogo.utils;

import static io.restassured.RestAssured.get;

/**
 * Created by Sergei on 07.01.2018.
 */
public class DateUtils {
    private static final String LOCAL_TIME_SYNCH_URL = "http://epg.megogo.net/time";

    public static Long getCurrentTimestampInSeconds() {
        return get(LOCAL_TIME_SYNCH_URL).jsonPath().getLong("data.timestamp");
    }

}
