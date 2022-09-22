package RH.Service;
import RH.Entities.Contatos;
import RH.Entities.Informacoes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddInformacoes extends ArquivoContato{
    private Scanner sc = new Scanner(System.in);
    File fs = new File("G:\\TrampoJava\\Contatos.dados");
    private ArrayList<Contatos> list = new ArrayList<Contatos>();
    private ArrayList<Informacoes> listInfo = new ArrayList<>();


    public void AddInformacoes(ArrayList<Contatos> listt) throws IOException, ClassNotFoundException {
        for (Contatos obj : listt){
            System.out.println(obj.nome + " ; " + obj.telefone);
            System.out.println("Informe o nivel de escolaridade: ");
            String nivelEscol = sc.next();
            System.out.println("Informe o seu cargo: ");
            String cargo = sc.next();
            System.out.println("Informe o salário pretendido: ");
            double salario = sc.nextDouble();
            this.listInfo.add(new Informacoes(nivelEscol, cargo, salario, obj.nome, obj.telefone));
        }
    }
    public void  Desserializa () throws IOException, ClassNotFoundException {
        FileInputStream arq = new FileInputStream(fs);
        ObjectInputStream in = null;
        in = new ObjectInputStream(new BufferedInputStream(arq));
        String contato = (String) in.readObject();
        String[] split = contato.split(";");
        String nome = split[0];
        String telefone = split[1];
        this.list.add(new Contatos(nome, telefone));
        AddInformacoes(list);
    }


    public void Serializar() throws IOException {
        this.fs = new File("G:\\TrampoJava\\InfoContatos.txt");
        if (fs.exists()) {
            FileOutputStream arq = new FileOutputStream(this.fs,true);
            ObjectOutputStream out = new ObjectOutputStream(arq);
            for (Informacoes objinf: this.listInfo) {
                out.writeObject(objinf.nome + " ; " + objinf.telefone + " ; " + objinf.getNivelEscolaridade()+ " ; " +
                        objinf.getCargo() + " ; " + objinf.getSalario());
            }
            out.close();
        }
    }
}
