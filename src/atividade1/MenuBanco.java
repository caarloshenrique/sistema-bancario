package atividade1;

import java.util.Scanner;

public class MenuBanco {
    public static void main(String[] args) {
        int controle = 0;
        Banco b1 = new Banco();
        while (controle == 0){
            Scanner leitor = new Scanner(System.in);
        
            System.out.println("----------Menu----------");
            System.out.println("1. Criar Conta");
            System.out.println("2. Selecionar Conta");
            System.out.println("3. Remover Conta");
            System.out.println("4. Gerar Relatório");
            System.out.println("5. Finalizar");
            System.out.println("------------------------");
            System.out.print("Opção: ");
            int resposta = leitor.nextInt();
            System.out.println("------------------------");
        
            switch(resposta){
                case 1:
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    System.out.println("------------------------");
                    System.out.print("Opção: ");
                    int resposta2 = leitor.nextInt();
                    if (resposta2 == 1) {
                        ContaCorrente cc = new ContaCorrente();
                        System.out.println("------------------------");
                        System.out.println("Conta Corrente");
                        System.out.print("Número da Conta: ");
                        cc.setNumConta(leitor.nextInt());
                        System.out.print("Saldo: ");
                        cc.setSaldo(leitor.nextDouble());
                        System.out.print("Taxa de Operação: ");
                        cc.setTaxaOp(leitor.nextDouble());
                        System.out.println("------------------------");
                        b1.inserirConta(cc);
                        System.out.println("------------------------");
                        cc.mostrarDados();
                        System.out.println("------------------------");
                        break;
                    }
                    if(resposta2 == 2){
                        ContaPoupanca cp = new ContaPoupanca();
                        System.out.println("------------------------");
                        System.out.println("Conta Poupança");
                        System.out.print("Número da Conta: ");
                        cp.setNumConta(leitor.nextInt());
                        System.out.print("Saldo: ");
                        cp.setSaldo(leitor.nextDouble());
                        System.out.print("Limite: ");
                        cp.setLimite(leitor.nextDouble());
                        System.out.println("------------------------");
                        b1.inserirConta(cp);
                        System.out.println("------------------------");
                        cp.mostrarDados();
                        System.out.println("------------------------");
                        break;
                    }
                case 2:
                    System.out.println("------------------------");
                    System.out.println("Selecionar Conta");
                    System.out.print("Informe o número da conta: ");
                    int resposta3 = leitor.nextInt();
                    System.out.println("------------------------");
                    System.out.print("Conta Selecionada: ");
                    ContaBancaria contaSelecionada = b1.procurarConta(resposta3);
                    System.out.println("------------------------");
                    
                    if (contaSelecionada != null){
                        Scanner sc = new Scanner(System.in);
                        System.out.println("------------------------");
                        System.out.println("1. Depositar");
                        System.out.println("2. Sacar");
                        System.out.println("3. Transferir");
                        System.out.println("4. Gerar Relatório");
                        System.out.println("5. Retornar ao menu anterior");
                        System.out.println("------------------------");
                        System.out.print("Opção: ");
                        int resp = sc.nextInt();
                        switch (resp) {
                            case 1:
                                System.out.println("------------------------");
                                System.out.println("Depositar");
                                System.out.print("Valor: ");
                                double saldoAnterior = contaSelecionada.getSaldo();
                                double valorDeposito = sc.nextDouble();
                                double saldoComDeposito = contaSelecionada.depositar(valorDeposito);
                                System.out.println("------------------------");
                                System.out.println("Saldo Anterior: " + saldoAnterior);
                                System.out.println("Valor Depósito: " + valorDeposito);
                                System.out.println("Saldo com Depósito: " + contaSelecionada.getSaldo());
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("------------------------");
                                System.out.println("Sacar");
                                System.out.print("Valor: ");
                                double saldoAntecedente = contaSelecionada.getSaldo();
                                double valorSaque = sc.nextDouble();
                                double saldoComSaque = contaSelecionada.sacar(valorSaque);
                                System.out.println("------------------------");
                                System.out.println("Saldo Anterior: " + saldoAntecedente);
                                System.out.println("Valor Saque: " + valorSaque);
                                System.out.println("Saldo após saque: " + contaSelecionada.getSaldo());
                                System.out.println("------------------------");
                                break;
                            case 3:
                                System.out.println("------------------------");
                                System.out.println("Transferir");
                                System.out.print("Conta Destino: ");
                                int resp4 = sc.nextInt();
                                ContaBancaria contaDestino = b1.procurarConta(resp4);
                                if (contaDestino != null) {
                                    System.out.print("Valor: ");
                                    double valorTransf = sc.nextDouble();
                                    double saldoOrigem = contaSelecionada.getSaldo();
                                    double saldoDestino = contaDestino.getSaldo();
                                    contaSelecionada.transferir(valorTransf, contaDestino);
                                    System.out.println("------------------------");
                                    System.out.println("Conta Origem: " + contaSelecionada.getNumConta());
                                    System.out.println("Saldo Anteriror: " + saldoOrigem);
                                    System.out.println("Saldo Atual: " + contaSelecionada.getSaldo());
                                    System.out.println("------------------------");
                                    System.out.println("Conta Destino: " + contaDestino.getNumConta());
                                    System.out.println("Saldo Anterior: " + saldoDestino);
                                    System.out.println("Saldo Atual: " + contaDestino.getSaldo());
                                } else {
                                    System.out.println("Operação Abortada!"); 
                               }
                                System.out.println("------------------------");
                                break;
                            case 4:
                                System.out.println("------------------------");
                                System.out.println("Gerar Relatório");
                                Relatorio relatorio = new Relatorio();
                                relatorio.gerarRelatorio(contaSelecionada);
                                System.out.println("------------------------");
                                break;
                            case 5:
                                System.out.println("------------------------");
                                System.out.println("Retornar ao menu anterior");
                                System.out.println("------------------------");
                                break;
                            default:
                                System.out.println("Opção Inválida!");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("------------------------");
                    System.out.println("Remover Conta");
                    System.out.print("Informe o número da conta: ");
                    int resposta4 = leitor.nextInt();
                    System.out.println("------------------------");
                    b1.removerConta(resposta4);
                    System.out.println("------------------------");
                    break;
                case 4:
                    System.out.println("------------------------");
                    System.out.println("Gerar Relatório");
                    b1.mostrarDados();
                    System.out.println("------------------------");
                    break;
                case 5:
                    System.out.println("------------------------");
                    System.out.println("Operação Finaliza!");
                    System.out.println("------------------------");
                    controle = 1;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
