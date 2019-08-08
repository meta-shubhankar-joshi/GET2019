public interface Stack{
    /** 
     * Method to insert element into stack
     * Parameter itemToInsert is element of Object type
     * Returns true if item inserted otherwise false
     */
    boolean push(Object itemToInsert);
    /** 
     * Method to remove element from stack
     * Returns element of Object type if there is exists otherwise null if stack empty
     */
    Object pop();
    /** 
     * Returns the value of top of stack 
     * Returns null if stack is empty
     */
    Object top();
    /**  
     * Returns true if stack is empty otherwise false
     */
     boolean isEmpty();
}