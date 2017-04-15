public class ReverseCycle{


	public static void reverseCycle(Node<Integer> head, int s, int e){

		Node<Integer> curr=head;
		Node<Integer> next=null;
		Node<Integer> before=null;
		Node<Integer> tmp=null;
			
		if(head!=null){
			next= head.next;
		}

		while(next!=null && curr.value!=e){
			
			tmp = next.next;

			if(before ==null && next.value==s){
				before = curr;
			}
			else if (before !=null){
				next.next=curr; //reverse arrow
			}
			curr = next;
			next = tmp;
		}

		if(curr!=null && curr.value==e){
			Node<Integer> ttmp = before.next;
			ttmp.next = next;
			before.next = curr;
		}
	}

	public static void main(String[] args){
		Node<Integer> ori = new Node<Integer>(1);
		Node<Integer> head = ori;
		head.next=(new Node<Integer>(2));
		head = head.next;
		head.next=(new Node<Integer>(3));
		head = head.next;
		head.next=(new Node<Integer>(4));
		head = head.next;
		head.next=(new Node<Integer>(5));
		head = head.next;
		head.next=(new Node<Integer>(6));

		print(ori);

		reverseCycle(ori, 2, 4);
		print(ori);
	}

	public static void print(Node<Integer> ori){
		Node<Integer> head= ori;
		while(head!=null){
			System.out.print(head.value+", ");
			head = head.next;
		}
		System.out.println();
	}
}