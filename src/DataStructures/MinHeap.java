package DataStructures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinHeap {

    public void testMinHeap() {
        System.out.println("==========Heap=========");
        int[] arr={16,12,89,34,77,8,1,56,47};
        System.out.println("Constructing Heap on values: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        heapSort(arr);
        System.out.println("Min heap values: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
    }

    private void heapSort(int[] arr) {
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--) {
            heapify(n,arr,i);
        }

        for(int i=n-1;i>0;i--) {
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(i,arr,0);
        }

    }

    private void heapify(int n,int[] arr,int idx) {
        int smallest = idx;
        if(2*idx+1<n && arr[2*idx+1]<arr[smallest]) {
            smallest=2*idx+1;
        }

        if(2*idx+2<n && arr[2*idx+2]<arr[smallest]) {
            smallest=2*idx+2;
        }

        if(smallest!=idx) {
            int temp=arr[idx];
            arr[idx]=arr[smallest];
            arr[smallest]=temp;
            heapify(n,arr,smallest);
        }

    }



}
