package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;
    @Getter
    @Setter
    public class UserRequestDto {
        private final String name;
        private final String email;
        private final String userType;

        public UserRequestDto(String name, String email, String userType) {
            this.name = name;
            this.email = email;
            this.userType = userType;
        }
}