package ru.otus.springquartzexample.xmlcalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "day")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayElement {

    @JacksonXmlProperty(isAttribute = true, localName = "d")
    private String date;

    @JacksonXmlProperty(isAttribute = true, localName = "t")
    private int type;
}
