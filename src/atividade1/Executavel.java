package atividade1;

public class Executavel {
    public static void main(String[] args) {
       ContaCorrente cc0 = new ContaCorrente();
       ContaPoupanca cc1 = new ContaPoupanca();
       ContaPoupanca cp = new ContaPoupanca();
       
       ContaPoupanca na = new ContaPoupanca();
       na.setNumConta(17);
       na.setLimite(15000.0);
       na.setSaldo(24.0);
       
       ContaCorrente nt = new ContaCorrente();
       nt.setNumConta(45);
       nt.setTaxaOp(15.0);
       nt.setSaldo(250.0);
       
       
       cp.setLimite(1500.0);
       cp.setSaldo(4500.0);
       
       cc0.setNumConta(15);
       cc1.setNumConta(44);
       cp.setNumConta(20);
       
       cc0.setTaxaOp(1.0);
       cc0.setSaldo(56900.0);
       cc0.depositar(450.0);
       cc0.sacar(4000.0);
       cc0.transferir(5000.0, cc1);
       
       Relatorio r1 = new Relatorio();
       //r1.gerarRelatorio(na);
       
       
       Banco n1 = new Banco();
       n1.inserirConta(na);
       n1.inserirConta(nt);
       n1.inserirConta(cp);
       n1.mostrarDados();
       
       n1.removerConta(123);
       System.out.println("---");
       n1.mostrarDados();
       
       n1.procurarConta(20);
       
       /*
       cp.setLimite(1500.0);
       cp.setSaldo(4500.0);
       cp.depositar(400.0);
       cp.sacar(9000.0);
       */
    }
}
