package com.peters.code.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
	public static void main(String[] args) throws IOException {
		File file = new File("src/com/peters/code/day1/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		 String input; 
		 int sum = 0;
		 while ((input = br.readLine()) != null) {
			 sum += Math.floor(Double.parseDouble(input)/3.0) - 2; 
		 }
		System.out.println(sum);
	}
}
