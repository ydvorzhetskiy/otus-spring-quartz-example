package ru.otus.springquartzexample.xmlcalendar;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Cleanup;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CalendarElement")
@SpringBootTest
class CalendarElementTest {

    @Autowired
    private XmlMapper xmlMapper;

    @DisplayName("должен десериализовываться из XML")
    @Test
    void shouldDeserializeFromXml() throws Exception {
        @Cleanup val resource = getClass().getResourceAsStream("/calendar.xml");
        val calendar = xmlMapper.readValue(resource, CalendarElement.class);
        assertThat(calendar.getDays().get(0).getDate()).isEqualTo("01.01");
    }
}
