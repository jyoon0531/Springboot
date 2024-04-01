package com.study.Pr03VM;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    List<Product> products = new ArrayList<>();


    @RequestMapping("/") // 첫 화면 + 상품 목록
    public String main(Model model) {
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/insertForm")  // 상품추가 화면
    public String insertForm() {
        return "insertForm";
    }

    @PostMapping("/insert") // 상품 추가
    public String insert(@RequestBody String inputName) {
        System.out.println(inputName);

        return "index";
    }

    @RequestMapping("/update") // 상품 수정
    public String update() {
        return "index";
    }

    @GetMapping("/updateForm")  // 상품수정 화면
    public String updateForm() {
        return "updateForm";
    }

    @RequestMapping("/delete") // 상품 삭제
    public String delete() {
        return "index";
    }


}
