package atividade1;

public abstract class ContaBancaria implements Imprimivel {
    private int numConta;
    private double saldo;
    
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public abstract double sacar(double valor);
    public abstract double depositar(double valor);
    public abstract double transferir(double valor, ContaBancaria conta);
}
