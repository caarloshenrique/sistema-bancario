package atividade1;

public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private double taxaOp;

    public double getTaxaOp() {
        return taxaOp;
    }

    public void setTaxaOp(double taxaOp) {
        this.taxaOp = taxaOp;
    }
    
    public double sacar(double valor) {
        double valorTaxa = getSaldo() - taxaOp;
        if(valorTaxa >= valor){
            double novoSaldo = valorTaxa - valor;
            setSaldo(novoSaldo);
            return getSaldo();
        } else {
            System.out.println("0001 - Transação negada!");
            return getSaldo();
        }
    }

    public double depositar(double valor) {
        double novoSaldo = (getSaldo() + valor);
        setSaldo(novoSaldo);
        return getSaldo();
    }  

    public void mostrarDados() {
        System.out.println("Conta: " + getNumConta());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Taxa de Operação: " + getTaxaOp());
    }

    public double transferir(double valor, ContaBancaria conta) {
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
