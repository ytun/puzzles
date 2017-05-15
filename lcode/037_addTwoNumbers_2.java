import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
      this.val = val;
    }

    public String toString(){
      return ""+val;
    }
  }

  // public ListNode addTwoNumbers(ListNode l1, ListNode l2){
  //   int sum = 0;
  //   ListNode sumNode = new ListNode(0);
  //   ListNode head = sumNode;
  //   // int carryOver =0;

  //   while(l1!=null || l2!=null){
      
  //     sum = l1.val + l2.val;

  //     if(sum<10){
  //       sumNode.val += sum;
  //       if(l1.next!=null || l2.next!=null){
  //        sumNode.next = new ListNode(0);
  //       }
  //     }
  //     else{
  //       sumNode.val += sum%10;
  //       sumNode.next = new ListNode(sum/10);
  //     }

  //     sumNode = sumNode.next;

  //     l1= l1.next;
  //     l2= l2.next;
  //   }

  //   return head;
  // }

  // public ListNode addTwoNumbers(ListNode l1, ListNode l2){
  //   int sum = 0;
  //   ListNode sumNode = new ListNode(0);
  //   ListNode head = sumNode;
  //   // int carryOver =0;

  //   while(sumNode!=null){//l1!=null || l2!=null){
      
  //     if(l1!=null){
  //       sum += l1.val;
  //       l1= l1.next;
  //     }

  //     if(l2!=null){
  //       sum += l2.val;
  //       l2= l2.next;
  //     }

  //     // sum = l1.val + l2.val;

  //     if(sum<10){
  //       sumNode.val += sum;

  //       if( (l1!=null && l1.next!=null) || (l2!=null && l2.next!=null) ){
  //        sumNode.next = new ListNode(0);
  //       }
  //     }
  //     else{
  //       sumNode.val += sum%10;
  //       sumNode.next = new ListNode(sum/10);
  //     }

  //     sumNode = sumNode.next;
  //   }

  //   return head;
  // }

  public ListNode addTwoNumbers_copyOneListAndAdd(ListNode l1, ListNode l2){

    ListNode curr = l1;
    ListNode sumNode = new ListNode(0);
    ListNode head = sumNode;

    //copy the first listNode
    while(l1!=null){
      sumNode.val = l1.val;

      if(l1.next!=null){
        sumNode.next = new ListNode(0);
      }
      l1 = l1.next;
      sumNode = sumNode.next;
    }

    sumNode = head;

    // Solution sol = new Solution();
    // sol.print(sumNode);

    while(l2!=null || sumNode!=null){

      if(l2!=null){
        sumNode.val += l2.val;
        l2= l2.next;
      }
      //sumNode is never null cus it is initialized earlier    

      // if over 10
      if(sumNode.val >= 10){
        if(sumNode.next==null){
          sumNode.next = new ListNode(0);
        }
        sumNode.next.val +=sumNode.val/10;
        sumNode.val = sumNode.val%10;
      }

      if(sumNode.next==null && l2!=null){
        sumNode.next = new ListNode(0);
      }
      sumNode= sumNode.next;
    }
    return head;
  }


  public static void main(String[] args) {

    int[] arr1 = {2,4,3};//{9,9};//{2,4,3}; //{7};//
    int[] arr2 = {5,6,4}; //{9};//{5,6,4}; ///{7};//
    Solution sol = new Solution();

    ListNode node1 = sol.buildLinkedList(arr1);
    ListNode node2 = sol.buildLinkedList(arr2);
    sol.print(node1);
    sol.print(node2);

    ListNode answer = sol.addTwoNumbers_copyOneListAndAdd(node1, node2);
    sol.print(answer);
  }

  public ListNode buildLinkedList(int[] arr){

    ListNode node = new ListNode(arr[0]);
    ListNode head = node;

    for(int i=1; i<arr.length; i++){
      node.next = new ListNode(arr[i]);
      node = node.next;
    }

    return head;
  }

  public void print(ListNode node){

    ListNode curr = node;

    while(curr !=null){
      System.out.print(curr.toString()+"->");
      curr = curr.next;
    }

    System.out.println();    
  }
}

