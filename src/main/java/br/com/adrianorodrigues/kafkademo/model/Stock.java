package br.com.adrianorodrigues.kafkademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private BigDecimal price;

}
