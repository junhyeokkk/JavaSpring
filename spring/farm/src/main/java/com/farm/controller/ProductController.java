package com.farm.controller;

import com.farm.dto.product.prodcateDTO;
import ch.qos.logback.core.model.Model;
import com.farm.service.prodcateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final prodcateService productService;

    // 제품 카테고리 불러오기
    @ResponseBody
    @GetMapping("/prodcate")
    public ResponseEntity prodcate(Model model) {

        List<prodcateDTO> prodcates = productService.selectprdcate();
        return ResponseEntity.ok().body(prodcates);
    }

}
