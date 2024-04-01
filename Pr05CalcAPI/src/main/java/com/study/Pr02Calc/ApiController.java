package com.study.Pr02Calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    Calculator calculator;

    @PostMapping("/add")
    public ResDto add (@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        calculator.add(num1, num2);
        ResDto resDto = new ResDto();
        resDto.setStatus("ok");
        resDto.setResult(String.valueOf(calculator.getResult()));
        return resDto;
    }
    @PostMapping("/sub")
    public ResDto sub (@RequestBody ReqDto reqDto){
        System.out.println(reqDto);
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        calculator.sub(num1, num2);
        ResDto resDto = new ResDto();
        resDto.setStatus("ok");
        resDto.setResult(String.valueOf(calculator.getResult()));
        return resDto;
    }
    @PostMapping("/mul")
    public ResDto mul (@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        calculator.mul(num1, num2);
        ResDto resDto = new ResDto();
        resDto.setStatus("ok");
        resDto.setResult(String.valueOf(calculator.getResult()));
        return resDto;
    }
    @PostMapping("/div")
    public ResDto div (@RequestBody ReqDto reqDto){
        int num1 = Integer.parseInt(reqDto.getNum1());
        int num2 = Integer.parseInt(reqDto.getNum2());
        calculator.div(num1, num2);
        ResDto resDto = new ResDto();
        resDto.setStatus("ok");
        resDto.setResult(String.valueOf(calculator.getDivResult()));
        return resDto;
    }

}
