package lan.zold.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import lan.zold.models.Organiser;

public class Filesorter {
    public ArrayList<Long> read() {
        ArrayList<Long> numlist = null;
        try {
            numlist = tryRead();
        } catch (FileNotFoundException e) {
            System.err.println("A file nem található.");
            System.err.println(e.getMessage());
        }
        return numlist;
    }

    public ArrayList<Long> tryRead() throws FileNotFoundException {
        ArrayList<Long> numlist = new ArrayList<>();
        File file = new File("C:/Users/diak/Vitovszki/asztali/genum/szamok.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String numStr = sc.nextLine();
            long num = Long.parseLong(numStr);
            numlist.add(num);
        }
        sc.close();
        return numlist;
    }

    public ArrayList<Long> sort() {
        ArrayList<Long> sortedlist = new Organiser().bubbleSort(read());
        return sortedlist;
    }

    public void write (){
        try {
            tryWrite();
        } catch (Exception e) {
            System.err.println("Nemt található a file.");
            System.err.println(e.getMessage());
        }
    }
    public void tryWrite() throws IOException {
        FileWriter fw = new FileWriter("sorted.txt");
        for(Long num : sort()){
            fw.write(num.toString());
            fw.write("\n");
        }
        fw.close();
    }

}
