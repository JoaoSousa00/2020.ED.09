package Trees;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Nodes.BinaryTreeNode;
import Uses.ArrayUnorderedList;
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
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected BinaryTreeNode<T> root;
    protected int count;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary
     * tree
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);
    }

    @Override
    public T getRoot() {
        return (T) root.getElement();
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
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.getElement().equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        return temp;
    }

    @Override
    public String toString() {
        String res = "";
        try {
            Iterator<T> it = this.iteratorLevelOrder();

            while (it.hasNext()) {
                res += it.next();
            }
        } catch (EmptyCollectionException ex) {
            return "Empty Collectio";
        }
        return res;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node,
            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        preorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preorder(BinaryTreeNode<T> node,
            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.getElement());
            preorder(node.getLeft(), tempList);
            preorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        postorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postorder(BinaryTreeNode<T> node,
            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postorder(node.getLeft(), tempList);
            postorder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        levelorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive levelorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList
     * @throws Exceptions.EmptyCollectionException
     */
    protected void levelorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList)
            throws EmptyCollectionException {

        LinkedQueue<BinaryTreeNode<T>> tempQueue = new LinkedQueue<>();
        if (node != null) {
            tempQueue.enqueue(node);
            while (!tempQueue.isEmpty()) {
                BinaryTreeNode<T> temp = tempQueue.dequeue();
                tempList.addToRear(temp.getElement());
                if (node.numChildren() > 0) {
                    if (node.getLeft() != null) {
                        tempQueue.enqueue(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        tempQueue.enqueue(node.getRight());
                    }
                }

            }
        }
    }
}
