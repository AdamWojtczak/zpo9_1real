import java.util.Stack;

public class Main {
    private static Stack<MyThread> listOfThreads = new Stack<>();

    public static void main(String[] args){
        for (int i = 0 ;i < 10; i++) {
            listOfThreads.add(new MyThread(i));

        }
        while(!listOfThreads.isEmpty())
        {
            listOfThreads.peek().start();
            try {
            listOfThreads.peek().join();
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
            listOfThreads.pop();
        }

    }
    public static class MyThread extends Thread {
        int number;
        MyThread(int i) {
            number = i;
        }
        @Override
        public void run() {
            System.out.println("Hello from task " + number);
        }

    }
}
