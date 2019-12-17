package com.peters.code.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

	public static void main(String[] args) throws IOException {
		File file = new File("src/com/peters/code/day5/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		while ((input = br.readLine()) != null) {
			int result = executeProgram(input, 1);
			//System.out.println(result);
				}
		}

	public static int executeProgram(String nums, int input) {
		String[] stringIntcode = nums.split(",");
		int[] intcode = new int[stringIntcode.length];
		for(int i = 0; i < intcode.length; i++) {
			intcode[i] = Integer.parseInt(stringIntcode[i]);
		}
		for (int i = 0; i < intcode.length; i++) {
			int opcode = intcode[i];
			if(opcode == 99) {
				return intcode[0];
			}
			if (opcode == 1) {
				int firstIndex = intcode[i + 1];
				int secondIndex = intcode[i + 2];
				int resultIndex = intcode[i + 3];
				intcode[resultIndex] = intcode[firstIndex] + intcode[secondIndex];
				i +=3;
			} else if (opcode == 2) {
				int firstIndex = intcode[i + 1];
				int secondIndex = intcode[i + 2];
				int resultIndex = intcode[i + 3];
				intcode[resultIndex] = intcode[firstIndex] * intcode[secondIndex];
				i += 3;
			}else if (opcode == 3) {
				int index = intcode[i + 1];
				intcode[index] = input;
				i++;
			}else if (opcode == 4) {
				int index = intcode[i + 1];
				System.out.println(intcode[index]);
				i++;
			}else if (opcode > 1000) {
				String str = Integer.toString(opcode);
				int firstParam = 0;
				int secondParam =  0;
				int thirdParam = intcode[i + 3];
				if(str.charAt(str.length() - 3) == '0') {
					firstParam = intcode[i+1];
					firstParam = intcode[firstParam];
				}else {
					firstParam = intcode[i + 1];
					}
				if(str.charAt(str.length() - 4) == '0') {
					secondParam = intcode[i+2];
					secondParam = intcode[secondParam];
				}else {
					secondParam = intcode[i + 2];
				}
				if (str.charAt(str.length() - 1) == '1') {
					intcode[thirdParam] = firstParam + secondParam;
				}else {
					intcode[thirdParam] = firstParam * secondParam;
				}
				i += 4;
//			}else if (opcode > 100) {
//				String str = Integer.toString(opcode);
//				if (str.charAt(str.length() - 1) == '3') {
//					int index = intcode[i + 1];
//					intcode[index] = input;
//					i++;
//				}else if (str.charAt(str.length() - 1) == '4') {
//					System.out.println(intcode[i + 1]);
//					i++;
				}
//				}else if (str.charAt(str.length() - 1) == '1') {
//					int firstIndex = intcode[i + 1];
//					int secondIndex = intcode[i + 2];
//					int resultIndex = intcode[i + 3];
//					intcode[resultIndex] = intcode[firstIndex] + intcode[secondIndex];
//					i +=3;
//				} else if (str.charAt(str.length() - 1) == '2') {
//					int firstIndex = intcode[i + 1];
//					int secondIndex = intcode[i + 2];
//					int resultIndex = intcode[i + 3];
//					intcode[resultIndex] = intcode[firstIndex] * intcode[secondIndex];
//					i += 3;
//				}
			
		}
		return intcode[0];
	}
}
