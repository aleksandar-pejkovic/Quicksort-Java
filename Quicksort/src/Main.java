package main;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int[] numbers = genArray(15, 100);

		printArray(numbers);

		quicksort(numbers);

		printArray(numbers);

	}

	private static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex) {
			return;
		}

		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];

		swap(array, pivotIndex, highIndex);

		int leftPointer = partitioning(array, lowIndex, highIndex, pivot);

		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);

	}

	private static int partitioning(int[] array, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex;
		int rightPointer = highIndex;

		while (leftPointer < rightPointer) {

			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);

		}

		swap(array, leftPointer, highIndex);
		return leftPointer;
	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static int[] genArray(int length, int maxNum) {

		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = new Random().nextInt(maxNum);
		}
		return numbers;
	}

}
