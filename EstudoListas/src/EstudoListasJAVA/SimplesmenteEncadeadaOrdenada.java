package EstudoListasJAVA;

import java.util.Scanner;

public class SimplesmenteEncadeadaOrdenada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        No inicio = null;
        No fim = null;
        No aux = null;
        No anterior = null;
        int op, numero, achou;

        do {
            System.out.println("1-Inserir");
            System.out.println("2-Consutar toda a lista");
            System.out.println("3-Remover da lista");
            System.out.println("4-Esvaziar a lista");
            System.out.println("5-sair");
            System.out.println("Digite a Opção: ");
            op = entrada.nextInt();

            if (op < 1 || op > 5) {
                System.out.println("Opção invalida");
            }
            if (op == 1) {
                System.out.println("Digite o número a ser inserido na lista");
                No novo = new No();
                novo.setElemento(entrada.nextInt());

                if (inicio == null) {
                    //caso a lista esteja vazia sera inserido no inicio
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                } else {
                    //caso ja tenha elementos ele sera inserido na lista respeitando a ordenação
                    anterior = null;
                    aux = inicio;
                    while (aux != null && novo.getElemento() > aux.getElemento()) {

                        anterior = aux;
                        aux = aux.getProximo();

                    }

                    if (anterior == null) {
                        //O novo numero a ser inserio
                        //é menor do que todos os numeros da lista
                        // logo sera inserido no inicio
                        novo.setProximo(inicio);
                        inicio = novo;

                    } else if (aux == null) {
                        //caso o nume a ser inserido for maior que todos os outros
                        //sera inseriodo no fim da lista
                        fim.setProximo(novo);
                        fim = novo;
                        fim.setProximo(null);
                    } else {
                        //se não,sera inserido no meio da lista
                        anterior.setProximo(novo);
                        novo.setProximo(aux);

                    }

                }
                System.out.println("Número nã inserido");

            }
            if (op == 2) {
                if (inicio == null) {
                    //caso a lista esteja vazia
                    System.out.println("Lista vazia");
                } else {
                    //a lista contem elementos
                    System.out.println("Consutando elementos...\n");
                    aux = inicio;
                    while (aux != null) {

                        System.out.println(aux.getElemento() + " ");
                        aux = aux.getProximo();
                    }
                }
            }
            if (op == 3) {
                //remover da lista
                if (inicio == null) {
                    System.out.println("Lista vazia");
                } else {
                    System.out.println("Digite o elemento a ser removido: ");
                    numero = entrada.nextInt();
                    //vai remover todos os numeros iguais ao numero digitado

                    aux = inicio;
                    anterior = null;
                    achou = 0;
                    while (aux != null) {
                        if (aux.getElemento() == numero) {
                            //o numero digitado foi encontrado na lista
                            achou += 1;
                            if (aux == inicio) {
                                //numero a ser removido
                                //é o primeiro da lista
                                inicio = aux.getProximo();
                                aux = inicio;

                            } else if (aux == fim) {
                                //caso seja o ultimo numero da lista
                                anterior.setProximo(aux.getProximo());
                                aux.setProximo(aux.getProximo());

                            }

                        }
                        if (achou == 0) {
                            System.out.println("Número não encontrado");
                        } else if (achou == 1) {
                            System.out.println("Número removido " + achou + "vez");
                        }

                    }
                    if (op == 4) {
                        //esvaziar a lista
                        if (inicio == null) {
                            //caso a lista esteja vazia
                            System.out.println("Lista vazia");
                        } else {
                            inicio = null;
                            System.out.println("Lista esvaziada");

                        }
                    }
                }

            }
        } while (op != 5);

    }

}
