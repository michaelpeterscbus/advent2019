package com.peters.code.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

	public static void main(String[] args) throws IOException {
		int width = 25;
		int height = 6;
		int area = width * height;
		int min0 = area;
		int startIndex = 0;
		int stopIndex = area;
		int result = 0;
		File file = new File("src/com/peters/code/day8/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input; 
		while ((input = br.readLine()) != null) {
			for (int i = 0; i < input.length(); i+=area) {
				int count0 = 0;
				int count1 = 0;
				int count2 = 0;
				for (int j = startIndex; j < stopIndex; j++) {
					int num = Character.getNumericValue(input.charAt(j));
					if(num == 0) {
						count0++;
					}else if (num == 1) {
						count1++;
					}else if (num == 2){
						count2++;
					}

				}
				if (count0 < min0) {
					result = count1 * count2;
					min0 = count0;
				}
				startIndex += area;
				stopIndex += area;
					 
			}
		}
		System.out.println(result);
	}

}
