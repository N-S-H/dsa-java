package DataStructures;

import java.util.Arrays;

public class Trie {
    public static int MAX_TRIE_CHILDREN=26;

    TrieNode node=null;
    class TrieNode {
       TrieNode children[];
       boolean isEndOfWord;
       TrieNode() {
           children = new TrieNode[MAX_TRIE_CHILDREN];
           isEndOfWord=false;
           for(int i=0;i<children.length;i++) {
               children[i]=null;
           }
       }
    }


    public void testTrie() {
        System.out.println("===========Trie===========");
        String[] wordsToInsert = {"Harsha","Thor","Jenkins","Icecube","Ice","Moon","Rhino","Rider","Moan","Monster"};
        Arrays.stream(wordsToInsert).forEach(word-> insertWordToTrie(word.toLowerCase()));
        String[] wordsToTest = {"Throne","Moony","Jenkins","Iceberg","Harsha","Ice","Moaning"};
        Arrays.stream(wordsToTest).forEach(testWord-> {
            System.out.println("Test Word: "+testWord.toLowerCase()+", exists in trie? "+existsInTrie(testWord.toLowerCase()));
        });
    }

    private void insertWordToTrie(String word) {
        System.out.println("Insert Word: "+word);
        if(node==null) {
            node = new TrieNode();
        }
        insertWordUtil(0,word,node);
    }

    private void insertWordUtil(int idx, String word, TrieNode currentNode) {
        int charIdx = getCharacterIndex(word.charAt(idx));
        if(currentNode.children[charIdx]==null) {
            currentNode.children[charIdx] = new TrieNode();
        }

        currentNode = currentNode.children[charIdx];
        if(idx==word.length()-1) currentNode.isEndOfWord=true;
        else insertWordUtil(idx+1,word,currentNode);
    }

    private int getCharacterIndex(char ch) {
        int value = (int)ch-97;
        return value;
    }

    private  boolean existsInTrie(String word) {
        TrieNode currentNode=node;
        for(int i=0;i<word.length();i++) {
            int charIdx=getCharacterIndex(word.charAt(i));
            if(currentNode.children[charIdx]==null) return false;
            currentNode = currentNode.children[charIdx];
        }
        if(currentNode==null || currentNode.isEndOfWord==false) return false;
        return true;
    }
}
