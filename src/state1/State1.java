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
}
