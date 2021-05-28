package javaBasics4;

public class DoubleCheckLockA1 {

    //Create singleton double locked
    private static DoubleCheckLockA1 instance = null;
    public String s;

    private DoubleCheckLockA1()
    {
        s = "thiS Is thE EXAMPLE Text";
    }

    //Double check for existing instance in singleton class
    //Ensure only one instance is created per object
    //Double check creates multiple instances if 2 threads access at the same time
    public static DoubleCheckLockA1 getInstance1()
    {
        if(instance == null)
        {
            synchronized (DoubleCheckLockA1.class)
            {
                //Double check
                if (instance == null)
                {
                    instance = new DoubleCheckLockA1();
                }
            }
        }
        return instance;
    }
}

class Main
{

    //Not threadSafe get instances
    //Objects will reference eachother through changes
    static DoubleCheckLockA1 x = DoubleCheckLockA1.getInstance1();
    static DoubleCheckLockA1 y = DoubleCheckLockA1.getInstance1();
    static DoubleCheckLockA1 z = DoubleCheckLockA1.getInstance1();

    public static void printOut()
    {
        System.out.println("x.s = " + x.s);
        System.out.println("y.s = " + y.s);
        System.out.println("z.s = " + z.s);
        System.out.println("\n");
    }
    public static void main(String[] args) {
        printOut();
        y.s = (y.s).toLowerCase(); 
        printOut();
        z.s = (z.s).toUpperCase();
        printOut();
    }
}