package com.example.demo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name("topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic driverLocationUpdatesTopic() {
        return TopicBuilder.name("driver-location-updates-topic")
                .build();
    }
    @Bean
    public NewTopic riderRequestTopic() {
        return TopicBuilder.name("ride-request-topic")
                .build();
    }

}
