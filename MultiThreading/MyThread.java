
class MyThread implements Runnable {

    String thrdName;

    public MyThread(String name) {
        thrdName = name;
    }

    @Override
    public void run() {
        System.out.println(thrdName + " starting.");
        try {
            for (int counter = 0; counter < 10; counter++) {
                Thread.sleep(4000);
                System.out.println("In " + thrdName + ", count is " + counter);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + " interrupted.");
        }

        System.err.println(thrdName + " terminating.");
    }

}
