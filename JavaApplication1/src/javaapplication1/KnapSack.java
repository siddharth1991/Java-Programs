// This is top-down recrusive approach for KnapSack problem. Below is the question
/*Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5*/

public class KnapSack Problem {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return this.knapsackRecursive(0, 0, 0, 0, capacity, profits, weights);
  }

  private int knapsackRecursive(int selectedElement, int maxProfitTillNow, int maxWeightTillNow, int maxProfit, int maxWeight, int[] profits, int[] weights) {
        if (selectedElement >= weights.length)
            return maxProfitTillNow;
        if ((maxWeightTillNow + weights[selectedElement]) > maxWeight) {
            if (maxProfitTillNow > maxProfit)
                return maxProfitTillNow;
            else
                return maxProfit;
        }
        int maxProfit1 = knapsackRecursive(selectedElement+1, maxProfitTillNow+profits[selectedElement], maxWeightTillNow+weights[selectedElement], maxProfit, maxWeight, profits, weights);
        int maxProfit2 = knapsackRecursive(selectedElement+1, maxProfitTillNow, maxWeightTillNow, maxProfit, maxWeight, profits, weights);
        return Math.max(maxProfit1, maxProfit2);
  }

  public static void main(String[] args) {
    KnapSack ks = new KnapSack();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 11);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}
