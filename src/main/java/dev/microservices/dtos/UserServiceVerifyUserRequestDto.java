package dev.microservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserServiceVerifyUserRequestDto  {
    private String email;
    private String password;
}
