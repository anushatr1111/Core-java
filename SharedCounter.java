class Counter {
    private int count = 0;

    // Synchronized method prevents race condition on the shared resource
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class SharedCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        // Start both threads concurrently
        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        t1.join();
        t2.join();

        // Expected count: 2000 (1000 from t1 + 1000 from t2)
        System.out.println("Final count: " + counter.getCount());
    }
}
