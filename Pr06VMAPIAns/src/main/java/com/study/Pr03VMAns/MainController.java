package com.study.Pr03VMAns;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public String editProductForm(@RequestParam int index, Model model) {
        Product product = productRepository.list.get(index);
        model.addAttribute("index", index);
        model.addAttribute("product", product); 
        return "editProductForm";
    }

}
