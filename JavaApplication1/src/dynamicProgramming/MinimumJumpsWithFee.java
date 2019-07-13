/*Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step. Implement a method to calculate the minimum fee required to reach the top of the staircase. At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.

Example 1:

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the last index through: 0->3->top
The total fee we have to pay will be (1+2).
Example 2:

Number of stairs (n): 4
Fee: {2,3,4,5}
Output: 5
Explanation: Starting from index '0', we can reach the last index through: 0->1->top
The total fee we have to pay will be (2+3).
*/

import java.util.*;

public class MinimumJumpsWithFee{
    
    public int minJumps(int[] costArr, int step, int costSum) {
        if (step >= costArr.length)
            return costSum;
            
        costSum += costArr[step];
        int minJump1 = minJumps(costArr, step+1, costSum);
        int minJump2 = minJumps(costArr, step+2, costSum);
        int minJump3 = minJumps(costArr, step+3, costSum);
        return minimumNumber(minJump1, minJump2, minJump3);
    }
    
    private int minimumNumber(int num1, int num2, int num3) {
        int min1 = Math.min(num1, num2);
        return Math.min(min1, num3);
    }

     public static void main(String []args){
         int[] costArr = new int[]{1,2,5,2,1,2};
         int step = 0;
         int costSum = 0;
         MinimumJumpsWithFee minJumpsObj = new MinimumJumpsWithFee();
         int minimumJumps = minJumpsObj.minJumps(costArr, step, costSum);
         System.out.println(minimumJumps);
     }
}

/*
Time Complexity: O(3^n);
Space Complexity: O(n);
*/
