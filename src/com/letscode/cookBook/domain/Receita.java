package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

import java.util.List;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private List<Ingrediente> ingredientes;
    private List<String> modoPreparo;

    public Receita( String nome,
                    Categoria categoria,
                    int tempoPreparo,
                    Rendimento rendimento,
                    List<Ingrediente> ingredientes,
                    List<String> modoPreparo) {
        this.nome = nome;
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }

    public Receita(String nome, Categoria categoria){
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        return nome.equals(receita.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        int segundos = tempoPreparo % 60;
        int minutos = tempoPreparo > 60 ? tempoPreparo % (60*60) : 0;
        int horas = tempoPreparo > 60*60 ? tempoPreparo % (60*60*24) : 0;
        String tempo = horas > 0 ? horas + " horas " : "";
        tempo += minutos > 0 ? minutos + " minutos " : "";
        tempo += segundos > 0 ? segundos + " segundos " : "";
        return String.format("%s%n\t%s%n%nRendimento: %s%nTempo: %s%nIngredientes:%n%s%nModo de preparo:%n%s", nome, categoria, rendimento, tempo, ingredientes, modoPreparo);
    }
}
