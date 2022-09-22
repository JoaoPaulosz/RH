package RH.Entities;

import java.io.Serializable;

public class Contatos implements Serializable {

    public String nome;
    public String telefone;
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }

    public Contatos(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}
