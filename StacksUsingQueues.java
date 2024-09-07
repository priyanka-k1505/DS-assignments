package stacksusingqueues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StacksUsingQueues {
   
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    
    public StacksUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

   
    public void push(int x) {
        queue2.offer(x);

        
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.poll();
    }

    
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }

    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    
    public static void main(String[] args) {
        StacksUsingQueues stack = new StacksUsingQueues();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Pushed " + value + " to the stack.");
                    break;
                case 2:
                    try {
                        int poppedValue = stack.pop();
                        System.out.println("Popped " + poppedValue + " from the stack.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int topValue = stack.top();
                        System.out.println("Top value is " + topValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Stack is " + (stack.isEmpty() ? "empty." : "not empty."));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}