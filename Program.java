package RH;
import RH.Service.AddInformacoes;
import RH.Service.ArquivoContato;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Quantos contatos você quer adicionar");
        ArquivoContato arquivoCOntato = new ArquivoContato();
        int tamanhoArray = sc.nextInt();
        arquivoCOntato.AddContatos(tamanhoArray);
        arquivoCOntato.Serializar();
        arquivoCOntato.Desserializa();
        AddInformacoes inf = new AddInformacoes();
        inf.Desserializa();
        inf.Serializar();
    }
}
