package Trees;

import Exceptions.ElementNotFoundException;
import Interfaces.BinarySearchTreeADT;

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
 * Class that represents
 * </p>
 */
/**
 * ArrayBinarySearchTree implements a binary search tree using an array.
 *
 * @param <T>
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T>
        implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    /**
     * Adds the specified object to this binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right. Also note that the index of the left child of the current
     * index can be found by doubling the current index and adding 1. Finding
     * the index of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the search tree
     */
    @Override
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        int root = 0;
        if (!isEmpty()) {
            //Se for o root
            if (((Comparable) targetElement).equals(tree[root])) {
                result = tree[root];
                tree[root] = replacement(root);
                count--;
            } else { //Se não for o root
                int current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root) < 0) {
                    current = root * 2 + 1; //Esquerda
                } else {
                    current = (root + 1) * 2; //Direita 
                }
                while (tree[current] != null && !found) {
                    if (targetElement.equals(tree[current])) {
                        result = tree[current];
                        found = true;
                        tree[current] = replacement(current);
                        count--;

                    } else {
                        parent = current;
                        if (((Comparable) targetElement).compareTo(tree[current]) < 0) {
                            current = current * 2 + 1;
                        } else {
                            current = (current + 1) * 2;
                        }
                    }
                }
            }
        }
        return result;
    }

    protected T replacement(int current) {
        T result = null;
        boolean done = false;
        //Se a árvore só tinha o root
        if ((tree[current * 2 + 1] == null) && (tree[(current + 1) * 2] == null)) {
            done = true; //Acaba aqui
        }
        while (!done) {
            if ((tree[current * 2 + 1] != null) && (tree[(current + 1) * 2] == null)) {

                result = tree[current * 2 + 1];

                if ((tree[(current * 2 + 1) * 2 + 1] != null) || (tree[((current * 2 + 1) + 1) * 2] != null)) {
                    //recursivo para puxar o resto dos elementos para o sitio certo
                    tree[current * 2 + 1] = replacement(current * 2 + 1);
                } else {
                    tree[current * 2 + 1] = null;
                }

                done = true; //Acaba aqui
            } else if ((tree[current * 2 + 1] == null) && (tree[(current + 1) * 2] != null)) {

                result = tree[(current + 1) * 2];

                if (tree[((current + 1) * 2) * 2 + 1] != null || tree[(((current + 1) * 2) + 1) * 2] != null) {
                    //recursivo para puxar o resto dos elementos para o sitio certo
                    tree[(current + 1) * 2] = replacement((current + 1) * 2);
                } else {
                    tree[(current + 1) * 2] = null;
                }

                done = true;
                //Não percebi \/\/\/
            } else {
                int currentDireita = (current + 1) * 2;
                int currentEsquerda = current * 2 + 1;
                if (tree[currentDireita * 2 + 1] != null && tree[(currentEsquerda + 1) * 2] == null) {
                    result = tree[currentDireita];
                    tree[currentDireita] = replacement(currentDireita);
                    //Acaba por aqui
                    done = true;

                } else if (tree[currentDireita * 2 + 1] != null && tree[(currentEsquerda + 1) * 2] == null) {
                    result = tree[currentDireita * 2 + 1];
                    tree[currentDireita * 2 + 1] = replacement(currentDireita * 2 + 1);

                    //Acaba por aqui
                    done = true;

                } else if (tree[currentDireita * 2 + 1] == null && tree[(currentEsquerda + 1) * 2] == null) {
                    result = tree[currentDireita];
                    tree[currentDireita] = null;

                    //Acaba por aqui
                    done = true;
                } else {
                    result = tree[currentDireita * 2 + 1];
                    tree[currentDireita * 2 + 1] = replacement(currentDireita * 2 + 1);

                    //Acaba por aqui
                    done = true;
                }
            }
        }

        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            while (removeElement(targetElement) != null) {
                removeAllOccurrences(targetElement);
            }
        } catch (ElementNotFoundException ex) {
        }
    }

    @Override
    public T removeMin() throws ElementNotFoundException {
        return removeElement(findMin());
    }

    @Override
    public T removeMax() throws ElementNotFoundException {
        return removeElement(findMax());
    }

    @Override
    public T findMin() {
        Comparable<T> min = (Comparable<T>) getRoot();
        for (int i = 1; i < tree.length; i++) {
            if (min.compareTo(tree[i]) > 0) {
                min = (Comparable<T>) tree[i];
            }
        }
        return (T) min;
    }

    @Override
    public T findMax() {
        Comparable<T> max = (Comparable<T>) getRoot();
        for (int i = 1; i < tree.length; i++) {
            if (max.compareTo(tree[i]) < 0) {
                max = (Comparable<T>) tree[i];
            }
        }
        return (T) max;
    }

}
