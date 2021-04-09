package br.com.adrianorodrigues.kafkademo.service;

import br.com.adrianorodrigues.kafkademo.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAll();

    Stock createStock(Stock stock);
}
