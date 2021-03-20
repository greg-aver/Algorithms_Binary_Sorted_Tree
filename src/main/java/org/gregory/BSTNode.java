package org.gregory;

public class BSTNode<T> {
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    public BSTNode(int nodeKey, T nodeValue) {
        NodeKey = nodeKey;
        NodeValue = nodeValue;
        Parent = null;
        LeftChild = null;
        RightChild = null;
    }

    public BSTNode<T> getParent() {
        return Parent;
    }

    public BSTNode<T> getLeftChild() {
        return LeftChild;
    }

    public BSTNode<T> getRightChild() {
        return RightChild;
    }

    public int getKey() {
        return NodeKey;
    }

    public T getValue() {
        return NodeValue;
    }

    public void setLeftChild(BSTNode<T> leftChild) {
        LeftChild = leftChild;
    }

    public void setRightChild(BSTNode<T> rightChild) {
        RightChild = rightChild;
    }

    public void setParent(BSTNode<T> parent) {
        Parent = parent;
    }
/*
    @Override
    public String toString() {
        return "BSTNode{" +
                " NodeKey= " + getKey() +
                " , NodeValue = " + getValue() +
                " , Parent key = " + getParent().getKey() +
                " , LeftChild key = " + getLeftChild().getKey() +
                " , RightChild key = " + getRightChild().getKey() +
                '}';
    }*/

    /*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BSTNode<?> bstNode = (BSTNode<?>) o;

        if (NodeKey != bstNode.NodeKey) return false;
        if (NodeValue != null ? !NodeValue.equals(bstNode.NodeValue) : bstNode.NodeValue != null) return false;
        if (Parent != null ? !Parent.equals(bstNode.Parent) : bstNode.Parent != null) return false;
        if (LeftChild != null ? !LeftChild.equals(bstNode.LeftChild) : bstNode.LeftChild != null) return false;
        return RightChild != null ? RightChild.equals(bstNode.RightChild) : bstNode.RightChild == null;
    }*/
}
