package com.peters.code.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src/com/peters/code/day2/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		while ((input = br.readLine()) != null) {
			outerloop:
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (executeProgram(input, i, j) == 19690720) {
						System.out.println("noun: " + i);
						System.out.println("verb: " + j);
						System.out.println("answer: " + (100 * i + j));
						break outerloop;
					}
				}
			}
		}
	}

	public static int executeProgram(String input, int noun, int verb) {
		String[] stringIntcode = input.split(",");
		int[] intcode = new int[stringIntcode.length];
		for (int i = 0; i < intcode.length; i++) {
			intcode[i] = Integer.parseInt(stringIntcode[i]);
		}
		intcode[1] = noun;
		intcode[2] = verb;
		for (int i = 0; i < intcode.length; i += 4) {
			int opcode = intcode[i];
			if (opcode == 99) {
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
