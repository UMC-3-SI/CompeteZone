/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alunocmc
 */
public class Jogos {
    // Declara a classe Jogos
    private int idJogo;
    private String nome, categoria;
    private float numPlayers;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(float numPlayers) {
        this.numPlayers = numPlayers;
    }
    
}
