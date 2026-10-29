package ru.nsu.kagaya.task122;

import com.sun.jdi.Value;

public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> previousNode;
    private Node<K, V> nextNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.previousNode = null;
        this.nextNode = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> getPreviousNode() {
        return previousNode;
    }

    public Node<K, V> getNextNode() {
        return nextNode;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPreviousNode(Node<K, V> newPreviousNode) {
        previousNode = newPreviousNode;
    }

    public void setNextNode(Node<K, V> newNextNode) {
        previousNode = newNextNode;
    }
}
