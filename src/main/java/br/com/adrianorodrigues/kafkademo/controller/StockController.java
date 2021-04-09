package br.com.adrianorodrigues.kafkademo.controller;

import br.com.adrianorodrigues.kafkademo.model.Stock;
import br.com.adrianorodrigues.kafkademo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping
    public List<Stock> findStocks() {
        return stockService.findAll();
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock){
        return stockService.createStock(stock);
    }
}
