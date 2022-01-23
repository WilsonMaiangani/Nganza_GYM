/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alifa
 */
public class Pessoa {

    private int id;
    private String Nome;
    private String Genero;
    private String Chave;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public String getGenero() {
        return Genero;
    }

    public String getChave() {
        return Chave;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setGenero(String genero) {
        this.Genero = genero;
    }

    public void setChave(String chave) {
        this.Chave = chave;
    }

   }