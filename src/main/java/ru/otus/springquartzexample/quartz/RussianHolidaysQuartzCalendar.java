package ru.otus.springquartzexample.quartz;


import lombok.RequiredArgsConstructor;
import lombok.val;
import org.quartz.Calendar;
import org.springframework.stereotype.Component;
import ru.otus.springquartzexample.service.RussianHolidaysService;

import java.time.*;

@RequiredArgsConstructor
@Component
public class RussianHolidaysQuartzCalendar implements Calendar {

    private final RussianHolidaysService russianHolidaysService;

    @Override
    public boolean isTimeIncluded(long timestamp) {
        try {
            val date = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC).toLocalDate();
            return russianHolidaysService.isHoliday(date);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public long getNextIncludedTime(long timestamp) {
        LocalDate date = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC).toLocalDate();
        try {
            while (!russianHolidaysService.isHoliday(date)) {
                date = date.plusDays(1);
            }
            return 0;
        } catch (Exception ex) {
            return date.plusDays(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC);
        }
    }

    @Override
    public void setBaseCalendar(Calendar calendar) {
    }

    @Override
    public Calendar getBaseCalendar() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String s) {
    }

    @Override
    public Object clone() {
        return new RussianHolidaysQuartzCalendar(russianHolidaysService);
    }
}
