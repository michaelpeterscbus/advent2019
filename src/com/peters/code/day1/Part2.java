package com.peters.code.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {
	public static void main(String[] args) throws IOException {
		File file = new File("src/com/peters/code/day1/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		 String input; 
		 int sum = 0;
		 while ((input = br.readLine()) != null) {
			 Double mass = Double.parseDouble(input);
			 while(calculateFuel(mass) > 0) {
				 double fuel = calculateFuel(mass);
				 sum += fuel;
				 mass = fuel;
			 }
		 }
		System.out.println(sum);
	}
	
	public static double calculateFuel(Double mass) {
		return Math.floor(mass/3.0) - 2;
	}
}
