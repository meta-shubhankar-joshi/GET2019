package dataStructure1;
import java.util.*;
public class LinkListOperation{
    
	/**
	 * Method rotate a sublist 
	 * Parameter list is reference of linked list 
	 * Parameter leftPosition is starting point of sublist
	 * Parameter rightPosition is end point of sublist
	 * Parameter rotateStep is number of time to rotate the sublist
	 * Returns rotated list
	 */
	public Node rotateSubList(Node list,int leftPosition,int rightPosition,int rotateStep)
	{
		LinkList sublist=new LinkList();
		Node tempSublistHead=list;
		Node subListHead;
		Node listLeftPart=null;
		Node listRightPart=null;
		for(int i=1;i<leftPosition;i++)
		{   
            listLeftPart=tempSublistHead;	
			tempSublistHead=tempSublistHead.next;
		}
        for(int i=0;i<=rightPosition-leftPosition;i++)
        {
			subListHead=sublist.insertNode(tempSublistHead.data);
			tempSublistHead=tempSublistHead.next;
			subListHead=subListHead.next;
			listRightPart=tempSublistHead;
		}
        subListHead=sublist.head;     //getting sublist head
		Node tempNode=null;
		for(int i=0;i<rotateStep;i++)
		{   
	        tempNode=subListHead; 
	        subListHead=subListHead.next;
	        Node lastNode=sublist.head;
			while(lastNode.next!=null)
			{
				lastNode=lastNode.next;
			}
			lastNode.next=tempNode;
			tempNode.next=null;
		}
        Node finalSubList=subListHead;
        listLeftPart.next=finalSubList;
        tempNode.next=listRightPart;    		
        return list; 		
	}
	/** 
	 * Method detects loop in Linked List
	 * Takes linked list as argument
     * Returns true if linked list contains loop otherwise false
     */ 	 
	public boolean checkLoop(Node list)
	{   
	    Set<Node> alladdress=new HashSet<Node>(); 
	    while(list.next!=null)
		{
			if(!(alladdress.add(list)))
			{
				return true;
			}
            list=list.next;			
		}	
		return false;
	}
	/**
	 * Method takes multivariate polynomial equation as argument
     * Calculate degree	of polynomial equation and returns it
	 */
	 public int degreeOfPolynomial(String equation)
	 {  LinkList mainList=new LinkList();
        LinkList subList=new LinkList();  		
		for(int i=0;i<equation.length();i++)
        {
			if(Character.isLetter(equation.charAt(i)))
			{
				subList.insertNode(1);
			}
            else
                if(Character.isDigit(equation.charAt(i)))
                {
					subList.insertNode(Character.digit(equation.charAt(i),15)-1);
				}
                else
                {   
			        mainList.insertNode(subList.head);
					if(equation.charAt(i)!='=')
						subList=new LinkList();
					else
						break;
				}					
				
		}
		Node mainListHead=mainList.head;
		Node subListHead=null;
		int degree=0;
		int count=0;
		while(mainListHead.next!=null)
		{
			count=0;
			subListHead=(Node)mainListHead.data;
			while(subListHead.next!=null)
			{
				count=count+(int)subListHead.data;
				subListHead=subListHead.next;
			}
			count=count+(int)subListHead.data;
			if(count>degree)
				degree=count;
			mainListHead=mainListHead.next;
		}	
		count=0;
			subListHead=(Node)mainListHead.data;
			while(subListHead.next!=null)
			{
				count=count+(int)subListHead.data;
				subListHead=subListHead.next;
			}
			count=count+(int)subListHead.data;
			if(count>degree)
				degree=count;		
		
        return degree;		
	 }
}
