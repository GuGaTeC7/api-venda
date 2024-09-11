package com.api.venda.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "cpf_cnpj", length = 100, nullable = false)
    private String cpfCnpj;

    @OneToMany(mappedBy = "user")
    private List<Produto> produtos = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String password, Boolean isActive, String cpfCnpj) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.cpfCnpj = cpfCnpj;
    }

    public User(String name, String email, String password, Boolean isActive, String cpfCnpj, List<Produto> produtos) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.cpfCnpj = cpfCnpj;
        this.produtos = produtos != null ? produtos : new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
