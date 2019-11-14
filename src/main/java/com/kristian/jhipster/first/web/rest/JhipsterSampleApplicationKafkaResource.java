package com.kristian.jhipster.first.web.rest;

import com.kristian.jhipster.first.service.JhipsterSampleApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipster-sample-application-kafka")
public class JhipsterSampleApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleApplicationKafkaResource.class);

    private JhipsterSampleApplicationKafkaProducer kafkaProducer;

    public JhipsterSampleApplicationKafkaResource(JhipsterSampleApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
