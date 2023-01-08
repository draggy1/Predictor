package com.predictor.fetcher.adapters;

import com.predictor.fetcher.domain.ports.PriceDto;
import com.predictor.fetcher.domain.ports.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaRepository implements PriceRepository {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaRepository(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @Override
    public void push(PriceDto price, String topicName) {
        kafkaTemplate.send(topicName, price.toString());
    }
}
