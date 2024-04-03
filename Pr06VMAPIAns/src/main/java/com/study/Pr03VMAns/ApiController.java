package com.study.Pr03VMAns;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    public static List<Product> list = new ArrayList<>();

    public ApiController() {
        Product product = Product.builder()
                .name("베이컨버거").price(3000).limit_date(LocalDate.parse("2024-04-03"))
                .build();
        list.add(product);
        list.add(product);
        list.add(product);
    }

    @GetMapping("/products")
    public List<Product> products() {
        return list;
    }


    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int index) {
        list.remove(index);
        return "";
    }
}
