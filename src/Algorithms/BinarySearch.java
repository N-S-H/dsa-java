package Algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch {

    public void testBinarySearch() {
        System.out.println("===========Binary Search============");
        int arr[] = {12,56,78,92,111,179,210,475,552};
        System.out.println("Binary search is being performed on the values: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        System.out.println("Search value: 179, exists: "+binarySearch(arr,179));
        System.out.println("Search value: 45, exists: "+binarySearch(arr,45));
        System.out.println("Search value: 7, exists: "+binarySearch(arr,7));
        System.out.println("Search value: 612, exists: "+binarySearch(arr,612));
        System.out.println("Search value: 552, exists: "+binarySearch(arr,552));
    }

    private boolean binarySearch(int[] arr,int val) {
        return binarySearchUtil(0,arr.length-1,arr,val);
    }

    private boolean binarySearchUtil(int l,int r,int[] arr,int value) {
        if(l>r) return false;
        if(l==r) return arr[l]==value;
        int mid=getMid(l,r);
        if(arr[mid]==value) return true;
        else if(arr[mid]>value) return binarySearchUtil(l,mid-1,arr,value);
        else return binarySearchUtil(mid+1,r,arr,value);
    }

    private int getMid(int l,int r) {
        return l+(r-l)/2;
    }
}
