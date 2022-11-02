package DataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collectors;

public class SegmentTree {

    public void testSegmentTree() {
        System.out.println("=========Segment Tree========");
        int[] testArr1 = {26,67,19,14,90,3};
        int[] testArr2 = {67,15,98,77,42,8,106};
        testSegmentTreeUtil(testArr1);
        testSegmentTreeUtil(testArr2);
    }

    private void testSegmentTreeUtil(int[] arr) {
        System.out.println("About to insert following values in segment tree: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(",")));
        int[] segmentTree = insertToSegmentTree(arr);
        System.out.println("Sum (1,4): "+findSum(1,4,arr,segmentTree));
        System.out.println("Sum (3,5): "+findSum(3,5,arr,segmentTree));
        System.out.println("About to add 2 to index 2");
        updateSegmentTree(2,arr[2]+2,arr,segmentTree);
         System.out.println("Updated values: "+printUpdatedArray(segmentTree));
        System.out.println("Sum (1,4): "+findSum(1,4,arr,segmentTree));
        System.out.println("Sum (3,5): "+findSum(3,5,arr,segmentTree));
        System.out.println("About to add subtract 16 from index 4");
        updateSegmentTree(4,arr[4]-16,arr,segmentTree);
        System.out.println("Updated values: "+printUpdatedArray(segmentTree));
        System.out.println("Sum (1,4): "+findSum(1,4,arr,segmentTree));
        System.out.println("Sum (3,5): "+findSum(3,5,arr,segmentTree));
    }

    public int[] insertToSegmentTree(int[] arr) {
        int height = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
        int maxSegmentTreeSize = 2*((int)Math.pow(2,height))-1;
        int[] segmentTree = new int[maxSegmentTreeSize];
        insertToSegmentTreeUtil(0,arr.length-1,arr,segmentTree,0);
        return segmentTree;
    }

    public int insertToSegmentTreeUtil(int l,int r,int[] arr, int[] st,int currentIdx) {
        if(l==r) {
            st[currentIdx] = arr[l];
            return st[currentIdx];
        }
        int mid=getMid(l,r);
        st[currentIdx]=insertToSegmentTreeUtil(l,mid,arr,st,2*currentIdx+1) +
                insertToSegmentTreeUtil(mid+1,r,arr,st,2*currentIdx+2);
        return st[currentIdx];
    }

    public int getMid(int l,int r) {
        return l+(r-l)/2;
    }

    public int findSum(int l,int r, int[] arr, int[] st) {
        int totalSum=findSumUtil(0,arr.length-1,l,r,st,0);
        return totalSum;
    }

    public int findSumUtil(int currentStart,int currentEnd, int desiredStart,int desiredEnd,int[] st,int currentIdx) {
        if(currentIdx>=st.length||currentStart>currentEnd||currentStart>desiredEnd || currentEnd<desiredStart) return 0;
        if(currentStart>=desiredStart && currentEnd<=desiredEnd) {
            return st[currentIdx];
        }
        int mid=getMid(currentStart,currentEnd);
        return findSumUtil(currentStart,mid,desiredStart,desiredEnd,st,2*currentIdx+1)+
                findSumUtil(mid+1,currentEnd,desiredStart,desiredEnd,st,2*currentIdx+2);
    }

    public void updateSegmentTree(int idx,int val, int[] arr,int[] st) {
        if(idx>=arr.length) return;
        int diff = val-arr[idx];
        updateSegmentTreeUtil(0,arr.length-1,idx,diff,st,0);
    }

    public void updateSegmentTreeUtil(int l,int r,int idx,int diff,int[] st,int stIdx) {
        if(l>r||idx>r || idx<l) return;
        if(idx>=l && idx<=r) {
            st[stIdx]+=diff;
        }
        int mid=getMid(l,r);
        if(l!=r) {
            updateSegmentTreeUtil(l, mid, idx, diff, st, 2 * stIdx + 1);
            updateSegmentTreeUtil(mid + 1, r, idx, diff, st, 2 * stIdx + 2);
        }
    }

    public String printUpdatedArray(int[] st) {
        //Printing updated array values from segment tree using Depth First Traversal
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        StringBuilder valueBuilder=new StringBuilder();
        while(!stack.isEmpty()) {
            int idx=stack.pop();
            if(2*idx+1<st.length && 2*idx+2<st.length && st[2*idx+1]==0 && st[2*idx+2]==0) {
                valueBuilder.append(st[idx]+" ");
            }

            if(st[idx]!=0 && 2*idx+1>=st.length) valueBuilder.append(st[idx]+" ");
            if(2*idx+2<st.length) {
                stack.push(2*idx+2);
            }
            if(2*idx+1<st.length) {
                stack.push(2*idx+1);
            }

        }
        return valueBuilder.toString();
    }

}
