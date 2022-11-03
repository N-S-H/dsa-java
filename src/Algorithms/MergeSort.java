package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {


    public void testMergeSort() {
        System.out.println("============Merge Sort============");
        int arr[] = {61,79,14,9,36,419,106,322,12};
        System.out.println("The values before sorting: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        mergeSort(arr);
        System.out.println("The values after sorting: "+Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
    }

    private void mergeSort(int[] arr) {
        mergeSortUtil(0,arr.length-1,arr);
    }

    private void mergeSortUtil(int l,int r,int[] arr) {
       if(l>r || l==r) return;
       int mid=getMid(l,r);
       mergeSortUtil(l,mid,arr);
       mergeSortUtil(mid+1,r,arr);
       merge(l,mid,r,arr);
    }

    private void merge(int l,int mid,int r,int[] arr) {
        int p1=l;
        int p2=mid+1;
        List<Integer> tempList = new ArrayList<>();
        while(p1<=mid && p2<=r) {
            if(arr[p1]<arr[p2]) {
                tempList.add(arr[p1]);
                p1++;
            } else {
                tempList.add(arr[p2]);
                p2++;
            }
        }

        while(p1<=mid) {
            tempList.add(arr[p1]);
            p1++;
        }

        while(p2<=r) {
            tempList.add(arr[p2]);
            p2++;
        }

        for(int i=l;i<=r;i++) {
            arr[i]=tempList.get(i-l);
        }
    }

    private int getMid(int l,int r) {
        return l+(r-l)/2;
    }
}
