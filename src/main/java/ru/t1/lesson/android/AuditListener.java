package ru.t1.lesson.android;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AuditListener {
    @Value("${synthetic-human-core-starter.audit.kafka-topic}")
    private String kafkaTopic;

    @Value("${synthetic-human-core-starter.audit.mode}")
    private String auditMode;

    @KafkaListener(topics = "${synthetic-human-core-starter.audit.kafka-topic}", groupId = "audit-group")
    public void listen(String message) {
        System.out.println("Mode: " + auditMode);
        System.out.println("Received from topic '" + kafkaTopic + "': " + message);
    }
}
