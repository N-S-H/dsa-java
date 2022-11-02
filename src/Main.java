import DataStructures.SegmentTree;
import DataStructures.Trie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing trie");
        new Trie().testTrie();

        System.out.println("Testing segment tree");
        new SegmentTree().testSegmentTree();
    }
}