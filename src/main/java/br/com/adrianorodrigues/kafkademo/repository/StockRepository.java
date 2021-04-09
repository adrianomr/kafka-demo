package br.com.adrianorodrigues.kafkademo.repository;

import br.com.adrianorodrigues.kafkademo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
