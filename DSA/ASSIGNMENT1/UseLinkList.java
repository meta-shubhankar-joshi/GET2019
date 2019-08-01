package dataStructure1;
public class UseLinkList{
    public static void main(String args[])
	{
	    LinkList list=new LinkList();
		System.out.println(list.insertNode(2));
		System.out.println(list.insertNode(3));
		System.out.println(list.insertNode(4));
		System.out.println(list.insertNode(5));
		System.out.println(list.insertNode(6));
		System.out.println(list.insertNode(7));
		System.out.println(list.head);
		
		Node first=list.head;
		// main List
		System.out.println("Main List");
		while(first.next!=null)
		{	
		    System.out.print(first.data+"	");
			first=first.next;
		}
        System.out.println(first.data);		
		//sublist
		System.out.println("\n\nSub List");
		LinkListOperation obj=new LinkListOperation();
		Node subList=obj.rotateSubList(list.head,2,5,2);
		while(subList.next!=null)
		{	
		    System.out.print(subList.data+"	");
			subList=subList.next;
		}
		System.out.println(subList.data);
		
        // detect loop
        System.out.println(obj.checkLoop(list.head));    //false
        LinkList list2=new LinkList();	
        list2.insertNode(2);
       	list2.insertNode(3);
        list2.insertNode(4);
        list2.insertNode(5);
		Node tempToLoop=list2.head;
		Node toEnd=tempToLoop;
		for(int i=1;i<=2;i++)
			tempToLoop=tempToLoop.next;
		while(toEnd.next!=null)
			toEnd=toEnd.next;
		toEnd.next=tempToLoop;
		System.out.println(obj.checkLoop(list2.head)+"\n"); 

        // degreeOfPolynomial
        System.out.println(obj.degreeOfPolynomial("xy+x4z8+w3y7=0")); 		
	}
}