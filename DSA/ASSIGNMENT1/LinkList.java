package dataStructure1;
public class LinkList{
	Node head=null;
	/**
	 * Method will create new Node 
	 * takes Parameter as data of ineger type
	 * Returns the head of LinkList
	 */
	public Node insertNode(Object data)
	{
		if(head==null)
		{
			head=new Node(data);
		}
        else
        {
			Node nextNode=head;
 			while(nextNode.next!=null)
			{
				nextNode=nextNode.next;
			}
			nextNode.next=new Node(data);
		}
        return head;		
	}	
}