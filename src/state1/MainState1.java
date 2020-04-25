package state1;

import java.util.Arrays;

public class MainState1 {

    public static void main(String[] args) {
        int[] str = twoSum(new int[]{1, 5, 8, 11, 9, 15},9);
        System.out.println("结果："+Arrays.toString(str));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0,1};
        for(int i=0;i<nums.length-1;++i){
            for (int j=i+1;j<nums.length;++j){
                if (nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
