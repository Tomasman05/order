package lan.zold.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Organiser implements iOrganiser {

    @Override
    public ArrayList<Long> quicksort(ArrayList<Long> nums) {
        if (nums.size() <= 1) {
            return nums;
        }
        ArrayList<Long> less = new ArrayList<>();
        ArrayList<Long> equal = new ArrayList<>();
        ArrayList<Long> greater = new ArrayList<>();
        Long pivot = nums.get(nums.size()-1);
        for (Long x : nums) {
            if (x < pivot) less.add(x);
            if (x == pivot) equal.add(x);
            if (x > pivot) greater.add(x);
        }        
        ArrayList<Long> sumList = new ArrayList<Long>();
        sumList.addAll(quicksort(less));
        sumList.addAll(equal);
        sumList.addAll(quicksort(greater));        
        return sumList;
    }
    public List<String> tryAplhabeticalSort() throws IOException{
		FileReader fileReader = new FileReader("C:/Users/diak/Vitovszki/asztali/order/names.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String inputLine;
		List<String> lineList = new ArrayList<String>();
		while ((inputLine = bufferedReader.readLine()) != null) {
			lineList.add(inputLine);
		}
		fileReader.close();

		Collections.sort(lineList);
        return lineList;
    }
    public List<String> alphabeticalSort(){
        List<String> namelist = new ArrayList<>();
        try {
            namelist = tryAplhabeticalSort();
        } catch (IOException e) {
            System.err.println("A file nem található (alphabetical!)");
        }
        return namelist;
    }
}
