package javaBasics4;

import java.util.ArrayList;

//Thread Producer creates integers
//Consumer take integers
public class PCA3 {

    //Object locks

    public static void main(String[] args) throws InterruptedException {

        PC pc = new PC();

        Thread producer = new Thread()
        {
            public void run()
            {
                try {
                    pc.Producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread consumer = new Thread()
        {
            public void run()
            {
                try {
                    pc.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();
        consumer.start();
    }
}
    
class PC
{
    ArrayList<Integer> nums = new ArrayList<Integer>();
    int capacity = 5;

    public void Producer() throws InterruptedException
    {
        while(true)
        {
            synchronized (this)
            {
                while(nums.size() == capacity)
                    wait();
                nums.add(1);
                System.out.println("P: " + nums);

                notify(); //Wake up waiting threads

                Thread.sleep(1000); //Slowdown to see whats happening
            }
        }
    }
    
    public void Consumer() throws InterruptedException
    {
        while(true)
        {
            synchronized (this)
            {
                while(nums.size() == 0)
                    wait();
                nums.remove(0);
                System.out.println("C: " + nums);

                notify(); //wake up waiting threads

                Thread.sleep(1000); //Slowdown to see whats happening
            }
        }
    }
}