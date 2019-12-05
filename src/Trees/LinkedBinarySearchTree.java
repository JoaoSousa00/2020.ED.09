package Trees;

import Exceptions.ElementNotFoundException;
import Interfaces.BinarySearchTreeADT;
import Nodes.BinaryTreeNode;
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
 * Class that represents
 * </p>
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary search
     * tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;
            while (!added) {
                if (comparableElement.compareTo(current.getElement()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(temp);
                        added = true;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(temp);
                        added = true;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.getElement())) {
                result = root.getElement();
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.getElement()) < 0) {
                    current = root.getLeft();
                } else {
                    current = root.getRight();
                }
                while (current != null && !found) {
                    if (targetElement.equals(current.getElement())) {
                        found = true;
                        count--;
                        result = current.getElement();

                        if (current == parent.getLeft()) {
                            parent.setLeft(replacement(current));
                        } else {
                            parent.setRight(replacement(current));
                        }
                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.getElement()) < 0) {
                            current = current.getLeft();
                        } else {
                            current = current.getRight();
                        }
                    }
                } //while

                if (!found) {
                    throw new ElementNotFoundException("binary search tree");
                }
            }
        } // end outer if
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one specified for
     * removal. In the case where the removed node has two children, the inorder
     * successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            result = null;
        } else if ((node.getLeft() != null) && (node.getRight() == null)) {
            result = node.getLeft();
        } else if ((node.getLeft() == null) && (node.getRight() != null)) {
            result = node.getRight();
        } else {
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;
            while (current.getLeft() != null) {
                parent = current;
                current = current.getLeft();
            }
            if (node.getRight() == current) {
                current.setLeft(node.getLeft());
            } else {
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
                current.setLeft(node.getLeft());
            }
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            if (removeElement(targetElement) != null) {
                removeAllOccurrences(targetElement);
            }
        } catch (ElementNotFoundException ex) {
        }
    }

    @Override
    public T removeMin() {
        T res = null;
        try {
            res = removeElement(findMin());
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(LinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public T removeMax() {
        T res = null;
        try {
            res = removeElement(findMax());
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(LinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public T findMin() {
        BinaryTreeNode tmp = root;
        if (root == null) {
            return null;
        } else {
            while (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
            }
        }

        return (T) tmp.getElement();
    }

    @Override
    public T findMax() {
        BinaryTreeNode tmp = root;
        if (root == null) {
            return null;
        } else {
            while (tmp.getRight() != null) {
                tmp = tmp.getRight();
            }
        }
        return (T) tmp.getElement();
    }

}
