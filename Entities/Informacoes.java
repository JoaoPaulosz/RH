package RH.Entities;

public class Informacoes extends Contatos {
    private String nivelEscolaridade;

    public String getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    private String cargo;
    private double salario;

    public Informacoes(String nivelEscolaridade, String cargo, double salario, String nome, String telefone){
        super(nome, telefone);
        this.nivelEscolaridade = nivelEscolaridade;
        this.cargo = cargo;
        this.salario = salario;
    }
}
