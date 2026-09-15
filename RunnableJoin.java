class Thread1 implements Runnable {

    int sum = 0;

    public void run() {

        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }

        System.out.println("Sum of first 100 numbers = " + sum);
    }
}


class Thread2 implements Runnable {

    int sum = 0;

    public void run() {

        for (int i = 101; i <= 200; i++) {
            sum = sum + i;
        }

        System.out.println("Sum of numbers from 101 to 200 = " + sum);
    }
}


class RunnableJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Sum of first 200 numbers = "
                + (t1.sum + t2.sum));
    }
}