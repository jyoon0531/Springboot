package com.study.Pr01Counter;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @PostMapping("/count")
    public ResDto count(@RequestBody ReqDto reqDto){
        System.out.println(reqDto);
        System.out.println(reqDto.getCount());
        ResDto resDto = new ResDto();
        resDto.setCount(reqDto.getCount());
        return resDto;
    }
}
