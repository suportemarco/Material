package com.bematech.material.models;

/**
 * Created by c1401895 on 06/07/2015.
 */
public class Colaborador {

    private String nome;
    private String email;
    private String imageUrl;

    public Colaborador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
