public class ThreadPrintSequential {

    public static void main(String[] args) {
        int num_seq = 100;
        int num_thread = 3;
        Printer printer = new Printer(num_thread, num_seq);
        Thread t1 = new Thread(new SeqRunning(printer, 1), "Thread1");
        Thread t2 = new Thread(new SeqRunning(printer, 2), "Thread2");
        Thread t3 = new Thread(new SeqRunning(printer, 0), "Thread3");
        // Thread t4 = new Thread(new SeqRunning(Printer, 4), "Thread4");

        t1.start();
        t2.start();
        t3.start();
        // t4.start();

    }


}

class SeqRunning implements Runnable {
    Printer sp;
    int result;

    Object sharedObject = new Object();

    public SeqRunning(Printer sp, int result) {
        this.sp = sp;
        this.result = result;
    }

    @Override
    public void run() {
        sp.printSum(result);
    }
}

class Printer {
    int number = 1;
    int numOfThreads;
    int numOfSequence;

    public Printer(int numOfThreads, int numOfSequence) {
        this.numOfThreads = numOfThreads;
        this.numOfSequence = numOfSequence;
    }

    public void printSum(int res ) {
        synchronized (this) {
            while (number < numOfSequence - 1) {
                while (number % numOfThreads != res) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+ " :: " + number++);
                this.notifyAll();
            }
        }
    }
}

