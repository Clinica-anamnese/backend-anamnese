package br.unisantos.pce.user;

public record RegisterDTO(String nome, String login, String password, UserRole role) {
    
}
