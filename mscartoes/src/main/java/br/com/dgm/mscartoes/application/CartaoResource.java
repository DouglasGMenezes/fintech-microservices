package br.com.dgm.mscartoes.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
@Slf4j
public class CartaoResource {

    @GetMapping
    public String status() {
        log.info("# Teste status OK ");
        return "OK";
    }

}
