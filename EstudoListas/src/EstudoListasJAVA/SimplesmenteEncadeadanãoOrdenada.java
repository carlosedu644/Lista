package EstudoListasJAVA;

import java.util.Scanner;

public class SimplesmenteEncadeadanãoOrdenada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        No inicio = null;
        No fim = null;
        No aux = null;
        No anterior = null;

        int op, numero, achou;

        do {
            System.out.println("1-Inserir");
            System.out.println("2-Inserir no fim");
            System.out.println("3-Consutar toda a lista");
            System.out.println("4-Remover da lista");
            System.out.println("5-Esvaziar a lista");
            System.out.println("6-sair");
            System.out.println("Digite a Opção: ");
            op = entrada.nextInt();

            if (op < 1 || op > 6) {
                System.out.println("Opção invalida");
            }
            if (op == 1) {
                System.out.println("Digite o número a ser inserido na lista");
                No novo = new No();

                novo.setElemento(entrada.nextInt());

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                } else {
                    novo.setProximo(inicio);
                    inicio = novo;
                }
                System.out.println("Número inserido na lista");
            }
            if (op == 2) {
                System.out.println("Digite o número a ser inserido na lista");
                No novo = new No();

                novo.setElemento(entrada.nextInt());

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                } else {
                    fim.setProximo(novo);
                    fim = novo;
                    fim.setProximo(null);
                }
                System.out.println("Número inserido no fim da lista");

            }
            if (op == 3) {
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    System.out.println("Consutando a lista...\n");
                    aux = inicio;
                    System.out.println("-------------------");
                    while (aux != null) {

                        System.out.println(aux.getElemento() + " ");

                        aux = aux.getProximo();
                    }
                    System.out.println("-------------------");
                }
            }
            if (op == 4) {
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    System.out.println("Elemento a ser removido");
                    numero = entrada.nextInt();
                    aux = inicio;
                    anterior = null;
                    achou = 0;
                    while (aux != null) {
                        if (aux.getElemento() == numero) {
                            achou += 1;

                            if (aux == inicio) {
                                inicio = aux.getProximo();
                                aux = inicio;

                            } else if (aux == fim) {
                                anterior.setProximo(null);
                                fim = anterior;
                                aux = null;

                            } else {
                                anterior.setProximo(aux.getProximo());
                                aux = aux.getProximo();

                            }

                        } else {
                            anterior = aux;
                            aux = aux.getProximo();

                        }

                    }
                    if (achou == 0) {
                        System.out.println("Número não encontrado");
                    } else if (achou == 1) {
                        System.out.println("Número removido 1 vez");
                    }
                }
                if (op == 5) {
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        inicio = null;
                        System.out.println("Lista esvaziada");
                    }

                }

            }

        } while (op != 6);

    }
}
