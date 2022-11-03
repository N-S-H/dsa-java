package Algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public void testQuickSort() {
        System.out.println("==========Quick Sort=========");
        int arr[] = {61,79,14,9,36,419,106,322,12};
        System.out.println("The values before sorting: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        quickSort(arr);
        System.out.println("The values after sorting: "+Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
    }

    private void quickSort(int[] arr) {
        quickSortUtil(0,arr.length-1,arr);
    }

    private void quickSortUtil(int l,int r,int[] arr) {
        if(l==r || l>r) return;
        int pi = getPartition(l,r,arr);

        quickSortUtil(l,pi-1,arr);
        quickSortUtil(pi+1,r,arr);
    }

    public int getPartition(int l,int r,int[] arr) {
        int pivot=arr[r];
        int currentIdx=l-1;
        for(int i=l;i<r;i++) {
            if(arr[i]<pivot) {
                currentIdx++;
                int temp=arr[i];
                arr[i]=arr[currentIdx];
                arr[currentIdx]=temp;
            }
        }

        int temp=arr[currentIdx+1];
        arr[currentIdx+1]=arr[r];
        arr[r]=temp;
        return currentIdx+1;
    }
}
