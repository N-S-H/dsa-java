import Algorithms.BinarySearch;
import Algorithms.MergeSort;
import Algorithms.QuickSort;
import DataStructures.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing trie");
        new Trie().testTrie();

        System.out.println("Testing segment tree");
        new SegmentTree().testSegmentTree();

        System.out.println("Testing merge sort");
        new MergeSort().testMergeSort();

        System.out.println("Testing quick sort");
        new QuickSort().testQuickSort();

        System.out.println("Testing binary search");
        new BinarySearch().testBinarySearch();

        System.out.println("Testing min heap");
        new MinHeap().testMinHeap();

        System.out.println("Testing Linked List");
        new LinkedList().testLinkedList();

        System.out.println("Testing Graph");
        new Graph().testGraph();

         System.out.println("Testing Binary Search Tree");
         new BinarySearchTree().testBinarySearchTree();
    }
}