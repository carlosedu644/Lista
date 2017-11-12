package EstudoListasJAVA;

import java.util.Scanner;

public class DuplamenteEncadeadaEOrdenada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        No inicio = null;
        No fim = null;
        No aux;
        int op, numero, achou;
        do {
            System.out.println("1-Inserir na lista");
            System.out.println("2-Consultar a lista do inicio ao fim");
            System.out.println("3-Consultar a lista do fim ao inicio");
            System.out.println("4-Remover da lista");
            System.out.println("5-Esvaziar a lista");
            System.out.println("6-Sair");
            System.out.println("Digite a Opção: ");
            op = entrada.nextInt();
            if (op < 1 || op > 6) {
                System.out.println("Opção invalida");

            }
            if (op == 1) {
                System.out.println("Digite o número a ser inserido");
                No novo = new No();
                novo.setElemento(entrada.nextInt());

                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                    novo.setAnterior(null);

                } else {
                    aux = inicio;
                    while (aux != null && novo.getElemento() > aux.getElemento()) {
                        aux = aux.getProximo();
                    }
                    if (aux == inicio) {
                        //se o novo numero for menor que todos os elementos da lista ele sera inserido no inicio
                        novo.setProximo(inicio);
                        novo.setAnterior(null);
                        inicio.setAnterior(novo);
                        inicio = novo;

                    } else if (aux == null) {
                        //o numero a ser inserido é maior que todos os outros elementos
                        fim.setProximo(novo);
                        novo.setAnterior(fim);
                        fim = novo;
                        fim.setProximo(null);
                    } else {
                        //o elemento sera inserido entre dois elementos da lista 
                        novo.setProximo(aux);
                        aux.setAnterior(novo);
                        aux.setProximo(novo);
                        novo.setAnterior(aux.getAnterior());
                        aux.setAnterior(novo);
                    }

                }
                System.out.println("Número inserido na lista");

            }
            if (op == 2) {
                //Consutar a lista do inicio ao fim
                if (inicio == null) {
                    //throw new IllegalArgumentException("Lista Vazia");
                    System.out.println("Lista Vazia");
                } else {
                    aux = inicio;
                    while (aux != null) {
                        System.out.println(aux.getElemento() + " ");
                        aux = aux.getProximo();
                    }
                }

            }
            if (op == 3) {
                //Consultar a lista do fim ao inicio
                if (inicio == null) {
                    System.out.println("Lista Vazia");
                } else {
                    aux = fim;
                    while (aux != null) {
                        System.out.println(aux.getElemento() + " ");
                        aux = aux.getAnterior();
                    }
                }
            }
            if (op == 4) {
                //Remover da lista
                System.out.println("Digite o elemento a ser removido");
                numero = entrada.nextInt();
                aux = inicio;
                achou = 0;

                while (aux != null) {
                    if (aux.getElemento() == numero) {
                        achou += 1;
                        // o numero foi encontrado e sera removido

                    
                    if (aux == inicio) {
                        //caso o numero a ser removido seja o primeiro da lista
                        inicio = aux.getProximo();

                        if (inicio != null) {
                            inicio.setAnterior(null);
                        }
                        aux = inicio;
                    } else if (aux == fim) {
                        //caso o numero a ser removido seja o ultimo da lista
                        fim = fim.getAnterior();
                        fim.setProximo(null);
                        aux = null;
                    }else{
                        //caso o numero a ser removido esteja no meio da lista
                        aux.setAnterior(aux.getProximo());
                        aux.setProximo(aux.getProximo());
                        aux.setProximo(aux.getAnterior());
                        aux.setAnterior(aux.getAnterior());
                        aux = aux.getProximo();
                    }
                }else{
                        aux = aux.getProximo();
                    }

            }
                if(achou == 0){
                    System.out.println("Número não encontrado");
                }else if(achou == 1){
                    System.out.println("Número removido"+achou+"vezes");
                }
                
            }
            
            if(op == 5){
                //Esvaziar a lista
                if(inicio == null){
                    System.out.println("Lista Vazia");
                }else{
                    inicio = null;
                    System.out.println("Lista Vazia");
                }
                    
            }
        } while (op != 6);

    }

}
