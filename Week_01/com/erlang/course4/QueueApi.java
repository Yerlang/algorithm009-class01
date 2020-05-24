package com.erlang.course4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 用add first或add last这套新的API改写Deque的代码
 * @author: erlang
 * @since: 2020-05-24 00:14
 */
public class QueueApi {
    public static void main(String[] args) {
        course();
        System.out.println("=====================================================");
        modifyByAddFirst();
        System.out.println("=====================================================");
        modifyByAddLast();

        PriorityQueue queue = new PriorityQueue();
        queue.add(12);
        queue.add(123);
        queue.add(124);
        queue.add(125);
        queue.add(1);
        queue.add(3);
        System.out.println("---------------------------------------------------------");
        System.out.println(queue);
        System.out.println(queue.remove(123));

    }

    private static void modifyByAddLast() {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("c");
        deque.addLast("b");
        deque.addLast("a");
        operate(deque);
    }

    public static void modifyByAddFirst() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        operate(deque);
    }

    public static void course() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        operate(deque);
    }

    public static void operate(Deque<String> deque) {
        System.out.println(deque);
        String peek = deque.peek();
        System.out.println(peek);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
