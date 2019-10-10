package atividade1;

public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public double sacar(double valor) {
        double valorComLimite = getSaldo() + limite;
        if(getSaldo() < valor){
            if(valorComLimite >= valor){
                double novoSaldo = getSaldo() - valor;
                setSaldo(novoSaldo);
                return getSaldo();
            } else {
                System.out.println("0002 - Transação negada!");
                return getSaldo();
            }
        } else {
            double novoSaldo = getSaldo() - valor;
            setSaldo(novoSaldo);
            return getSaldo();
        }
    }

    public double depositar(double valor) {
        double novoSaldo = getSaldo() + valor;
        setSaldo(novoSaldo);
        return getSaldo();
    }  

    public void mostrarDados() {
        System.out.println("Conta: " + getNumConta());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Limite: " + limite);
    }

    public double transferir(double valor, ContaBancaria conta) {
        int contaDestino = conta.getNumConta();
        if(getSaldo() >= valor ){
            double saldoDestino = conta.getSaldo() + valor;
            double saldoAtual = getSaldo() - valor;
            conta.setSaldo(saldoDestino);
            setSaldo(saldoAtual);
            return getSaldo();
        } else {
            System.out.println("0003 - Transação negada.");
            return getSaldo();
        }
    }
}
