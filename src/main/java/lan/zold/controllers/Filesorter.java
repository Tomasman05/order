package lan.zold.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filesorter {
    public void read(){
        try {
            tryRead();
        } catch (FileNotFoundException e) {
            System.err.println("A file nem található.");
            System.err.println(e.getMessage());
        }
    }
    public void tryRead() throws FileNotFoundException{
        File file = new File("C:/Users/diak/Vitovszki/asztali/genum/szamok.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }


        sc.close();
    }
    public void sort(){
    
    }
    public void write(){
    
    }

    }
