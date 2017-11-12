package EstudoListasJAVA;

import java.util.Scanner;

public class DuplamenteEncadeadaNãoOrdenada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        No inicio = null;
        No fim = null;
        No aux = null;
        int op, numero, achou;
        do {
            System.out.println("1-Inserir no inicio");
            System.out.println("2-Inserir no fim");
            System.out.println("3-Consultar a lista do inicio ao fim");
            System.out.println("4-Consultar a lista do fim ao inicio");
            System.out.println("5-Remover da lista");
            System.out.println("6-Esvaziar a lista");
            System.out.println("7-Sair");
            System.out.println("Digite a Opção: ");
            op = entrada.nextInt();
            if (op < 1 || op > 7) {
                System.out.println("Opção invalida");
            }
            if (op == 1) {
                //Inserir no inicio da lista
                System.out.println("Número a ser inserido no inicio da lista");
                No novo = new No();
                novo.setElemento(entrada.nextInt());
                if (inicio == null) {
                    //caso a lista esteja vazia
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                    novo.setAnterior(null);

                } else {
                    //caso a lista ja contenha elementos
                    //eo novo elemento sera inserido no inicio da lista
                    novo.setProximo(inicio);
                    inicio.setAnterior(novo);
                    novo.setAnterior(null);
                    inicio = novo;

                }
                System.out.println("Elemento inserido...");
            }
            if (op == 2) {
                System.out.println("Número a ser inserido no fim da lista");
                No novo = new No();
                novo.setElemento(entrada.nextInt());
                if (inicio == null) {
                    //a lista estava vazia e o elemento sera inserido o primeiro  e o ultimo
                    inicio = novo;
                    fim = novo;
                    novo.setProximo(null);
                    novo.setAnterior(null);

                } else {
                    //caso tenha elemento na minha lista
                    fim.setProximo(novo);
                    novo.setAnterior(fim);
                    novo.setProximo(null);
                    fim = novo;
                }
                System.out.println("Elemento Inserido....");
            }
            if (op == 3) {
                //Consultar a lista do inicio ao fim
                if (inicio == null) {
                    System.out.println("Lista Vazia");
                } else {
                    aux = inicio;
                    while (aux != null) {
                        System.out.println(aux.getElemento() + " ");
                        aux = aux.getProximo();
                    }
                }
            }
            if (op == 4) {
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
            if(op == 5){
                //Remover da lista
                if(inicio == null){
                    System.out.println("Lista Vazia");
                }else{
                    System.out.println("Digite o elemento a ser removido");
                    numero = entrada.nextInt();
                    aux = inicio;
                    achou = 0;
                    while(aux != null){
                        if(aux.getElemento() == numero){
                            achou+=1;
                            if(aux == inicio){
                                //caso o numero seja o primeiro da lista
                                inicio = aux.getProximo();
                                if(inicio != null){
                                    inicio.setAnterior(null);
                                }
                                aux = inicio;
                            }else if(aux == fim){
                                fim = fim.getAnterior();
                                fim.setProximo(null);
                                aux = null;
                            }
                            else{
                                //numero a ser removido esta no meio
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
            }
            if(op == 6){
               //Esvaziar a lista
               if(inicio == null){
                   System.out.println("Lista vazia");
               }else{
                   inicio = null;
                   System.out.println("Lista vazia");
               }
            }

        } while (op != 7);
    }

}
