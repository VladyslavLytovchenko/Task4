package ua.nure.lytovchenko.task4;


import java.util.Arrays;

public class Tree<E extends Comparable<E>> {

    private Node<E> root;
    private Node<E> current;

    Tree() {

    }

    Tree(Node<E> node) {
        this.root = node;
    }

    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            return true;
        } else {
            boolean found = find(element);
            if (found) {
                return false;
            } else {
                if (current.data.compareTo(element) < 0) {
                    current.right = new Node<>(element);
                    current.right.parent = current;
                } else {
                    current.left = new Node<>(element);
                    current.left.parent = current;
                }
                return true;
            }
        }
    }


    public void add(E[] elements) {
        Arrays.stream(elements).forEach(this::add);
    }

    public boolean remove(E element) {
        boolean found = find(element);
        if (!found) {
            return false;
        }
        if (current == root) {
            root = null;
            return true;
        }
        if (current.left == null && current.right == null) {
            current.parent.left = null;
            current.parent.right = null;
        } else if (current.left == null || current.right == null) {
            if (current.left == null) {
                current.data = current.right.data;
                current.right = null;
            } else {
                current.data = current.left.data;
                current.left = null;
            }
        } else {
            Node<E> temp = current;
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            temp.data = current.data;
            if (current.parent == temp) {
                current.parent.right = null;
            } else {
                current.parent.left = null;
            }

        }
        return true;
    }

    public void print() {
        traverseInOrder(root, "");
    }

    public void traverseInOrder(Node node, String space) {
        if (node != null) {
            traverseInOrder(node.left, space + "  ");
            System.out.print(space + node.data + "\n");
            traverseInOrder(node.right, space + "  ");
        }
    }

    private boolean find(E element) {
        current = root;
        while (true) {
            if (current.data.compareTo(element) < 0) {
                if (current.right == null) {
                    return false;
                } else {
                    current = current.right;
                }
            } else if (current.data.compareTo(element) > 0) {
                if (current.left == null) {
                    return false;
                } else {
                    current = current.left;
                }
            } else {
                return true;
            }
        }
    }

    private static class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;
        private E data;

        Node(E data) {
            this.data = data;
        }


    }
}
