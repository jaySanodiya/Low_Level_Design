package com.masai.StratigyPattern;

public class BinarySearch {
    public final SortAlgo sortAlgo;

    public BinarySearch(SortAlgo sortAlgo) {
        // sort the array using this algorithm
        this.sortAlgo = sortAlgo;
    }

    public void searchMytarget(int[] arr){

        sortAlgo.compute(arr);
        /* binary search Algorithm
         * no need to implement that
         * Assume it is here
         */
    }
}

interface SortAlgo{
    void compute(int[] arr);
}

class BubbleSortAlgo implements SortAlgo{

    @Override
    public void compute(int[] arr) {
        System.out.println("Array sorted using bubble sort\n");
    }
}

class SelectionSortAlgo implements SortAlgo {

    @Override
    public void compute(int[] arr) {
        System.out.println("Array sorted using selection sort\n");
    }
}

class OtherSortAlgo  implements SortAlgo{

    @Override
    public void compute(int[] arr) {
        System.out.println("Array sorted using other sort\n");
    }
}

class SearchingRunner {
    public static void main(String[] args) {
        int[] arr={1,3,2}; //unsorted array

        BinarySearch binarySearch1 = new BinarySearch(new BubbleSortAlgo());
        binarySearch1.searchMytarget(arr);

        BinarySearch binarySearch2 = new BinarySearch(new SelectionSortAlgo());
        binarySearch2.searchMytarget(arr);

        BinarySearch binarySearch3 = new BinarySearch(new OtherSortAlgo());
        binarySearch3.searchMytarget(arr);

    }
}