package com.company;
import java.util.*;

class Node {
    private int value;
    private Node left;
    private Node right;
    public int getValue() {
        return this.value;
    }
    public void setValue(final int value) {
        this.value = value;
    }
    public Node getLeft() {
        return this.left;
    }
    public void setLeft(final Node left) {
        this.left = left;
    }
    public Node getRight() {
        return this.right;
    }
    public void setRight(final Node right) {
        this.right = right;
    }
}

class Tree {
    private Node rootNode;
    public Tree() {
        rootNode = null;
    }
    public Node findNodeByValue(int value) {
        Node currentNode = rootNode;
        while (currentNode.getValue() != value) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }
    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }
    public void deleteNode(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeft = true;
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null)
                return;
        }
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeft)
                parentNode.setLeft(null);
            else
                parentNode.setRight(null);
        } else if (currentNode.getRight() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeft();
            else if (isLeft)
                parentNode.setLeft(currentNode.getLeft());
            else
                parentNode.setRight(currentNode.getLeft());
        } else if (currentNode.getLeft() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getRight();
            else if (isLeft)
                parentNode.setLeft(currentNode.getRight());
            else
                parentNode.setRight(currentNode.getRight());
        } else {
            Node heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeft)
                parentNode.setLeft(heir);
            else
                parentNode.setRight(heir);
        }
    }
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRight();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        if (heirNode != node.getRight()) {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }
    public void createList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node current = rootNode;
        while (rootNode != null){
            if (current.getRight() != null)
                current = current.getRight();
            else {
                list.add(current.getValue());
                deleteNode(current.getValue());
                current = rootNode;
            }
        }
        System.out.println("Your list:");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
            insertNode(list.get(i));
        }
    }
}

public class Lab7 {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insertNode(469465);
        tree.insertNode(469321);
        tree.insertNode(469563);
        tree.insertNode(469129);
        tree.insertNode(469873);
        tree.insertNode(469999);
        tree.insertNode(469010);
        tree.createList();
        tree.deleteNode(469873);
        tree.deleteNode(469129);
        tree.createList();
    }
}