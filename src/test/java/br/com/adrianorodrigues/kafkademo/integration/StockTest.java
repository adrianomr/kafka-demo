package br.com.adrianorodrigues.kafkademo.integration;

import br.com.adrianorodrigues.kafkademo.model.Stock;
import br.com.adrianorodrigues.kafkademo.repository.StockRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StockTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        stockRepository.save(Stock.builder().name("BCFF11").price(BigDecimal.valueOf(86.5)).build());
        stockRepository.save(Stock.builder().name("ITSA4").price(BigDecimal.valueOf(10.2)).build());
    }

    @Test
    void getStocksWhenSuccessShouldReturnStocksList() throws Exception {
        mvc.perform(get("/stocks")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("$[0].name", Matchers.is("BCFF11")));;
    }
}
