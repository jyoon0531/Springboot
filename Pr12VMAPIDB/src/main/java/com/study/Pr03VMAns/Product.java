package com.study.Pr03VMAns;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 상품명
    private int price; // 가격
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limit_date; // 유통기한
}
