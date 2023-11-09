package lan.zold.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lan.zold.models.Organiser;

public class Filesorter {
    public ArrayList<Long> readNumbers() {
        ArrayList<Long> numlist = null;
        try {
            numlist = tryReadNumbers();
        } catch (FileNotFoundException e) {
            System.err.println("A file nem található.");
            System.err.println(e.getMessage());
        }
        return numlist;
    }

    public ArrayList<Long> tryReadNumbers() throws FileNotFoundException {
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
        ArrayList<Long> sortedlist = new Organiser().quicksort(readNumbers());
        return sortedlist;
    }

    public void write (){
        try {
            tryWrite();
        } catch (IOException e) {
            System.err.println("Nem található a file.");
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
        System.out.println("A számok sikeresen sorba rendezve!");
    }
    public List<String> sortNames() {
        List<String> sortedlist = new Organiser().alphabeticalSort();
        return sortedlist;
    }
    public void writeNames (){
        try {
            tryWriteNames();
        } catch (IOException e) {
            System.err.println("Nem található a file.");
            System.err.println(e.getMessage());
        }
    }
    public void tryWriteNames() throws IOException {
        FileWriter fw = new FileWriter("sortedNames.txt");
        for(String name : sortNames()){
            fw.write(name);
            fw.write("\n");
        }
        fw.close();
        System.out.println("A nevek sikeresen sorba rendezve!");
    }
}
