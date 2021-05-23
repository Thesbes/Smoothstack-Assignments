package javaBasics3;

//List files/directories/subdirectories of a supplied directory

/*
    Lists format:

    ./Dir
    ./Dir/SubDir
    ./Dir/SubDir/file1
    ./Dir/SubDir/file2
    ./Dir/file3
    ./file4
*/

import java.io.*;

public class Assignment1 {

    /*
        Recursively checks if file is dir

        if dir then listFiles
        ...
        else if file print
    */
    public static void printDir(File f)
    {
        File[] files = f.listFiles();
        for(int i = 0; i<files.length; i++)
        {
            if (files[i].isDirectory() == true)
            {
                System.out.println(files[i]);
                printDir(files[i]);
            }
            else
                System.out.println(files[i]);
        }
    }

    //Only checks that one dir is supplied
    //Does not verifiy if argument is a dir
    public static void main(String[] args) {
        if(args.length != 1)
        {
            System.out.println("\nIncorrect format\njava .\\Assignment1.java [Directory]\nExiting . . .\n");
            System.exit(1);
        }
        String dirName = args[0];

        File f = new File(dirName);

        File[] files = f.listFiles();
        for(int i = 0; i<files.length; i++)
        {
            if (files[i].isDirectory() == true)
            {
                System.out.println(files[i]);
                printDir(files[i]);
            }
            else
                System.out.println(files[i]);
        }
    }
}