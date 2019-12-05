package Tests;

import Exceptions.ElementNotFoundException;
import Trees.LinkedBinarySearchTree;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 *
 * </p>
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tTestes Disponiveis:\nTeste 1 - Exercicio 1\nTeste 2 - Exercicio 2\n\nQue Teste pretende efetuar:");
        int a = scanner.nextInt(3); //Aceita só até 2

        switch (a) {
            case 1:
                System.out.println("\nEstado do Sistema:\nEstado 1 - Coleção Vazia\nEstado 2 - Coleção só com root\nEstado 3 - Coleção não vazia\n\nQue método pretende executar:");
                int b = scanner.nextInt(4);
                switch (b) {
                    case 1:
                        LinkedBinarySearchTree<Integer> lista = new LinkedBinarySearchTree<>();
                        lista.contains(2);
//                        try {
//                            lista.find(3);
//                        } catch (ElementNotFoundException ex) {
//                            System.err.println("Método find não encontrou o elemento.");
//                        }
                        lista.findMax();
                        lista.findMin();
                        lista.getRoot();
                        lista.isEmpty();
                        lista.removeMin();
                        lista.removeMax();
//                        try {
//                            lista.removeElement(1);
//                        } catch (ElementNotFoundException ex) {
//                            System.err.println("Método removeElement não encontrou o elemento.");
//                        }
                        lista.removeAllOccurrences(3);
                        lista.size();
                        break;

                    case 2:

                    case 3:

                }
                break;
            case 2:
                System.out.println("\nEstado do Sistema:\nEstado 1 - Coleção Vazia\nEstado 2 - Coleção só com root\nEstado 3 - Coleção não vazia\n\nQue método pretende executar:");
                int c = scanner.nextInt(4);
                switch (c) {
                    case 1:

                    case 2:

                    case 3:

                }

        }

    }

}
