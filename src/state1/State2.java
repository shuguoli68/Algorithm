package state1;

import java.util.*;

public class State2 {
    public void test2() {
        System.out.println("11. 盛最多水的容器:"+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("12. 整数转罗马数字1994:"+intToRoman(1994));
        System.out.println("13. 罗马数字转整数romanToInt:"+romanToInt("MCMXCIV"));
        System.out.println("14. 最长公共前缀:"+longestCommonPrefix3(new String[]{"flower","flow","flight"}));
        System.out.println("15. 三数之和:"+threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("16. 最接近的三数之和:"+threeSumClost(new int[]{-1,2,1,-4}, 1));
        System.out.println("17. 电话号码的字母组合:"+letterCombinations("23"));

    }

    //11. 盛最多水的容器
    public int maxArea(int[] height) {
        int n=height.length;
        int pre=0,next=n-1,max=0;
        while(pre<next){
            max=height[pre]>height[next]?Math.max(max,(next-pre)*height[next--]):Math.max(max,(next-pre)*height[pre++]);
        }
        return max;
    }

    //12. 整数转罗马数字
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                num=num-values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

    //13. 罗马数字转整数
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            }
            else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;

    }

    //14. 最长公共前缀
    public String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for(int i=0; i<strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length()-1);
                if(result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }

    //15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if(i>=1&&nums[i]==nums[i-1])//去重1，i是从前往后，所以与i-1比较。
                continue;
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while(j<k&&nums[j]==nums[j-1])j++;//去重2,j是从前往后，所以与j-1比较
                    while(j<k&&nums[k]==nums[k+1])k--;//去重3，k是从后往前，与k+1比较。
                }else if(nums[i]+nums[j]+nums[k]>0)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }

    //16. 最接近的三数之和
    public  static int threeSumClost(int[] nums,int target){
        Arrays.sort(nums);
        int clost = Integer.MAX_VALUE,sub = 0,abssub = 0,sum = 0; // 定义最接近的数,目前差值
        for(int i = 1 ; i < nums.length - 1 ; i++){
            int left = 0, right = nums.length - 1;
            while(left < i && right > i){

                sub = nums[left] + nums[right] + nums[i] - target;
                abssub = Math.abs(sub);

                if(clost > abssub){
                    clost = abssub;
                    sum = nums[left] + nums[right] + nums[i] ;
                }
                if(sub > 0){ right--;}
                else if(sub < 0 ){ left++;}
                else{ sum = nums[left] + nums[right] + nums[i] ; break; }
            }
        }
        return sum;
    }

    //17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if(digits.length() == 0) return ans;
        Map<Integer, String> dictionary = new HashMap<Integer, String>();
        dictionary.put(2, "abc");
        dictionary.put(3, "def");
        dictionary.put(4, "ghi");
        dictionary.put(5, "jkl");
        dictionary.put(6, "mno");
        dictionary.put(7, "pqrs");
        dictionary.put(8, "tuv");
        dictionary.put(9, "wxyz");

        for(int digitsIndex = 0; digitsIndex < digits.length(); digitsIndex++){
            String s = dictionary.get(digits.charAt(digitsIndex) - 48);
            if(digitsIndex == 0){
                for(int sIndex = 0; sIndex < s.length(); sIndex++){
                    ans.add(s.substring(sIndex, sIndex + 1));
                }
            }
            else{
                int ansLength = ans.size();
                for(int ansIndex = 0; ansIndex < ansLength; ansIndex++){
                    String oldElement = ans.remove(0);
                    int sLength = s.length();
                    for(int sIndex = 0; sIndex < sLength; sIndex++){
                        ans.add(oldElement + s.substring(sIndex, sIndex + 1));
                    }
                }
            }
        }
        return ans;
    }
}
