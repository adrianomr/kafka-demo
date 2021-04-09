package br.com.adrianorodrigues.kafkademo.scheduled;

import br.com.adrianorodrigues.kafkademo.service.StockService;
import br.com.adrianorodrigues.kafkademo.service.kafka.StockProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableAsync
public class StockPrice {

    @Autowired
    StockService stockService;
    @Autowired
    StockProducer stockProducer;

    @Async
    @Scheduled(fixedRate = 3)
    public void generate() {
        stockService.findAll().stream().forEach(stock -> stockProducer.send(stock));
    }

}
