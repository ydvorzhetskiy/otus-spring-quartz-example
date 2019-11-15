package ru.otus.springquartzexample.xmlcalendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "calendar")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarElement {

    @JacksonXmlElementWrapper(localName = "days")
    private List<DayElement> days;
}
