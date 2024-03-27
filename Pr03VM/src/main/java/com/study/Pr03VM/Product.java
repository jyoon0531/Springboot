package com.study.Pr03VM;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Product {

    private String name;
    private int price;
    private LocalDate limitDate;

}
