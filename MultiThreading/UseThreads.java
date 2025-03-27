
class UseThreads {

    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        MyThread mt = new MyThread("Child #1");

        Thread newThread = new Thread(mt);

        newThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}
