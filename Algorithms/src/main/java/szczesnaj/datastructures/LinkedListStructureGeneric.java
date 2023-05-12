/*
 * Copyright (c) 2023 Joanna Szczesna
 * All rights reserved
 */

package szczesnaj.datastructures;

class LinkedListStructureGeneric<E> {
    private NodeGeneric<E> head;

    void addOnStart(E number) {
        head = new NodeGeneric<E>(head, number);
    }

    void addOnEnd(E number) {
        if (head != null) {
            NodeGeneric<E> currentLatest = getLastElementRecursion(head);
            currentLatest.setNext(new NodeGeneric<E>(null, number));
        } else {
            head = new NodeGeneric<E>(head, number);
        }
    }

    String getAllNumbers() {
        return getAllElementsNumbersAsOneStringRecursion(head);
    }

    private NodeGeneric<E> getLastElementRecursion(NodeGeneric<E> list) {
        if (list.getNext() == null) {
            return list;
        }
        return getLastElementRecursion(list.getNext());
    }

    private String getAllElementsNumbersAsOneStringRecursion(NodeGeneric<E> node) {
        if (node == null) {
            return "";
        }
        if (node.getNext() == null) {
            return node.getNumber().toString();
        }
        return node.getNumber() + ", " + getAllElementsNumbersAsOneStringRecursion(node.getNext());
    }

    void removeHead() {
        NodeGeneric<E> newHead = head.getNext();
        head.setNext(null); // help GC
        head = newHead;
    }

    void removeTail() {
        if (head == null) {
            return;
        }
        NodeGeneric<E> oneBefore = head;
        NodeGeneric<E> tail;

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
        NodeGeneric<E> tail = getLastElementRecursion(head);
        findAndRemove(tail, head);
    }

    private void findAndRemove(NodeGeneric<E> node, NodeGeneric<E> list) {
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

class NodeGeneric<E> {
    private NodeGeneric<E> next;
    private final E number;

    NodeGeneric(NodeGeneric<E> next, E number) {
        this.next = next;
        this.number = number;
    }

    void setNext(NodeGeneric<E> next) {
        this.next = next;
    }

    NodeGeneric<E> getNext() {
        return next;
    }

    E getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return " " + number;
    }
}