package RH.Service;

import RH.Entities.Contatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoContato {
    File fs = new File("G:\\TrampoJava\\Contatos.dados");
    private Scanner sc = new Scanner(System.in);
    public ArrayList<Contatos> list = new ArrayList<>();

    public void AddContatos(int tamanhoArray) throws IOException, ClassNotFoundException {
        for (int i =0; i < tamanhoArray; i++){
            System.out.printf("Informe o nome: ");
            String nome = sc.next();
            System.out.printf("Informe o telefone: ");
            String telefone = sc.next();
            this.list.add(new Contatos(nome, telefone));
        }
    }
    public void Serializar() throws IOException {
        if (fs.exists()) {
            FileOutputStream arq = new FileOutputStream(this.fs);
            ObjectOutputStream out = new ObjectOutputStream(arq);
            for (Contatos obj: this.list) {
                out.writeObject(obj.nome + ";" + obj.telefone);
            }
            out.close();
        }
    }
    public void  Desserializa () throws IOException, ClassNotFoundException {
        FileInputStream arq = new FileInputStream(this.fs);
        ObjectInputStream in = null;
        in = new ObjectInputStream(new BufferedInputStream(arq));
        String contato = (String) in.readObject();
    }
}
