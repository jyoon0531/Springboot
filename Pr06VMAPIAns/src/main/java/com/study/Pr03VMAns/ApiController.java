package com.study.Pr03VMAns;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
//    public static List<Product> list = new ArrayList<>();

    final ProductRepository productRepository;

    public ApiController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        Product product = Product.builder()
                .name("베이컨버거").price(3000).limit_date(LocalDate.parse("2024-04-03"))
                .build();
        productRepository.list.add(product);
        productRepository.list.add(product);
        productRepository.list.add(product);
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.list;
    }


    @DeleteMapping("/deleteProduct")
    public ResDto deleteProduct(@RequestParam int index) {
        productRepository.list.remove(index);
        return ResDto.builder()
                .status("ok")
                .message("삭제되었습니다.")
                .count(1)
                .build();
    }

    @PutMapping("/product")
    public ResDto updateProduct(@RequestBody ReqDto reqDto) {
        productRepository.list.set(reqDto.getIndex(), Product.builder()
                .name(reqDto.getInputName()).price(reqDto.getInputPrice()).limit_date(reqDto.getInputLimitDate())
                .build());

        return ResDto.builder()
                .status("ok")
                .message("수정되었습니다.")
                .count(1)
                .build();
    }

    @PostMapping("/product")
    public ResDto addProduct(@RequestBody ReqDto reqDto) {
        productRepository.list.add(Product.builder()
                .name(reqDto.getInputName()).price(reqDto.getInputPrice()).limit_date(reqDto.getInputLimitDate())
                .build());
        return ResDto.builder()
                .status("ok")
                .message("추가되었습니다.")
                .count(1)
                .build();
    }
}
