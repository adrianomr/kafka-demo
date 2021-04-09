package br.com.adrianorodrigues.kafkademo.service.kafka;

import br.com.adrianorodrigues.kafkademo.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Stock> kafkaTemplate;

    public void send(Stock stock){
        log.info("Payload enviado: {}", stock);
        kafkaTemplate.send(topicName, stock);
    }

}