package lan.zold.models;

import java.util.ArrayList;

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

}
