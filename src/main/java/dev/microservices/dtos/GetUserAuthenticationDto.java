package dev.microservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserAuthenticationDto {
    private String email;
    private String password;
}
