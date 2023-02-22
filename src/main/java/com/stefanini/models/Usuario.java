package com.stefanini.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUser;
    @NotBlank
    @NotNull
    @Column(length = 50)
    private String nome;
    @Size (min = 5, max = 20)
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    @Size (min = 10)
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String senha;

    private LocalDate dataNascimento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaAtualizacao;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCriacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM-dd HH:mm:ss");
        if(dataCriacao != null){ return dataCriacao.format(formatter); }
        else{
            return null;
        }
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataUltimaAtualizacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM-dd HH:mm:ss");
        if(dataUltimaAtualizacao != null){ return dataUltimaAtualizacao.format(formatter) ;}
        else{
            return null;
        }
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}