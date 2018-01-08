
package com.megogo.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "external_id",
    "title",
    "programs",
    "pictures"
})
public class Datum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("external_id")
    private Integer externalId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("programs")
    private List<Program> programs = null;
    @JsonProperty("pictures")
    private Pictures_ pictures;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("external_id")
    public Integer getExternalId() {
        return externalId;
    }

    @JsonProperty("external_id")
    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("programs")
    public List<Program> getPrograms() {
        return programs;
    }

    @JsonProperty("programs")
    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @JsonProperty("pictures")
    public Pictures_ getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures_ pictures) {
        this.pictures = pictures;
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
