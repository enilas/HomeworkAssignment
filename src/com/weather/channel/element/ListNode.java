package com.weather.channel.element;

/**
 * Created by Paul on 4/14/2016.
 */
class ListNode<E> {

    private E value;
    private ListNode<E> nextRef;

    E getValue() {
        return value;
    }

    void setValue(E value) {
        this.value = value;
    }

    ListNode<E> getNextRef() {
        return nextRef;
    }

    void setNextRef(ListNode<E> ref) {
        this.nextRef = ref;
    }
}
