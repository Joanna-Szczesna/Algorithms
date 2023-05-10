/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.dataStructure;

import java.util.Objects;

class LinkedListStructure {
    private Node head;

    Node getList() {
        return head;
    }

    void addOnStart(Integer number) {
        head = new Node(head, number);
    }

    void addOnEnd(Integer number) {
        if (head != null) {
            Node currentLatest = getLatestElementRecursion(head);
            currentLatest.setNext(new Node(null, number));
        } else {
            head = new Node(head, number);
        }
    }

    String getAllNumbers() {
        return getAllElementsNumbersAsOneStringRecursion(head);
    }

    void printAllNumbers() {
        System.out.println(getAllNumbers());
    }

    private Node getLatestElementRecursion(Node list) {
        if (list.getNext() == null) {
            return list;
        }
        return getLatestElementRecursion(list.getNext());
    }

    private String getAllElementsNumbersAsOneStringRecursion(Node node) {
        if (node == null) {
            return "";
        }
        if (node.getNext() == null) {
            return node.getNumber().toString();
        }
        return node.getNumber() + ", " + getAllElementsNumbersAsOneStringRecursion(node.getNext());
    }

    void removeHead() {
        head = head.getNext();
    }

    void removeTailRecursion() {
        Node tail = getLatestElementRecursion(head);
        findAndRemove(tail.hashCode(), head);
    }

    void removeTail() {
        Node oneBefore = head;
        Node tail;
        if (head != null) {
            if (head.getNext() == null) {
                head = null;
            } else {
                tail = head;
                while (tail.getNext() != null) {
                    oneBefore = tail;
                    tail = tail.getNext();
                }
                oneBefore.setNext(null);
            }
        }
    }

    private Node findAndRemove(int hashCode, Node list) {
        if (list.getNext() == null) {
            if (list == head) {
                head = null;
            }
            return null;
        }
        if (list.getNext().hashCode() == hashCode) {
            list.setNext(null);
            return null;
        }
        return findAndRemove(hashCode, list.getNext());
    }
}

class Node {
    private Node next;
    private Integer number;

    Node(Node next, Integer number) {
        this.next = next;
        this.number = number;
    }

    void setNext(Node next) {
        this.next = next;
    }

    Node getNext() {
        return next;
    }

    Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return " " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(getNext(), node.getNext()) && Objects.equals(getNumber(), node.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNext(), getNumber());
    }
}