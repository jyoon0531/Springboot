package com.study.Pr01Counter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final Counter counter;

//    public MainController (Counter counter){
//        this.counter = counter;
//    }

    @GetMapping("/")
    public String main(Model model){
        counter.setCount(counter.getCount());
        model.addAttribute("count", counter.getCount());
        return "index";
    }

    @GetMapping("/plus")
    public String plus(Model model){
        counter.setCount(counter.getCount()+1);
//        model.addAttribute("count", counter.getCount());
        return "redirect:/";
    }

    @GetMapping("/minus")
    public String minus(Model model){
        counter.setCount(counter.getCount()-1);
//        model.addAttribute("count", counter.getCount());
        return "redirect:/";
    }
}
