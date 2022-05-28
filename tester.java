import java.util.*;
import java.lang.*;

public class tester {

    //takes an array size as a parameter and generates an unsorted array using Math.random()
    public static int[] arrayGenerator(int datasetSize){
        int[] newArray = new int[datasetSize];
        for (int i = 0; i < datasetSize; i++) {
            int randInt = (int) (Math.random() * 100);
            newArray[i] = randInt;
        }
        return newArray;
    }

	//LINEAR SEARCH
	//searches for target and returns index of target position; if target not found returns -1
	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	} 

	//BINARY SEARCH
	//input array must already be sorted
	public static int binarySearch(int[] arr, int target) {
		int high = arr.length-1;
		int low = 0;

		while (high >= low) {
			int mid = (high + low) / 2;
			if (target > arr[mid]) {
				low = mid + 1;
			} else if (target < arr[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	//SELECTION SORT
	//splits array into sorted and unsorted; swaps the smallest value with the first item in unsorted; repeats
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			swap(arr, findSmallest(arr, i), i);
		}
	}
	//part of selection sort: returns index of smallest value 
	public static int findSmallest(int[] arr, int start) {
		int smallest = start;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] < arr[smallest]) {
				smallest = i;
			}
		}
		return smallest;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//BUBBLE SORT
	//for each pair of adjacent values, comapres values and swaps if they arent in order; repeats
	public static void bubbleSort(int[] arr) {
		boolean swapped = true;
		for (int i = 0; swapped && i < arr.length; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
		}
	}

	//INSERTION SORT
	//splits array into sorted and unsorted; continually copies and sorts first unsorted item into sorted portion; repeat 
	public static void insertionSort(int[] arr) {
		//each for loop is one pass
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; //copy unsorted item out
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) { //move sorted to make space for unsorted
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = temp; //copy item back in
		}
	}


	public static void main(String[] args) {
		System.out.println((2/3) *3);

		System.out.println(8 > 8);

        int[] array1 = arrayGenerator(10);
        System.out.println("unsorted array:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        insertionSort(array1);
        System.out.println("\narray sorted through insertion sort:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        int index = binarySearch(array1, 9);
        System.out.println("\nbinary search for 9: " + index);
	}
}