package ru.otus.springquartzexample.service;

import java.time.LocalDate;

public interface RussianHolidaysService {

    boolean isHoliday(LocalDate date) throws Exception;
}
