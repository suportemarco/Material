package com.bematech.material.models;

import java.util.ArrayList;

/**
 * Created by c1401895 on 06/07/2015.
 */
public class Category {

    private String nome;
    private ArrayList<Colaborador> colaboradores;

    public Category() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
