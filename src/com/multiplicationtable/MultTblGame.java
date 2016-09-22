package com.multiplicationtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MultTblGame {

	Random rand = new Random();

	private static final int MAX_OFFER = 1;

	private int multiplicationTable;

	private int noOfQuestionsAsked;

	private int noOfCorrectAnswers;

	private int currentRandomIndex;

	private static final int[] factors = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	private List<Integer> factorsList;

	private Map<Integer, Integer> factorCountMap = new HashMap<Integer, Integer>();

	int[] products = null;

	int[] factorsOffered = null;

	public MultTblGame(int multiplicationTable) {

		this.multiplicationTable = multiplicationTable;

		if (multiplicationTable < 2 && multiplicationTable > 12) {
			System.out.println("Please select a valid number ! (2 to 12)");
			return;
		}
		buildTable();

	}

	public void buildTable() {
		factorsList = new ArrayList<>(factors.length);

		products = new int[factors.length];
		factorsOffered = new int[factors.length];
		int index = 0;
		for (int factor : factors) {
			factorsList.add(factor);
			products[index] = factor * multiplicationTable;
			factorsOffered[index] = 0;
			index++;
		}

	}

	public void printTable() {

		int index = 0;
		for (int factor : factors) {
			System.out.println(multiplicationTable + " × " + factor + " = " + products[index]);
			index++;
		}

	}

	public boolean checkAnswer(int index, int userAnswer) {
		noOfQuestionsAsked++;
		if (products[index] == userAnswer) {
			noOfCorrectAnswers++;
			return true;
		}

		return false;

	}

	public int getRandomFactor() {

		int index = rand.nextInt(factorsList.size());

		int factor = factorsList.get(index);

		Integer factorCount = factorCountMap.get(factor);
		if (null != factorCount) {

			while (MAX_OFFER <= factorCount) {

				index = factorsList.size() - 1;
				factor = factorsList.get(index);
				factorsList.remove(index);
				factorCount = factorCountMap.get(factor);
				if (null == factorCount || factorsList.size() == 0)
					break;
			}

		}
		factorCountMap.put(factor, null == factorCount ? 1 : factorCount + 1);
		setCurrentIndex(factor);
		return factor;
	}

	private void setCurrentIndex(int factor) {

		int index = 0;
		for (int i : factors) {

			if (i == factor)
				currentRandomIndex = index;
			index++;

		}

	}

	public int getRandomFactor(int randomIndex) {

		factorsOffered[randomIndex]++;
		return factors[randomIndex];

	}

	public int getNoOfQuestionsAsked() {
		return noOfQuestionsAsked;
	}

	public int getNoOfCorrectAnswers() {
		return noOfCorrectAnswers;
	}

	public int getCurrentRandomIndex() {
		return currentRandomIndex;
	}

	public int getFactorListSize() {
		return factorsList.size();
	}

}
