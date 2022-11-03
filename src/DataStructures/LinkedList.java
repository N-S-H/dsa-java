package DataStructures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LinkedList {

    private class LinkedListNode {
        int value;
        LinkedListNode next;
        LinkedListNode(int val) {
            this.value=val;
            this.next=null;
        }
    }

    public void testLinkedList() {
        System.out.println("==========Linked List==========");
        int[] arr={25,12,89,44,156,39,2,7};
        System.out.println("About to construct linked list for values: "+ Arrays.stream(arr).mapToObj(val-> String.valueOf(val)).collect(Collectors.joining(", ")));
        LinkedListNode head = constructLinkedList(arr);
        System.out.println("The linked list has been constructed. About to reverse the linked list and print the values");
        head = reverseLinkedList(head);
        printLinkedList(head);
    }

    private void printLinkedList(LinkedListNode head) {
        System.out.println("Linked List Values: ");
        LinkedListNode node=head;
        while(node!=null) {
            System.out.print(node.value);
            if(node.next!=null) System.out.print(" -> ");
            node=node.next;
        }
        System.out.println();
    }

    private LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode previous=null;
        LinkedListNode current=head;
        while(current!=null) {
            LinkedListNode temp=current.next;
            current.next=previous;
            previous=current;
            current=temp;
        }
        return previous;
    }

    private LinkedListNode constructLinkedList(int[] arr) {
        if(arr.length==0) return null;
        LinkedListNode head=new LinkedListNode(arr[0]);
        LinkedListNode currentNode=head;
        for(int i=1;i<arr.length;i++) {
            currentNode.next=new LinkedListNode(arr[i]);
            currentNode=currentNode.next;
        }
        return head;
    }
}
