package com.example.demo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic driversLocationUpdateTopic() {
        return TopicBuilder.name("driver-location-updates-topic")
                .build();
    }
    @Bean
    public NewTopic riderRequestTopic() {
        return TopicBuilder.name("ride-request-topic")
                .build();
    }
    @Bean
    public NewTopic riderRequestAcceptanceTopic() {
        return TopicBuilder.name("ride-request-acceptance-topic")
                .build();
    }

}
