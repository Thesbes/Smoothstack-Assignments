package javaBasics2;
import java.util.concurrent.ThreadLocalRandom;

/*Prompt:
    Construct a 2D array and find the max number and show its position in the array.
  NOTES:
    Some cases will have multiple max values of similiar value. This program returns only 
    first occurance of the MAX number in arr[][].
*/

//2d num array
public class Assignment2 {
    static final int SIZE = 10; //used to create a 2d array of size num[SIZE][SIZE]

    static int[][] num = new int[SIZE][SIZE];
    static int posI, posJ = -1;
    static int max = -1;

    //Fills 2D array with random ints 1-100
    public static void fillRandom(int[][] num)
    {
        for(int i = 0; i<num.length; i++)
            for(int j = 0; j<num.length; j++)
                num[i][j] = ThreadLocalRandom.current().nextInt(1,101);
    }

    public static void printArr(int[][] num)
    {
        System.out.println();
        for(int i = 0; i<num.length; i++)
        {
            for(int j =0; j<num.length; j++)
                System.out.print(num[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void findMax(int[][] num)
    {
        for(int i = 0; i < num.length; i++)
            for(int j = 0; j < num.length; j++)
                if(num[i][j] > max)
                {
                    max = num[i][j];
                    posI = i;
                    posJ = j;
                }
        System.out.println("Max value in num[][] is " + max +" at Position [" + posI + "][" + posJ + "]");
    }
    public static void main(String[] args) {
        fillRandom(num);
        printArr(num);
        findMax(num);
    }
}
