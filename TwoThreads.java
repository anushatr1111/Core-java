class NumberThread extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);
        }
    }
}

class AlphabetThread extends Thread {

    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(c);
        }
    }
}

public class TwoThreads {

    public static void main(String[] args) {

        NumberThread t1 = new NumberThread();
        AlphabetThread t2 = new AlphabetThread();

        t1.start();
        t2.start();
    }
}