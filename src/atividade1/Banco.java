package atividade1;

import java.util.ArrayList;

public class Banco implements Imprimivel{
    ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
        
    public void inserirConta(ContaBancaria c){
        boolean a = false;
        for (int i = 0; i < contas.size(); i++) {
            if(c.getNumConta() == contas.get(i).getNumConta()){
                a = true;
                break;
            }
        }
        if(a == true){
            System.out.println("Conta já existe.");
        } else {
            contas.add(c);
            System.out.println("Conta criada com sucesso!");
        }
    }
    
    public void removerConta(int conta){
        boolean a = false;
        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumConta() == conta){
                a = true;
                contas.remove(i);
                break;
            }
        }
        if(a == true) {
            System.out.println("Conta removida com sucesso!");
        } else {
             System.out.println("Conta Inexistente!");
        }
    }

   public ContaBancaria procurarConta(int numero){
       for (int i = 0; i < contas.size(); i++) {
           if(contas.get(i).getNumConta() == numero){
                System.out.println(contas.get(i).getNumConta());
                return contas.get(i);
           }
       }
       System.out.println("Conta Inexistente!");
       return null;
   }
   
    public void mostrarDados() {
        int i;
        for (i = 0; i < contas.size(); i++) {
            System.out.println("------------------------");
            System.out.println("Conta: " + contas.get(i).getNumConta());
            System.out.println("Saldo: " + contas.get(i).getSaldo());
        }
        System.out.println("------------------------");
        System.out.println("Total de contas no Banco: " + i); 
   }
}
