/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.datastructures;

class LinkedListStructure {
    private Node head;

    void addOnStart(Integer number) {
        head = new Node(head, number);
    }

    void addOnEnd(Integer number) {
        if (head != null) {
            Node currentLatest = getLastElementRecursion(head);
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

    private Node getLastElementRecursion(Node list) {
        if (list.getNext() == null) {
            return list;
        }
        return getLastElementRecursion(list.getNext());
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
        Node newHead = head.getNext();
        head.setNext(null); // help GC
        head = newHead;
    }

    void removeTail() {
        if (head == null) {
            return;
        }
        Node oneBefore = head;
        Node tail;

        if (head.getNext() == null) {
            head = null;
            return;
        }
        tail = head;
        while (tail.getNext() != null) {
            oneBefore = tail;
            tail = tail.getNext();
        }
        oneBefore.setNext(null);

    }

    void removeTailRecursion() {
        Node tail = getLastElementRecursion(head);
        findAndRemove(tail, head);
    }

    private void findAndRemove(Node node, Node list) {
        if (list.getNext() == null) {
            if (list == head) {
                head = null;
            }
            return;
        }
        if (list.getNext() == node) {
            list.setNext(null);
            return;
        }
        findAndRemove(node, list.getNext());
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
}
