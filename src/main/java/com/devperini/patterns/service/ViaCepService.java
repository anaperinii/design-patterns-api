package com.devperini.patterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devperini.patterns.model.Address;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    
    @GetMapping("/{cep}/json")
    Address consultarCep(@PathVariable("cep") String cep);
}
