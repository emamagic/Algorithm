package com.emamagic.algorithm.linked_list;

import android.util.Log;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList {

    private static final String TAG = "LinkedList";
    private final StringBuilder builder = new StringBuilder();

    private Node first;
    private Node last;
    private int length;

    public static class Node {

        private Node next;
        private final int value;

        public Node(int value) {
            this.value = value;
        }

    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        length++;
    }

    public int indexOf(int item) {
        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == item) return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) > -1;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Linked List Is Empty");
        if (first == last) {
            first = last = null;
        } else {
            Node backupNode = first.next;
            first.next = null;
            first = backupNode;
        }
        length--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Linked List Is Empty");
        if (first == last) {
            first = last = null;
        } else {
            Node previous = getPrevious(last);
            last = previous;
            Objects.requireNonNull(previous).next = null;
        }
        length--;
    }

    private Node getPrevious(Node node) {
        Node currentNode = first;
        while (currentNode != null) {
            if(currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public int length() {
        return length;
    }

    public int[] toArray() throws Exception {
        if (isEmpty())
            throw new Exception("Linked List Is Empty");
        int[] array = new int[length];
        Node currentNode = first;
        int index = 0;
        while (currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }

    public void reverse() throws Exception {
        if (isEmpty())
            throw new Exception("Linked List Is Empty");
        Node previousNode = first;
        Node currentNode = first.next;
        last = first;
        last.next = null;
        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        first = previousNode;
    }

    public void print() {
        if (isEmpty()) {
            builder.append("[]");
        } else {
            builder.append('[');
            Node currentNode = first;
            while (currentNode != null) {
                builder.append(currentNode.value).append(", ");
                currentNode = currentNode.next;
            }
            builder.delete(builder.length() - 2, builder.length());
            builder.append(']');
        }
        Log.e(TAG, "linked list items -> " + builder);
    }

}
