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
}
