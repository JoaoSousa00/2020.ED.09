package Trees;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Uses.ArrayUnorderedList;
import Uses.ArrayUnorderedList;
import Uses.LinkedQueue;
import Uses.LinkedQueue;
import java.util.Iterator;

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

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;

    /**
     * Creates an empty binary tree.
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[CAPACITY];
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element which will become the root of the new tree
     */
    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree. Throws a NoSuchElementException if the specified target
     * element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++) {
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        }
        if (!found) {
            throw new ElementNotFoundException("Binary tree");
        }
        return temp;
    }

    @Override
    public T getRoot() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T targetElement) {
        try {
            find(targetElement);
        } catch (ElementNotFoundException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        inorder(0, templist);
        return templist.iterator();

    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void inorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inorder(node * 2 + 1, templist);
                templist.addToRear(tree[node]);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preorder(0, templist);
        return templist.iterator();
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void preorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                preorder(node * 2 + 1, templist);
                preorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postorder(0, templist);
        return templist.iterator();
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void postorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                postorder(node * 2 + 1, templist);
                postorder((node + 1) * 2, templist);
                templist.addToRear(tree[node]);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        LinkedQueue tempQueue = new LinkedQueue();
        levelorder(0, templist, tempQueue);
        return templist.iterator();
    }

    /**
     * Performs a recursive levelorder traversal. ???!?!?!?!?! Incorreto
     *
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     * @param tempQueue
     * @throws Exceptions.EmptyCollectionException
     */
    protected void levelorder(int node, ArrayUnorderedList<T> templist, LinkedQueue tempQueue) throws EmptyCollectionException {
        if (node < tree.length) {
            if (tree[node] != null) {
                tempQueue.enqueue(tree[node]);
                while (!tempQueue.isEmpty()) {
                    T temp = (T) tempQueue.dequeue();
                    templist.addToRear(temp);
                    tempQueue.enqueue(tree[node + 1]);
                }
            }
        }
    } //Funfa!?
    
    /**
     * Expands the capacity of the array adding the DEFAULT_CAPACITY.
     */
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[size() + CAPACITY];
        System.arraycopy(tree, 0, newArray, 0, size());
        tree = newArray;
    }
}
