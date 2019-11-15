package ru.otus.springquartzexample.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Slf4j
public class VeryHardJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("Very very very hard job...");
    }
}
