package com.peters.code.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src/com/peters/code/day2/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		while ((input = br.readLine()) != null) {
			int result = executeProgram(input);
			System.out.println(result);
				}
		}

	public static int executeProgram(String input) {
		String[] stringIntcode = input.split(",");
		int[] intcode = new int[stringIntcode.length];
		for(int i = 0; i < intcode.length; i++) {
			intcode[i] = Integer.parseInt(stringIntcode[i]);
		}
		for (int i = 0; i < intcode.length; i += 4) {
			int opcode = intcode[i];
			if(opcode == 99) {
				return intcode[0];
			}
			if (opcode == 1) {
				int firstIndex = intcode[i + 1];
				int secondIndex = intcode[i + 2];
				int resultIndex = intcode[i + 3];
				intcode[resultIndex] = intcode[firstIndex] + intcode[secondIndex];
			} else if (opcode == 2) {
				int firstIndex = intcode[i + 1];
				int secondIndex = intcode[i + 2];
				int resultIndex = intcode[i + 3];
				intcode[resultIndex] = intcode[firstIndex] * intcode[secondIndex];
			}
		}
		return intcode[0];
	}
}
