package ru.otus.springquartzexample.xmlcalendar;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.otus.springquartzexample.service.RussianHolidaysService;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class XmlCalendarClient implements RussianHolidaysService {

    private final XmlMapper xmlMapper;

    @Override
    public boolean isHoliday(LocalDate date) throws Exception {
        val year = date.getYear();
        val calendar = read(year);
        val dayToFind = date.format(DateTimeFormatter.ofPattern("MM.dd"));
        val isSaturdayOrSunday = date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        val fromCalendar = calendar.getDays().stream()
                .filter(day -> dayToFind.equals(day.getDate()))
                .findAny();
        return isSaturdayOrSunday
                ? fromCalendar.isEmpty()
                : fromCalendar.isPresent() && fromCalendar.map(DayElement::isHoliday).get();
    }

    CalendarElement read(int year) throws Exception {
        val url = new URL("http://xmlcalendar.ru/data/ru/" + year + "/calendar.xml");
        return xmlMapper.readValue(url, CalendarElement.class);
    }
}
