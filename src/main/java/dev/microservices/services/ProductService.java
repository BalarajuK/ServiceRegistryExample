package dev.microservices.services;

import dev.microservices.dtos.UserServiceVerifyUserRequestDto;
import dev.microservices.model.Product;
import dev.microservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private ProductRepository repository;
    private RestTemplate restTemplate;


    public ProductService(ProductRepository productRepository, RestTemplate restTemplate){
        this.repository = productRepository;
        this.restTemplate = restTemplate;
    }

    public Product getProductDetails(Long prodId, String email, String password){

        if(!authenticate(email,password)){
            return null;
        }
        return repository.findById(prodId).orElse(null);
    }
    public Product createProduct(Product product, String email, String password){
        if(!authenticate(email, password)){
            return null;
        }
        return repository.save(product);
    }

    private boolean authenticate(String email, String password){
        UserServiceVerifyUserRequestDto userRequestDto = new UserServiceVerifyUserRequestDto();
        userRequestDto.setEmail(email);
        userRequestDto.setPassword(password);
        ResponseEntity<Boolean> response = restTemplate.postForEntity(
                "http://userservice/users/verify",
                userRequestDto,
                Boolean.class
                );
        boolean allowed = response.getBody();
        return allowed;
    }
}
