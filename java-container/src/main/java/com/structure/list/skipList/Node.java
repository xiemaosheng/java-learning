package com.structure.list.skipList;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class Node {
    private String key;
    private int value;
    private Node up;
    private Node down;
    private Node left;
    private Node right;

    public static String header = "---头部---";
    public static String tail = "---尾部---";

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        up = down = left = right = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        Node.header = header;
    }

    public static String getTail() {
        return tail;
    }

    public static void setTail(String tail) {
        Node.tail = tail;
    }
}
