package com.letscode.cookBook.controller;

import com.letscode.cookBook.domain.Receita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Catalogo {
    private final List<Receita> receitas;

    public Catalogo() {
        receitas = new ArrayList<>();
    }

    public void add(Receita nova) {
        if (nova != null && !nova.getNome().isBlank()) {
            if (!receitas.contains(nova)) {
                receitas.add(nova);
            }
        }
    }

    public void del(String nome) {
        Receita item = getReceita(nome);
        if (item != null) {
            receitas.remove(item);
        }
    }

    public Receita getReceita(String nome) {
        if (nome != null && !nome.isBlank()) {
            for (Receita item : receitas) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    return item;
                }
            }
        }
        return null;
    }

    public Receita getReceita(int index) {
        if (index >= 0 && index < receitas.size()) {
            return receitas.get(index);
        }
        return null;
    }

    /**
     * Returns index of recipe.
     * @param receita Object Receita
     * @return -1 if not found.
     */
    public int getIndex(Receita receita) {
        if (getReceita(receita.getNome()) !=  null) {
            return this.receitas.indexOf(receita);
        }
        return -1;
    }

    @SuppressWarnings("unused")
    public Receita getRandom() {
        if (receitas.isEmpty()) return null;

        int index = new Random().nextInt(receitas.size());
        return getReceita(index);
    }
}
