import java.util.ArrayList;
class UseStack implements Stack{
    ArrayList stack=new ArrayList();
    private int peekIndex;
    /** 
     * Method to insert element into stack
     * Parameter itemToInsert is element of Object type
     * Returns true if item inserted otherwise false
     */
    public boolean push(Object itemToInsert)
    {
         if(stack.add(itemToInsert))
         {
              peekIndex++;
              return true;
         }
         else
          return false;
    }
    /** 
     * Method to remove element from stack
     * Returns element of Object type if there is exists otherwise null if stack empty
     */
    public Object pop()
    {   
         if(peekIndex>0)
         {  
             int tempPeek=peekIndex;        
             peekIndex--; 
             return stack.remove(tempPeek-1);
         }
         else
          return null;
    }
    /** 
     * Returns the value of top of stack 
     * Returns null if stack is empty
     */
    public Object top()
    {    
         if(stack.isEmpty())
              return null;
         else
              return stack.get(peekIndex-1);
    }
    /**  
     * Returns true if stack is empty otherwise false
     */
     public boolean isEmpty()
     {
         if(peekIndex==0)
              return true;
         else
              return false;
     }
}