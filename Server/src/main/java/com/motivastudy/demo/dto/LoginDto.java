package com.motivastudy.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginDto {
    private String username;
    private String password;
}
