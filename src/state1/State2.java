package state1;

public class State2 {
    public void test2() {
        System.out.println("11. 盛最多水的容器:"+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println("12. 整数转罗马数字:"+intToRoman(1994));

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
}
