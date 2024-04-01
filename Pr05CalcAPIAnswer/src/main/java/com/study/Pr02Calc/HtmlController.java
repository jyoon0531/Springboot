package com.study.Pr02Calc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    final Calculator calculator;

    @GetMapping("/")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/add")
    public String add(@RequestParam String a, @RequestParam String b, Model model) {
        int result = calculator.add(Integer.parseInt(a), Integer.parseInt(b));
        model.addAttribute("result", result);
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        return "index";
    }
    @GetMapping("/sub")
    public String sub(@RequestParam String a, @RequestParam String b, Model model) {
        int result = calculator.sub(Integer.parseInt(a), Integer.parseInt(b));
        model.addAttribute("result", result);
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        return "index";
    }
    @GetMapping("/mul")
    public String mul(@RequestParam String a, @RequestParam String b, Model model) {
        int result = calculator.mul(Integer.parseInt(a), Integer.parseInt(b));
        model.addAttribute("result", result);
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        return "index";
    }
    @GetMapping("/div")
    public String div(@RequestParam String a, @RequestParam String b, Model model) {
        double result = calculator.div(Integer.parseInt(a), Integer.parseInt(b));
        model.addAttribute("result", result);
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        return "index";
    }
}
