
package doubleendedqueueusingarray;
import java.util.Arrays;

class ArrayQueue {
    private final int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        rear = 0;
        front = 0;
        count = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        items[rear] = item;
        rear = (rear + 1) % items.length; // Circular increment
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = items[front];
        items[front] = 0; // Optional, for clarity
        front = (front + 1) % items.length; // Circular increment
        count--;
        return item;
    }

    public void addFromFront(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        front = (front - 1 + items.length) % items.length; // Circular decrement
        items[front] = item;
        count++;
    }

    public int removeFromRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        rear = (rear - 1 + items.length) % items.length; // Circular decrement
        int item = items[rear];
        items[rear] = 0; // Optional, for clarity
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        int[] currentItems = new int[count];
        for (int i = 0; i < count; i++) {
            currentItems[i] = items[(front + i) % items.length];
        }
        return Arrays.toString(currentItems);
    }

    public int getRear() {
        return rear;
    }

    public int getFront() {
        return front;
    }
}

public class DoubleEndedQueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        System.out.println("Deleted item = " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        System.out.println("Deleted item = " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        queue.enqueue(40);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        queue.enqueue(50);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        // queue.enqueue(60); // Uncommenting this line will throw an exception
        queue.addFromFront(60);
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
        System.out.println("Deleted item = " + queue.removeFromRear());
        System.out.println(queue);
        System.out.println("Front = " + queue.getFront());
        System.out.println("Rear = " + queue.getRear());
    }
}

