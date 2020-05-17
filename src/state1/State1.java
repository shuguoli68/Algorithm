package state1;

import java.util.*;

public class State1 {

    public void test1(){
        int[] str = twoSum(new int[]{1, 5, 8, 11, 9, 15},9);
        System.out.println("结果1："+ Arrays.toString(str));

        List<ListNode> list1 = new ArrayList<>();
        list1.add(new ListNode(2));
        list1.add(new ListNode(4));
        list1.add(new ListNode(3));
        list1.get(0).next = list1.get(1);
        list1.get(1).next = list1.get(2);

        int maxLen = lengthOfLongestSubstring("weuedjesfjrtr");
        System.out.println("最长子串长度:"+maxLen);

        String maxL = longestPalindrome("12356787694");
        System.out.println("最长回文子串:"+maxL);

        System.out.println("Z 字形变换:"+convert("LEETCODEISHIRING",4));
        System.out.println("整数反转:"+reverse(13579));
        System.out.println("回文数:"+isPalindrome(13579));
        System.out.println("正则表达式匹配:"+isMatch("aa", "a*"));
    }

    private int[] twoSum(int[] nums, int target) {
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

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            maxLen = Math.max(maxLen,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return maxLen;
    }

    //5. 最长回文子串
    private String longestPalindrome(String s) {
        int sLen = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] P = new boolean[sLen][sLen];
        for (int len = 1; len <= sLen; len++) {
            for (int start = 0; start < sLen; start++) {
                int end = start + len - 1;
                if (end >= sLen) {
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    //6. Z 字形变换
    public String convert(String s, int numRows) {
        if((s==null)||(s.length()==1)||(numRows==1))
            return s;
        char[] arr=s.toCharArray();
        StringBuffer sb=new StringBuffer(arr.length);
        int step=2*numRows-2;//每个满列之间的差值
        int row=0;
        int current=row;
        int currentNeibor=0;
        //第一行
        for (int i=0;i<arr.length;i+=step)
        {
            sb.append(arr[i]);
        }
        row++;
        //中间行
        for(;row<numRows-1;row++)
        {
            current=row;
            while(current<arr.length)
            {
                sb.append(arr[current]);
                currentNeibor=current+step-2*row;
                if (currentNeibor<arr.length)
                    sb.append(arr[currentNeibor]);
                current=current+step;
            }
        }
        //最后一行
        for(;row<arr.length;row+=step)
        {
            sb.append(arr[row]);
        }
        return sb.toString();
    }

    //7. 整数反转
    public int reverse(int x) {
        StringBuffer buf=new StringBuffer();
        if(x>-2147483648||x<2147483647){
            int y=Math.abs(x);
            String s=String.valueOf(y);
            char[] ch=s.toCharArray();
            for(int i=ch.length-1;i>=0;i--){
                buf.append(ch[i]);
            }
            String str=buf.toString();
            try{
                int num=Integer.parseInt(str);
                if(x>=0)
                    x=num;
                if(x<0)
                    x=-num;
                return x;
            }catch(NumberFormatException e){
                System.out.println("NumberFormatException!please input the integer again!");
                return 0;
            }
        }else{
            return 0;
        }
    }

    //9. 回文数
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        int rev= 0;
        int tmp = x;
        while (tmp!=0){
            int p = tmp%10;
            tmp=tmp/10;
            rev = rev * 10 +p ;
        }
        return rev ==x;
    }

    //10. 正则表达式匹配
    public boolean isMatch(String text, String pattern) {
        //如果都为空则匹配成功
        if (pattern.isEmpty()) return text.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //看有没有可能,剩下的pattern匹配上全部的text
            //看有没有可能,剩下的text匹配整个pattern
            //isMatch(text, pattern.substring(2)) 指当p第二个为*时，前面的字符不影响匹配所以可以忽略，所以将*以及*之前的一个字符删除后匹配之后的字符，这就是为什么用pattern.substring(2)
            //如果第一个已经匹配成功，并且第二个字符为*时，这是我们就要判断之后的需要匹配的字符串是否是多个前面的元素（*的功能），这就是first_match && isMatch(text.substring(1), pattern))的意义
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
