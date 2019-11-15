package ru.otus.springquartzexample.xmlcalendar;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Класс XmlCalendarClient")
@SpringBootTest
class XmlCalendarClientTest {

    @Autowired
    private XmlCalendarClient client;

    @DisplayName("должен возвращать данные за 2019 год")
    @Test
    void shouldReturn2019() throws Exception {
        val calendar = client.read(2019);
        assertThat(calendar).isNotNull();
    }

    @DisplayName("должен сказать, что 8-ое марта 2019 - выходной")
    @Test
    void shouldSayThat20190308IsHoliday() throws Exception {
        assertTrue(client.isHoliday(LocalDate.of(2019, 3, 8)));
    }

    @DisplayName("должен сказать, что 9-ое июня 2018 был рабочий")
    @Test
    void shouldSayThat20180609IsHoliday() throws Exception {
        assertFalse(client.isHoliday(LocalDate.of(2018, 6, 9)));
    }
}
