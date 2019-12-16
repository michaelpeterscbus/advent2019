package com.peters.code.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

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
		List<List<Integer>> layerList = new ArrayList<List<Integer>>();
		while ((input = br.readLine()) != null) {
			for (int i = 0; i < input.length(); i+=area) {
				List<Integer> layer = new ArrayList<Integer>();
				for (int j = startIndex; j < stopIndex; j++) {
					int num = Character.getNumericValue(input.charAt(j));
					layer.add(num);
				}
				layerList.add(layer);
				startIndex += area;
				stopIndex += area;
					 
			}
		}
		
		int layerCount = layerList.size();
		int[] imageLayer = new int[area];
		for (int j = 0; j < area; j++) {
			innerloop:
			for (int i = 0; i < layerCount; i++) {
				if (layerList.get(i).get(j) != 2) {
					imageLayer[j] = layerList.get(i).get(j);
					break innerloop;
				}
			}
		}
		
		for(int i = 0; i< imageLayer.length; i++) {
			if(i != 0 && i % 25 == 0) {
				System.out.println("");
			}
		
			if (imageLayer[i] == 0) {
				System.out.print(".");
			}else {
				System.out.print("#");
			}
		}
	}

}
