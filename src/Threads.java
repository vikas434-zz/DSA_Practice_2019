public class Threads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started on "+Thread.currentThread().getName());
        PrinterMachine printerMachine = new PrinterMachine();
        ExtendingThread extendingThread = new ExtendingThread(printerMachine, "Vikas.pdf", 10);
        extendingThread.start();
        new Thread(new RunnableImplementingThread(printerMachine, "Ranjan2.pdf", 5)).start();
        RunnableImplementingThread runnableImplementingThread = new RunnableImplementingThread(printerMachine, "Ranjan.pdf", 10);
        // runnableImplementingThread.run();
        System.out.println("Application finished on "+Thread.currentThread().getName());
    }
}

class ExtendingThread extends Thread {

    final PrinterMachine printerMachine;
    final String fileName;
    final int noOfCopies;

    public ExtendingThread(PrinterMachine printerMachine, String fileName, int noOfCopies) {
        this.printerMachine = printerMachine;
        this.fileName = fileName;
        this.noOfCopies = noOfCopies;
    }

    @Override
    public synchronized void start() {
        System.out.println("In start method of thread extend");
        super.start();
    }

    @Override
    public void run() {
        try {
            printerMachine.printDocument(fileName,noOfCopies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrinterMachine {
    public PrinterMachine() {
    };

    public synchronized void printDocument(String filename, int noOfCopies) throws InterruptedException {
        for(int i =0; i<noOfCopies; i++) {
            Thread.sleep(200);
            System.out.println("Printing "+filename+" copy no "+i+" on "+Thread.currentThread().getName());
        }
    }
}

class RunnableImplementingThread implements Runnable {

    final PrinterMachine printerMachine;
    final String fileName;
    final int noOfCopies;

    public RunnableImplementingThread(PrinterMachine printerMachine, String fileName, int noOfCopies) {
        this.printerMachine = printerMachine;
        this.fileName = fileName;
        this.noOfCopies = noOfCopies;
    }

    @Override
    public void run() {
        try {
            this.printerMachine.printDocument(this.fileName, this.noOfCopies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}