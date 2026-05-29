package br.com.pratica.login.dto;

public class PastaDto {
    
    private String nome;

    public PastaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}