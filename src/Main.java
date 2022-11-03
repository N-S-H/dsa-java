import Algorithms.BinarySearch;
import Algorithms.MergeSort;
import Algorithms.QuickSort;
import DataStructures.SegmentTree;
import DataStructures.Trie;

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
    }
}