package javaBasics3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

/*
    Append text to an existing txt file
    Assuming that if file DNE -> create file
*/

public class Assignment2 {

    public static void fileErrorHandeling(File f)
    {
        if(f.isDirectory())
        {
            System.out.println(f + " Is a dir. Exiting . . . ");
            System.exit(1);
        }
        else if (!f.exists())
        {
            System.out.println(f + " Does not exist. Creating file " + f);
        }
    }

    public static String fileToString(String str)
    {
        Path path = Paths.get(str);
        try {
            str = Files.readString(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

    //IO Exception handeled with fileErrorHandeling()
    public static void main(String[] args) throws IOException {
        if(args.length != 2)
        {
            System.out.println("\nIncorrect format\n");
            System.out.println(".\\Assignment3.java [toAppend.txt] [appendTo.txt]   OR");
            System.out.println(".\\Assignment3.java \"String\" [appendTo.txt]");
            System.exit(1);
        }


        //Close if arg is a dir and not a file
        File revcFile = new File(args[1]);
        fileErrorHandeling(revcFile);

        File fileTo = new File(args[0]);

        //Makes it easy to append to fw using pw.println(String)
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;


        //FileWriter toAppend = new FileWriter(args[1],true);

        String tmp = args[0];
        //2 cases: args[0] == File || args[0] == String
        if(fileTo.exists())
        {
            tmp = fileToString(tmp);
            System.out.println(tmp + "****");
        }

        //Don't need to catch IO exception, handled in prev method
        fw = new FileWriter(args[1],true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        pw.println(tmp);
        pw.flush();
        pw.close();
        bw.close();
        fw.close();
    }
}