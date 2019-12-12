package Tests;

import Exceptions.ElementNotFoundException;
import Trees.ArrayBinarySearchTree;
import Trees.LinkedBinarySearchTree;
import java.util.Scanner;

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

    public static void main(String[] args) throws ElementNotFoundException {

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

                        System.out.println("Contains| Should be false and is ... " + lista.contains(2));
                        System.out.println("Size| Should be 0 and is ... " + lista.size());
                        System.out.println("IsEmpty| Should be true and is ... " + lista.isEmpty());

                        try {

                            System.out.println(lista.find(3));

                        } catch (ElementNotFoundException ex) {

                            System.err.println("Método find não encontrou o elemento.");

                            System.out.println("FindMax| Should return null and returns ... " + lista.findMax());
                            System.out.println("FindMin| Should return null and returns ... " + lista.findMin());
                            System.out.println("GetRoot| Should return null and returns ... " + lista.getRoot());
                            System.out.println("RemoveMin| Should return null and returns ... " + lista.removeMin());
                            System.out.println("RemoveMax| Should return null and returns ... " + lista.removeMax());
                            System.out.println("RemoveElement| Should return null and returns ... " + lista.removeElement(1));
                            System.out.print("RemoveAllOccurrences| Initial size:" + lista.size());
                            lista.removeAllOccurrences(3);
                            System.out.println("\tFinal size should be 0 and is ... " + lista.size());
                        }
                        break;

                    case 2:

                        int root = 3;
                        LinkedBinarySearchTree<Integer> lista2 = new LinkedBinarySearchTree<>(root);

                        System.out.println("Contains| Should be true and is ... " + lista2.contains(3));
                        System.out.println("Size| Should be 1 and is ... " + lista2.size());
                        System.out.println("Find| Should return 3 and returns ... " + lista2.find(root));
                        System.out.println("FindMax| Should return 3 and returns ... " + lista2.findMax());
                        System.out.println("FindMin| Should return 3 and returns ... " + lista2.findMin());
                        System.out.println("GetRoot| Should return 3 and returns ... " + lista2.getRoot());
                        System.out.println("IsEmpty| Should be false and is ... " + lista2.isEmpty());
                        System.out.println("RemoveMin| Should return 3 and returns ... " + lista2.removeMin());
                        lista2.addElement(root);
                        System.out.println("RemoveMax| Should return 3 and returns ... " + lista2.removeMax());
                        lista2.addElement(root);
                        System.out.println("RemoveElement| Should return 3 and returns ... " + lista2.removeElement(root));
                        lista2.addElement(root);
                        System.out.print("RemoveAllOccurrences| Initial size:" + lista2.size());
                        lista2.removeAllOccurrences(root);
                        System.out.println("\tFinal size should be 0 and is ... " + lista2.size());

                        break;

                    case 3:

                        LinkedBinarySearchTree<Integer> lista3 = new LinkedBinarySearchTree<>(5);
                        lista3.addElement(1);
                        lista3.addElement(2);
                        lista3.addElement(7);
                        lista3.addElement(4);
                        lista3.addElement(5);

                        System.out.println("Size| Should be 6 and is ... " + lista3.size());
                        System.out.println("Find| Should return 4 and returns ... " + lista3.find(4));
                        System.out.println("FindMax| Should return 7 and returns ... " + lista3.findMax());
                        System.out.println("FindMin| Should return 1 and returns ... " + lista3.findMin());
                        System.out.println("GetRoot| Should return 5 and returns ... " + lista3.getRoot());
                        System.out.println("RemoveMin| Should return 1 and returns ... " + lista3.removeMin());
                        System.out.println("RemoveMax| Should return 7 and returns ... " + lista3.removeMax());
                        System.out.println("RemoveElement| Should return 4 and returns ... " + lista3.removeElement(4));
                        System.out.print("RemoveAllOccurrences| Initial size:" + lista3.size());
                        lista3.removeAllOccurrences(5);
                        System.out.println("\tFinal size should be 1 and is ... " + lista3.size());

                        break;
                }
                break;

            case 2:
                System.out.println("\nEstado do Sistema:\nEstado 1 - Coleção Vazia\nEstado 2 - Coleção só com root\nEstado 3 - Coleção não vazia\n\nQue método pretende executar:");
                int c = scanner.nextInt(4);
                switch (c) {
                    case 1:
                        ArrayBinarySearchTree<Integer> lista = new ArrayBinarySearchTree<>();

                        System.out.println("Contains| Should be false and is ... " + lista.contains(2));
                        System.out.println("Size| Should be 0 and is ... " + lista.size());
                        System.out.println("IsEmpty| Should be true and is ... " + lista.isEmpty());

                        try {

                            System.out.println(lista.find(3));

                        } catch (ElementNotFoundException ex) {

                            System.err.println("Método find não encontrou o elemento.");

                            System.out.println("FindMax| Should return null and returns ... " + lista.findMax());
                            System.out.println("FindMin| Should return null and returns ... " + lista.findMin());
                            System.out.println("GetRoot| Should return null and returns ... " + lista.getRoot());
                            System.out.println("RemoveMin| Should return null and returns ... " + lista.removeMin());
                            System.out.println("RemoveMax| Should return null and returns ... " + lista.removeMax());
                            System.out.println("RemoveElement| Should return null and returns ... " + lista.removeElement(1));
                            System.out.print("RemoveAllOccurrences| Initial size:" + lista.size());
                            lista.removeAllOccurrences(3);
                            System.out.println("\tFinal size should be 0 and is ... " + lista.size());
                        }
                        break;
                    case 2:
                        int root = 3;
                        ArrayBinarySearchTree<Integer> lista2 = new ArrayBinarySearchTree<>(root);

                        System.out.println("Contains| Should be true and is ... " + lista2.contains(3));
                        System.out.println("Size| Should be 1 and is ... " + lista2.size());
                        System.out.println("Find| Should return 3 and returns ... " + lista2.find(root));
                        System.out.println("FindMax| Should return 3 and returns ... " + lista2.findMax());
                        System.out.println("FindMin| Should return 3 and returns ... " + lista2.findMin());
                        System.out.println("GetRoot| Should return 3 and returns ... " + lista2.getRoot());
                        System.out.println("IsEmpty| Should be false and is ... " + lista2.isEmpty());
                        System.out.println("RemoveMin| Should return 3 and returns ... " + lista2.removeMin());
                        lista2.addElement(root);
                        System.out.println("RemoveMax| Should return 3 and returns ... " + lista2.removeMax());
                        lista2.addElement(root);
                        System.out.println("RemoveElement| Should return 3 and returns ... " + lista2.removeElement(root));
                        lista2.addElement(root);
                        System.out.print("RemoveAllOccurrences| Initial size:" + lista2.size());
                        lista2.removeAllOccurrences(root);
                        System.out.println("\tFinal size should be 0 and is ... " + lista2.size());

                        break;
                    case 3:

                        ArrayBinarySearchTree<Integer> lista3 = new ArrayBinarySearchTree<>(5);
                        lista3.addElement(1);
                        lista3.addElement(2);
                        lista3.addElement(7);
                        lista3.addElement(4);
                        lista3.addElement(5);

                        System.out.println("Size| Should be 6 and is ... " + lista3.size());
                        System.out.println("Contains| Should be true and is ... " + lista3.contains(4));
                        System.out.println("Find| Should return 4 and returns ... " + lista3.find(4));
                        System.out.println("FindMax| Should return 7 and returns ... " + lista3.findMax());
                        System.out.println("FindMin| Should return 1 and returns ... " + lista3.findMin());
                        System.out.println("GetRoot| Should return 5 and returns ... " + lista3.getRoot());
                        System.out.println("RemoveMin| Should return 1 and returns ... " + lista3.removeMin());//Errado
                        System.out.println("RemoveMax| Should return 7 and returns ... " + lista3.removeMax());
                        System.out.println("RemoveElement| Should return 4 and returns ... " + lista3.removeElement(4));//Errado
                        System.out.print("RemoveAllOccurrences| Initial size:" + lista3.size());
                        lista3.removeAllOccurrences(5);
                        System.out.println("\tFinal size should be 1 and is ... " + lista3.size());

                        break;

                }

        }

    }

}
