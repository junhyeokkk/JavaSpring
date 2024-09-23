package com.farm.service;

import com.farm.entity.product.prodcate;
import com.farm.dto.product.prodcateDTO;
import com.farm.repository.prodcateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class prodcateService {

    private final prodcateRepository repo;

    public List<prodcateDTO> selectprdcate(){
        List<prodcate> prdcate = repo.findAll();
        List<prodcateDTO> prodcateDTOs= new ArrayList<>();
        prodcateDTOs = prdcate.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());

        return prodcateDTOs;
    }
}
