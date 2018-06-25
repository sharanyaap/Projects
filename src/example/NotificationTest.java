package example;

/**
 * Created by sharanya.p on 1/5/2018.
 */
public class NotificationTest {

    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {

        final NotificationTest test = new NotificationTest();

        Runnable waitTask = new Runnable() {
            @Override
            public void run() {
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable notfiyTask = new Runnable() {
            @Override
            public void run() {
                test.go();
            }
        };

        Thread t1 = new Thread(waitTask, "t1");
        Thread t2 = new Thread(waitTask, "t2");
        Thread t3 = new Thread(waitTask, "t3");
        Thread t4 = new Thread(notfiyTask, "t4");

        t1.start();
        t2.start();
        // t3.start();

        Thread.sleep(200);

        t4.start();

    }

    private void shouldGo() throws InterruptedException {
        while(go != true){
            System.out.println(Thread.currentThread()
                    + " is going to wait on this object");
            wait(); //release lock and reacquires on wakeup
            System.out.println(Thread.currentThread() + " is woken up");
        }
        go = false; //resetting condition
    }

    private void go() {
        while (go == false){
            System.out.println(Thread.currentThread()
                    + " is going to notify all or one thread waiting on this object");

            go = true; //making condition true for waiting thread
            notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
            //notifyAll(); // all waiting thread  WT1, WT2,WT3 will woke up
        }
    }

}
