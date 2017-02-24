package javaapplication1;

import java.util.*;

public class RemoveDuplicates {
	public static void main(String args[]) {
		int[] input = new int[] {2, 3, 8, 7, 10, 10, 1, 8};
		int[] output = new int[input.length];
		Hashtable unique = new Hashtable();
		int i = 0;
		int j = 0;
		while(i < input.length) {
			if (!unique.containsKey(input[i])) {
				output[j] = input[i];
				j++;
			}
			unique.put(input[i], 1);
			i++;
		}
		System.out.println(Arrays.toString(output));
	}
}
