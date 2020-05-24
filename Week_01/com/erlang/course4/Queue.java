package com.erlang.course4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;


/**
 * 除了基本的Collection操作，队列提供额外的插入，提取和检查（查看）操作。
 * 每一种方法以两种形式存在：如果操作失败之一抛出异常，其他返回一个特殊值（ null或false ，这取决于操作）。
 * 插入操作的后一种形式是专为与容量限制的使用而设计的Queue的实现; 在大多数实现中，插入操作不能失败。
 * <p>
 * 　    抛出异常 　　 返回特殊值
 * 插入  add(e)       offer(e)    插入一个元素
 * 移除  remove()     poll()      移除和返回队列的头
 * 检查  element()    peek()      返回但不移除队列的头。
 * <p>
 * 队列通常但不一定，以 FIFO（先进先出）的方式排各个元素
 * 不过优先级队列和 LIFO 队列（或堆栈）例外，前者根据提供的比较器或元素的自然顺序对元素进行排序，后者按 LIFO（后进先出）的方式对元素进行排序。
 * 无论使用哪种排序方式，队列的头都是调用 remove() 或 poll() 所移除的元素。
 * 在 FIFO 队列中，所有的新元素都插入队列的末尾。
 * 其他种类的队列可能使用不同的元素放置规则。
 * 每个 Queue 实现必须指定其顺序属性
 * <p>
 *
 * @param <E> the type of elements held in this collection
 * @author Doug Lea
 * @see java.util.Collection
 * @see LinkedList
 * @see PriorityQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.BlockingQueue
 * @see java.util.concurrent.ArrayBlockingQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.PriorityBlockingQueue
 * @since 1.5
 */
public interface Queue<E> extends Collection<E> {

    /**
     * 插入指定的元素，如果当前队列有可用空间，成功并返回 true
     * 否则会抛出 IllegalStateException
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException    if the element cannot be added at this
     *                                  time due to capacity restrictions
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    boolean add(E e);

    /**
     *
     * 插入指定的元素，如果当前队列有可用空间，成功并返回 true，
     * 否则插入失败，并返回 false
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    boolean offer(E e);

    /**
     * 移除并返回队列头部的元素，如果队列为空，则抛出一个NoSuchElementException异常
     * 区别于 poll 方法，如果队列为空，则返回null
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E remove();

    /**
     * 移除并返回队列头部的元素，如果队列为空，则返回null
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll();

    /**
     * 取出但不移除头部元素，如果队列为空，则抛出一个NoSuchElementException异常
     * 区别于 peek 方法，如果队列为空，则返回null
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E element();

    /**
     * 取出但不移除头部元素，如果队列为空，则返回 null
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();
}


