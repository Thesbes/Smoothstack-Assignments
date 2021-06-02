package javaBasics5;

import java.util.Arrays;

public class BasicLambdasA1_1 {


    static String[] strArr = buildStr();

    private static String[] buildStr()
    {
        String[] tmp = new String[7];
        //An excerpt from Alice in Wonderland
        tmp[0] = "Sister: Alice…! Will you kindly pay attention to your history lesson? z";
        tmp[1] = "Alice: I’m sorry, but how can one possibly pay attention to a book with no pictures in it?";
        tmp[2] = "Sister: My dear child, there are a great many good books in this world without pictures.";
        tmp[3] = "Alice: In this world perhaps. But in my world, the books would be nothing but pictures.";
        tmp[4] = "Sister: Your world? Huh, what nonsense. Now…";
        tmp[5] = "Alice: Nonsense?";
        tmp[6] = "Sister: Once more. From the beginning.";
        return tmp;
    }

    private static void printArr()
    {
        Arrays.stream(strArr).forEach(str -> System.out.println(str));
        System.out.println();
    }

    //sort str[] by length largest to smallest
    private static void forLength()
    {
        Arrays.sort(strArr,
                (String a, String b) -> a.length() - b.length());
    }
    //Sort by length smallest to largest
    private static void revLength()
    {
        Arrays.sort(strArr,
                (a,b) -> b.length() - a.length());
    }
    //Sort alphabetically by first letter
    private static void alphabet()
    {
        Arrays.sort(strArr,
                (a,b) -> a.charAt(0) - b.charAt(0));
    }

    //Sorts by first occurance of e in str
    //Non occurances are printed last based on length 
    private static void e()
    {
        Arrays.sort(strArr,
                (a,b) -> -a.indexOf('e'));

    }
    public static void main(String[] args) {
        printArr();
        forLength();
        printArr();
        revLength();
        printArr();
        alphabet();
        printArr();
        e();
        printArr();
    }
}
