package DataStructures;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinarySearchTree {

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.value=val;
            left=null;
            right=null;
        }
    }
    public void testBinarySearchTree() {
        System.out.println("===========Binary Search Tree============");
        int arr[] = {65,412,36,1,89,12,99,324,188,54,76,33};
        System.out.println("About to construct binary search tree for values: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        TreeNode root = constructBST(arr);
        System.out.println("Preorder traversal");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("Inorder traversal");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Postorder traversal");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("About to find out Lowest common ancestor of 33,54");
        int lca=findLCA(33,54,root);
        System.out.println("The LCA of 33 and 54 is: "+lca);
    }

    public int findLCA(int firstValue,int secondValue,TreeNode root) {
        Stack<Integer> firstStack=new Stack<>();
        Stack<Integer> secondStack=new Stack<>();
        int currentAncestor=root.value;
        findElementInBST(firstValue,firstStack,root);
        findElementInBST(secondValue,secondStack,root);
        while(!firstStack.isEmpty() && !secondStack.isEmpty() && firstStack.peek().intValue()==secondStack.peek().intValue()) {
            currentAncestor=firstStack.pop();
        }
        return currentAncestor;
    }

    public int findElementInBST(int value,Stack<Integer> stack,TreeNode node) {
        if(node==null) return -1;
        if(node.value==value) return node.value;
        int leftValue=findElementInBST(value,stack,node.left);
        int rightValue=findElementInBST(value,stack,node.right);
        if(leftValue!=-1) {
            stack.push(leftValue);
            return node.value;
        }
        if(rightValue!=-1) {
            stack.push(rightValue);
            return node.value;
        }
        return -1;
    }

    public TreeNode constructBST(int[] arr) {
        if(arr.length==0) return null;
        TreeNode root=new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++) {
            insertToBST(arr[i],root);
        }
        return root;
    }

    public void insertToBST(int value, TreeNode currentNode) {
        TreeNode temp=currentNode;
        if(value<temp.value) {
            if(temp.left==null) {
                temp.left = new TreeNode(value);
            } else {
                insertToBST(value,temp.left);
            }
        } else {
            if(temp.right==null) {
                temp.right=new TreeNode(value);
            } else {
                insertToBST(value,temp.right);
            }
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if(node==null) return;
        System.out.print(node.value+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(TreeNode node) {
        if(node==null) return;
        inOrderTraversal(node.left);
        System.out.print(node.value+" ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(TreeNode node) {
        if(node==null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+" ");
    }
}
