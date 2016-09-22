package com.multiplicationtable;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private static final int[] factors = { 12, 13, 14, 15, 16, 17, 18, 19, 110, 111, 112 };
	// Random rand =

	public static void main(String[] args) {
		List<Integer> fat = new ArrayList<>();
		for (int factor : factors) {
			fat.add(factor);
		}
		fat.remove(0);
		System.out.println(fat.get(0));
	}

	public void perms(int remaining, String res) {
		if (remaining > 0) {
			perms(remaining - 1, res + "1");
			System.out.println(remaining + " " + res);
		}
	}

}
