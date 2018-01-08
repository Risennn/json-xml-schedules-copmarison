
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
    "original",
    "105x85",
    "monochrome_logo",
    "180x180",
    "980x560",
    "88x65",
    "88x88",
    "105x105",
    "40x40",
    "150x150",
    "1600x520"
})
public class Pictures_ {

    @JsonProperty("original")
    private String original;
    @JsonProperty("105x85")
    private String _105x85;
    @JsonProperty("monochrome_logo")
    private String monochromeLogo;
    @JsonProperty("180x180")
    private String _180x180;
    @JsonProperty("980x560")
    private String _980x560;
    @JsonProperty("88x65")
    private String _88x65;
    @JsonProperty("88x88")
    private String _88x88;
    @JsonProperty("105x105")
    private String _105x105;
    @JsonProperty("40x40")
    private String _40x40;
    @JsonProperty("150x150")
    private String _150x150;
    @JsonProperty("1600x520")
    private String _1600x520;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("original")
    public String getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    @JsonProperty("105x85")
    public String get105x85() {
        return _105x85;
    }

    @JsonProperty("105x85")
    public void set105x85(String _105x85) {
        this._105x85 = _105x85;
    }

    @JsonProperty("monochrome_logo")
    public String getMonochromeLogo() {
        return monochromeLogo;
    }

    @JsonProperty("monochrome_logo")
    public void setMonochromeLogo(String monochromeLogo) {
        this.monochromeLogo = monochromeLogo;
    }

    @JsonProperty("180x180")
    public String get180x180() {
        return _180x180;
    }

    @JsonProperty("180x180")
    public void set180x180(String _180x180) {
        this._180x180 = _180x180;
    }

    @JsonProperty("980x560")
    public String get980x560() {
        return _980x560;
    }

    @JsonProperty("980x560")
    public void set980x560(String _980x560) {
        this._980x560 = _980x560;
    }

    @JsonProperty("88x65")
    public String get88x65() {
        return _88x65;
    }

    @JsonProperty("88x65")
    public void set88x65(String _88x65) {
        this._88x65 = _88x65;
    }

    @JsonProperty("88x88")
    public String get88x88() {
        return _88x88;
    }

    @JsonProperty("88x88")
    public void set88x88(String _88x88) {
        this._88x88 = _88x88;
    }

    @JsonProperty("105x105")
    public String get105x105() {
        return _105x105;
    }

    @JsonProperty("105x105")
    public void set105x105(String _105x105) {
        this._105x105 = _105x105;
    }

    @JsonProperty("40x40")
    public String get40x40() {
        return _40x40;
    }

    @JsonProperty("40x40")
    public void set40x40(String _40x40) {
        this._40x40 = _40x40;
    }

    @JsonProperty("150x150")
    public String get150x150() {
        return _150x150;
    }

    @JsonProperty("150x150")
    public void set150x150(String _150x150) {
        this._150x150 = _150x150;
    }

    @JsonProperty("1600x520")
    public String get1600x520() {
        return _1600x520;
    }

    @JsonProperty("1600x520")
    public void set1600x520(String _1600x520) {
        this._1600x520 = _1600x520;
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
