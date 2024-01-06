package dev.microservices.controller;

import dev.microservices.dtos.CreateProductRequestDto;
import dev.microservices.dtos.GetUserAuthenticationDto;
import dev.microservices.model.Product;
import dev.microservices.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService service;
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("{productId}")
    public Product getProductDetails(@PathVariable("productId") Long productId, @RequestBody GetUserAuthenticationDto authenticationDto){
        return service.getProductDetails(productId,authenticationDto.getEmail(),authenticationDto.getPassword());
    }

    @PostMapping("")
    public Product createProduct(@RequestBody CreateProductRequestDto dto){
        return service.createProduct(dto.getProduct(), dto.getEmail(), dto.getPassword());
    }

}
