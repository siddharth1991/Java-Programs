/*Problem Statement
Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the same manner for the following levels.

*/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ZigzagTraversal {
  public static List<List<Integer>> traverseUsingTwoStacks(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Stack<TreeNode> leftToRight = new Stack<>();
    Stack<TreeNode> rightToLeft = new Stack<>();
    if (root == null)
      return null;
    int pos = 0;
    leftToRight.push(root);
    while (!leftToRight.empty() || !rightToLeft.empty()) {
      List<Integer> tempList = new ArrayList<>();
      if (pos == 0) {
        while (!leftToRight.isEmpty()) {
          TreeNode temp = leftToRight.pop();
          if (temp.left != null)
            rightToLeft.push(temp.left);
          if (temp.right != null)
            rightToLeft.push(temp.right);
          tempList.add(temp.val); 
        }
        pos = 1;  
      } else {
        while (!rightToLeft.isEmpty()) {
          TreeNode temp = rightToLeft.pop();
          if (temp.right != null)
            leftToRight.push(temp.right);
          if (temp.left != null)
            leftToRight.push(temp.left);
          tempList.add(temp.val);
        }
        pos = 0;
      }
      result.add(tempList);
    }
    return result;
  }

  public static List<List<Integer>> traverseUsingOneQueue(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root == null)
      return null;
    int pos = 0;
    q.add(root);
    while (!q.isEmpty()) {
      List<Integer> tempList = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.remove(); 
        if (temp.left != null)
          q.add(temp.left);
        if (temp.right != null)
          q.add(temp.right);
        if (pos == 0)
          tempList.add(temp.val);
        else
          tempList.add(0, temp.val);
      }
      if (pos == 0)
        pos = 1;
      else
        pos = 0; 
      result.add(tempList); 
    }
    return result; 
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverseUsingTwoStacks(root);
    System.out.println("Zigzag traversal: " + result);
    List<List<Integer>> result = ZigzagTraversal.traverseUsingOneQueue(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
