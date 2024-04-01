package com.study.Pr02Calc;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component      // 스프링 빈으로 등록하려면 적어줘야 함.
@Getter
public class Calculator {
    double result = 0;
    public int add(int a, int b) {
        result = a + b;
        return (int) result;
    }
    public int sub(int a, int b) {
        result = a - b;
        return (int) result;
    }
    public int mul(int a, int b) {
        result = a * b;
        return (int) result;
    }
    public double div(int a, int b) {
        result = (double)a / (double)b;
        return result;
    }



}
