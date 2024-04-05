package com.study.Pr03VMAns;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    final ProductRepository productRepository;

    @GetMapping("/")
    public String main() {

        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm() {
        return "addProductForm";
    }


    // /editProduct?index=0
    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam Long index, Model model) {
        Optional<Product> optional = productRepository.findById(index);
        optional.ifPresent(product -> {
            model.addAttribute("index", product.getId());
            model.addAttribute("product", product);

        });

        return "editProductForm";
    }

}
