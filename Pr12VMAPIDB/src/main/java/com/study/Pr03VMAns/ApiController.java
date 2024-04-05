package com.study.Pr03VMAns;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {
    final ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public ResDto addProduct(@RequestBody AddDto dto) {
        productRepository.save(Product.builder()
                .name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate())
                .build());
        return ResDto.builder()
                .status("ok")
                .message("상품추가 성공")
                .count(1)
                .build();
    }

    @PutMapping("/product")
    public ResDto editProduct(@RequestBody EditDto dto) {
        productRepository.save(Product.builder()
                .id(dto.getIndex()).name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate())
                .build());
        return ResDto.builder()
                .status("ok")
                .message("상품수정 성공")
                .count(1)
                .build();
    }

    @DeleteMapping("/deleteProduct")
    public ResDto deleteProduct(@RequestParam Long index) {
        productRepository.deleteById(index);

        return ResDto.builder()
                .status("ok")
                .message("상품삭제 성공")
                .count(1)
                .build();
    }
}
