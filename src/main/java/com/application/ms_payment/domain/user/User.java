package com.application.ms_payment.domain.user;

public class User {

    private String id;
    private Long cpf;
    private Long cnpj;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(String id, Long cpf, Long cnpj, String name, String email, String password) {
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
