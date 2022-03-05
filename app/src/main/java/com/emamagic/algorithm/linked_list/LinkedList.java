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

    private Node getPrevious(Node lastNode) {
        Node currentNode = first;
        while (currentNode != null) {
            if(currentNode.next == lastNode) return currentNode;
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
        Node current = first;
        Node next;
        Node pre = null;
        last = first;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        first = pre;
    }

    // FloydWarshall algorithm
    public int getKthFromTheEnd(int k) throws Exception {
        if (isEmpty())
            throw new Exception("Linked List Is Empty");
        Node a = first;
        Node b = first;
        int distance = k-1;
        while (b.next != null) {
            b = b.next;
            if (--distance < 0) a = a.next;
        }
        return a.value;
    }

    public String middle() throws Exception {
        if (isEmpty())
            throw new Exception("Linked List Is Empty");
        Node a = first;
        Node b = first;
        int distance = 3;
        int length = 0;
        while (a != null) {
            a = a.next;
            if (--distance <= 0) {
                b = b.next;
                distance = 3;
            }
            length++;
        }
        if (length % 2 == 0) return  b.value + " , " + b.next.value;
        else return  "" + b.next.value;
    }

    // when we know the last item
    public String middle2() throws Exception {
        if (isEmpty())
            throw new Exception("Linked List Is Empty");
        Node a = first;
        Node b = first;
        while (a != last && a.next != last) {
            a = a.next.next;
            b = b.next;
        }
        if (a == last) return "" + b.next.value;
        else return   b.value + " , " + b.next.value;
    }

    public boolean hasLoop() {
        Node a = first;
        Node b = first;
        while (a != null && a.next != null) {
            a = a.next.next;
            b = b.next;
            if (a == b) return true;
        }
        return false;
    }

    public void print() {
        if (isEmpty()) {
            builder.append("[]");
        } else {
            Node currentNode = first;
            while (currentNode != null) {
                builder.append(currentNode.value).append(" -> ");
                currentNode = currentNode.next;
            }
            builder.append("Null").append(" -> ");
            builder.delete(builder.length() - 4, builder.length());
        }
        Log.e(TAG, "linked list items :   " + builder);
    }

    public static LinkedList createWithLoop() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        Node node = linkedList.last;
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.last.next = node;
        return linkedList;
    }

}
