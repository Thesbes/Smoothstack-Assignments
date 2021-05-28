package javaBasics4;


/*
    NOTE: Program creates a deadlock. 
    Best executed on system IDE with access to process kill
*/

//Threads T1, T2 each hold a resource the other needs to complete action
public class DeadlockHelpA2 {

    //Generic object Locks
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    private static class Thread1 extends Thread
    {
        public void run()
        {
            synchronized (Lock1)
            {
                System.out.println("T1 holding lock 1");

                //Sleep to let thread grab lock
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {} //Thread sleep can throw Interrupted

                System.out.println("T1 waiting for lock 2");

                synchronized (Lock2)
                {
                    System.out.println("T1 holds lock1, lock2");
                }
            }

            System.out.println("T1 releasing Lock1, Lock2");
        }

    }
    private static class Thread2 extends Thread
    {
        public void run()
        {
            synchronized (Lock2)
            {
                System.out.println("T2 holding lock 2");

                //Sleep to lets Thread grab lock
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}

                System.out.println("T2 waiting for lock 1");

                synchronized (Lock1)
                {
                    System.out.println("T2 holds Lock1, Lock2");
                }

            }
            System.out.println("T2 releasing Lock1, Lock2");
        }

    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}