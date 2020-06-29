package state1;

import java.util.HashMap;
import java.util.Map;

public class State2 {
    public void test2() {
        System.out.println("11. 盛最多水的容器:"+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("12. 整数转罗马数字1994:"+intToRoman(1994));
        System.out.println("13. 罗马数字转整数romanToInt:"+romanToInt("MCMXCIV"));
        System.out.println("14. 最长公共前缀:"+longestCommonPrefix3(new String[]{"flower","flow","flight"}));

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
}
