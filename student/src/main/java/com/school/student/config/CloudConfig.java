package com.school.student.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CloudConfig {

    @Value("${maxStudentCount}")
    private String maxStudentCount;

    @PostConstruct
    public void postConstruct() {
        log.info("PROPERTY VALUE FROM CLOUD-CONFIG: {}", maxStudentCount);
    }

}
