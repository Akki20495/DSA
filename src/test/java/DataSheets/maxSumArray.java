package DataSheets;

public class maxSumArray {
    public static void main(String[] args) {
       int nums[]={1,3,-5,7,8,9,-2};
       int Max= Integer.MIN_VALUE;
       int Sum = 0;

       for(int num: nums){
           Sum= Math.max(Sum,Sum+num);
           Max=Math.max(Max,Sum);
       }
        System.out.println(Max);
    }
}
