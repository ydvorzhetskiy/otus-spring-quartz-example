package ru.otus.springquartzexample.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springquartzexample.quartz.VeryHardJob;

@Configuration
public class ApplicationConfig {

    @Bean
    XmlMapper xmlMapper() {
        return new XmlMapper();
    }

    @Bean
    JobDetail veryHardJob() {
        return JobBuilder.newJob(VeryHardJob.class)
                .withIdentity("veryHardJob")
                .storeDurably()
                .build();
    }

    @Bean
    Trigger jobTrigger(){
        return TriggerBuilder.newTrigger().forJob(veryHardJob())
                .withIdentity("veryHardJobTrigger")
                .startNow()
                .build();
    }
}
