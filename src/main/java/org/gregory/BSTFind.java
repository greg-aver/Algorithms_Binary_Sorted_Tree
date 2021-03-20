package org.gregory;

public class BSTFind<T> {
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() {
        Node = null;
        NodeHasKey = false;
        ToLeft = false;
    }

    public BSTFind(BSTNode<T> node, boolean nodeHasKey, boolean toLeft) {
        Node = node;
        NodeHasKey = nodeHasKey;
        ToLeft = toLeft;
    }

    public BSTFind(BSTNode<T> node, boolean nodeHasKey) {
        Node = node;
        NodeHasKey = nodeHasKey;
        ToLeft = false;
    }

    public BSTNode<T> getNode() {
        return Node;
    }

    public boolean isNodeHasKey() {
        return NodeHasKey;
    }

    public boolean isToLeft() {
        return ToLeft;
    }

    @Override
    public String toString() {
        return "BSTFind{ " +
                "Node = " + getNode().toString() +
                " , NodeHasKey = " + isNodeHasKey() +
                " , ToLeft = " + isToLeft() +
                '}';
    }
}

