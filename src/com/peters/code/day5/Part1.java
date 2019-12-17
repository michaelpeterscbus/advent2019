package com.peters.code.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("src/com/peters/code/day5/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		while ((input = br.readLine()) != null) {
			int result = executeProgram(input);
				}
		}

	public static int executeProgram(String input) {
		String[] stringIntcode = input.split(",");
		int[] intcode = new int[stringIntcode.length];
		for(int i = 0; i < intcode.length; i++) {
			intcode[i] = Integer.parseInt(stringIntcode[i]);
		}
		for (int i = 0; i < intcode.length; i ++) {
			int opcode = intcode[i];
			if(opcode == 99) {
				return intcode[0];
			}
			if (opcode == 1) {
				executeOpcode1(intcode,i);
				i+=3;
			} else if (opcode == 2) {
				executeOpcode2(intcode,i);
				i+=3;
			} else if (opcode == 3) {
				executeOpcode3(intcode,i);
				i++;
			} else if (opcode == 4) {
				executeOpcode4(intcode,i);
				i++;
			} else if (opcode >= 100) {
				
				int currentOpcode = opcode % 10;
				int firstParam = opcode / 100 % 10;
				int secondParam = opcode / 1000 % 10;
				int thirdParam = opcode / 10000 % 10;
				int firstOperand = 0;
				int secondOperand = 0;
				if(currentOpcode == 1 || currentOpcode == 2) {
					if (firstParam == 0) {
						int firstIndex = intcode[i + 1];
						firstOperand = intcode[firstIndex];
					}else {
						firstOperand = intcode[i + 1];
					}
					
					if (secondParam ==0) {
						int firstIndex = intcode[i + 2];
						secondOperand = intcode[firstIndex];
					}else {
						secondOperand = intcode[i + 2];
					}
					int thirdOperand = intcode[i + 3];
					if (currentOpcode == 1) {
						intcode[thirdOperand] = firstOperand + secondOperand;
					}else {
						intcode[thirdOperand] = firstOperand * secondOperand;
					}
					i += 3;
				}
				
				else if (currentOpcode == 3) {
					executeOpcode3(intcode, i);
					i++;
				}else if (currentOpcode == 4) {
					executeOpcode4(intcode, i);
					i++;
				}
					
				
			}
		}
		return intcode[0];
	}
	
	private static void executeOpcode1(int[] intcode, int i) {
		int firstIndex = intcode[i + 1];
		int secondIndex = intcode[i + 2];
		int resultIndex = intcode[i + 3];
		intcode[resultIndex] = intcode[firstIndex] + intcode[secondIndex];
	}
	
	private static void executeOpcode2(int[] intcode, int i) {
		int firstIndex = intcode[i + 1];
		int secondIndex = intcode[i + 2];
		int resultIndex = intcode[i + 3];
		intcode[resultIndex] = intcode[firstIndex] * intcode[secondIndex];
	}
	
	private static void executeOpcode3(int[] intcode, int i) {
		int index = intcode[i + 1];
		intcode[index] = 1;
	}
	
	private static void executeOpcode4(int[] intcode, int i) {
		int index = intcode[i + 1];
		System.out.println(intcode[index]);
	}
}
