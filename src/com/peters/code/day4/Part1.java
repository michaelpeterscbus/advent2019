package com.peters.code.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Part1 {

	public static void main(String[] args) {
		int count = 0;
		for(int i = 240298; i <= 784956; i++) {
			boolean containsDouble = false;
			boolean nonDecreasing = true;
			String intString = Integer.toString(i);
			int[] numArray = new int[intString.length()];
			for (int j = 0; j < numArray.length; j++) {
				numArray[j] = Integer.parseInt(Character.toString(intString.charAt(j)));
			}
			int[] copyNum = numArray.clone();
			Arrays.sort(numArray);
			if (!Arrays.equals(numArray,copyNum)){
				nonDecreasing = false;
			}else {
				Set<Integer> noDupes = new HashSet<Integer>();
				for (int j = 0; j < numArray.length; j++){
					if (!noDupes.add(numArray[j])) {
						containsDouble = true;
					}
				}
				if (containsDouble && nonDecreasing) {
					count++;
				}
			}
		}
		System.out.print(count);
	}

}
