
package com.megogo.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "external_id",
    "object_id",
    "year",
    "title",
    "description",
    "schedule_string",
    "genre",
    "category",
    "pictures",
    "virtual_object_id",
    "start",
    "start_timestamp",
    "end",
    "end_timestamp",
    "grouped_programs",
    "schedule_type"
})
public class Program {

    @JsonProperty("external_id")
    private Integer externalId;
    @JsonProperty("object_id")
    private Object objectId;
    @JsonProperty("year")
    private Object year;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("schedule_string")
    private Object scheduleString;
    @JsonProperty("genre")
    private Genre genre;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("pictures")
    private Pictures pictures;
    @JsonProperty("virtual_object_id")
    private String virtualObjectId;
    @JsonProperty("start")
    private String start;
    @JsonProperty("start_timestamp")
    private Long startTimestamp;
    @JsonProperty("end")
    private String end;
    @JsonProperty("end_timestamp")
    private Long endTimestamp;
    @JsonProperty("grouped_programs")
    private Object groupedPrograms;
    @JsonProperty("schedule_type")
    private String scheduleType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("external_id")
    public Integer getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("object_id")
    public Object getObjectId() {
        return objectId;
    }

    @JsonProperty("object_id")
    public void setObjectId(Object objectId) {
        this.objectId = objectId;
    }

    @JsonProperty("year")
    public Object getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Object year) {
        this.year = year;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("schedule_string")
    public Object getScheduleString() {
        return scheduleString;
    }

    @JsonProperty("schedule_string")
    public void setScheduleString(Object scheduleString) {
        this.scheduleString = scheduleString;
    }

    @JsonProperty("genre")
    public Genre getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("pictures")
    public Pictures getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @JsonProperty("virtual_object_id")
    public String getVirtualObjectId() {
        return virtualObjectId;
    }

    @JsonProperty("virtual_object_id")
    public void setVirtualObjectId(String virtualObjectId) {
        this.virtualObjectId = virtualObjectId;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("start_timestamp")
    public Long getStartTimestamp() {
        return startTimestamp;
    }

    @JsonProperty("start_timestamp")
    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    @JsonProperty("end_timestamp")
    public Long getEndTimestamp() {
        return endTimestamp;
    }

    @JsonProperty("end_timestamp")
    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    @JsonProperty("grouped_programs")
    public Object getGroupedPrograms() {
        return groupedPrograms;
    }

    @JsonProperty("grouped_programs")
    public void setGroupedPrograms(Object groupedPrograms) {
        this.groupedPrograms = groupedPrograms;
    }

    @JsonProperty("schedule_type")
    public String getScheduleType() {
        return scheduleType;
    }

    @JsonProperty("schedule_type")
    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
