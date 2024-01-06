package dev.microservices.dtos;


import dev.microservices.model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductRequestDto {
    private Product product;
    private String email;
    private String password;
}
