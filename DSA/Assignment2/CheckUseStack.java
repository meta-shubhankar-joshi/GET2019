public class CheckUseStack{
    public static void main(String args[])
    {
        UseStack stack=new UseStack();
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push("Hello"));
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        
        
        // checking evaluate expression
        EvaluateExpression obj=new EvaluateExpression();
        System.out.println(obj.evaluateExpression("( ( 2 + 6 ) * 5 )"));
        System.out.println(obj.evaluateForLogical("2 == 2"));
        
    }
}