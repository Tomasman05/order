package lan.zold.models;

import java.util.ArrayList;

public class Organiser implements iOrganiser {

    @Override
    public ArrayList<Long> bubbleSort(ArrayList<Long> nums) {
        int n = nums.size();

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    Long tmp = nums.get(j);
                    nums.set(j,nums.get(j + 1));
                    nums.set(j + 1,tmp);
                }
            }
        }
        return nums;
    }

}
