package javaBasics3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//File reading for character count of a single char -> command line arguement
public class Assignment3 {

    public static File f;

    public static boolean isFile(String tmp)
    {
        f = new File(tmp);
        if(f.exists())
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        //Args[0] must be a single char
        //Args[1] must be a file
        //no more than 2 args
        if(args.length!=2 || args[0].length()!=1 || !isFile(args[1]))
        {
            System.out.println("\nIncorrect Format");
            System.out.println(".\\Assignment3.java [char] [file]");
        }

        FileReader fr = new FileReader(f); //FileNotFoundException thrown because dealt with when forcing format
        int line;
        int count = 0;
        char c = args[0].charAt(0); //String --> char
        while((line = fr.read()) != -1)
            if((char) line == c) //If char in window == requested value
                count++;
        System.out.println("Total number of " + c + "\'s occuring in " + args[1] + " = " + count);
        fr.close();
    }
}