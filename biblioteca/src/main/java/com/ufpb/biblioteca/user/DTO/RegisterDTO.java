package com.ufpb.biblioteca.user.DTO;

import com.ufpb.biblioteca.user.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
