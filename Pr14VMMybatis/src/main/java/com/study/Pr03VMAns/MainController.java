package com.study.Pr03VMAns;

import com.study.Pr03VMAns.dao.IProductDao;
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

    final IProductDao productDao;

    @GetMapping("/")
    public String main() {

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productDao.selectAll();
        model.addAttribute("list", products);
        return "productList";
    }

    @GetMapping("/addProductForm")
    public String addProductForm() {
        return "addProductForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute AddDto dto) {
        int result = productDao.insert(Product.builder()
                        .name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate())
                .build());
        if (result != 1){
            System.out.println("상품 등록 실패");
        }
        return "redirect:/products";
    }

    // /editProduct?index=0
    @GetMapping("/editProductForm")
    public String editProductForm(@RequestParam int index, Model model) {
        Optional<Product> optional = productDao.findById(index);
        optional.ifPresent(product -> {
            model.addAttribute("index", product.getId());
            model.addAttribute("product", product);

        });

        return "editProductForm";
    }

    @PostMapping("/editProduct")
    @ResponseBody
    public String editProduct(@ModelAttribute EditDto dto) {
        int result = productDao.update(Product.builder().id(dto.getIndex()).name(dto.getInputName()).price(dto.getInputPrice()).limit_date(dto.getInputLimitDate()).build());
        if(result != 1) {
            System.out.println("상품 수정 실패");
        }
        return "<script>alert('상품이 수정되었습니다!'); location.href='/products'; </script>";
    }

    @GetMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestParam int index) {
        int result = productDao.delete(index);
        if (result != 1) {
            System.out.println("상품 삭제 실패");
        }
        return "<script>alert('상품이 삭제되었습니다!'); location.href='/products'; </script>";
    }

}
