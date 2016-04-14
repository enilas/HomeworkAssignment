package com.weather.channel.element;

/**
 * Created by Paul on 4/14/2016.
 */
class SinglyLinkedList<E> {

    private ListNode<E> head;
    private ListNode<E> tail;

    void add(E element) {

        ListNode<E> node = new ListNode<>();
        node.setValue(element);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextRef(node);
            tail = node;
        }
    }


    Object nthToLast(ListNode head, int n) {
        if (head == null) {
            throw new NullPointerException("Head is null.");
        } else if (n < 0) {
            throw new IllegalArgumentException("Number is less than 0.");
        }

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            if (p2 == null) {
                throw new IllegalArgumentException("List is shorter than " + n + " elements.");
            }
            p2 = p2.getNextRef();
        }
        while (p2.getNextRef() != null) {
            p1 = p1.getNextRef();
            p2 = p2.getNextRef();
        }
        System.out.println("P1 is: " + p1.getValue());
        return p1.getValue();
    }

    ListNode<E> getHead() {
        return head;
    }

    void setHead(ListNode<E> head) {
        this.head = head;
    }

    ListNode<E> getTail() {
        return tail;
    }

    void setTail(ListNode<E> tail) {
        this.tail = tail;
    }
}
