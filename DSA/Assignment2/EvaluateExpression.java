import java.util.HashMap;

public class EvaluateExpression {
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public EvaluateExpression() {
		map.put("(", -1);
		map.put("!", 7);
		map.put("*", 6);
		map.put("/", 6);
		map.put("+", 5);
		map.put("-", 5);
		map.put(">", 4);
		map.put(">=", 4);
		map.put("==", 4);
		map.put("<", 4);
		map.put("<=", 4);
		map.put("&&", 3);
		map.put("||", 2);
	}

	/**
	 * Evaluate the Expression Parameter expression is string type, the
	 * expression you want to evaluate. Returns string type, the evaluated value
	 * of expression.
	 */
	public String evaluateExpression(String expression) {
		String postfix = infixToPostfix(expression); // converts to postfix
														// expression
		UseStack operands = new UseStack();
		int operand1, operand2;
		String[] splittedString = postfix.split(" ");
		int sizeOfPostfixSplit = splittedString.length;
		for (int i = 0; i < sizeOfPostfixSplit; i++) {
			if (map.containsKey(splittedString[i])) {
				operand1 = Integer.parseInt((String) (operands.top()));
				operands.pop();
				operand2 = Integer.parseInt((String) (operands.top()));
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,
						splittedString[i]))));
			} else {
				operands.push(splittedString[i]);
			}
		}
		return ((String) operands.top());
	}

	/**
	 * Convert Infix Expression into Postfix Expression. Parameter expression a
	 * String variable, The Infix expression in a form of string. Returns the
	 * Postfix expression in a form of string.
	 */
	public String infixToPostfix(String expression) {

		String[] infixExpresionSplit = expression.split(" ");   
		String postfix = "";
		boolean flgEmpty = false;
		UseStack stackForPostfix = new UseStack();
		int sizeOfInfixSplit = infixExpresionSplit.length;
		for (int index = 0; index < sizeOfInfixSplit; index++) {
			if ("(".equals(infixExpresionSplit[index])) {
				stackForPostfix.push(infixExpresionSplit[index]);
			} else if (map.containsKey(infixExpresionSplit[index])) {

				while (flgEmpty
						&& map.get((String) stackForPostfix.top()) > map
								.get(infixExpresionSplit[index])) {
					postfix += stackForPostfix.top() + " ";
					stackForPostfix.pop();
				}
				stackForPostfix.push(infixExpresionSplit[index]);
				flgEmpty = true;
			} else if (")".equals(infixExpresionSplit[index])) {
				while (!"(".equals(stackForPostfix.top())) {
					postfix += stackForPostfix.top() + " ";
					stackForPostfix.pop();
				}
				stackForPostfix.pop();
			} else
				postfix += infixExpresionSplit[index] + " ";
		}
		while (!stackForPostfix.isEmpty()) {
			postfix += stackForPostfix.top() + " ";
			stackForPostfix.pop();
		}
		return postfix;
	}

	/**
	 * Evaluate the Data passed in the method Parameter operand1 An integer
	 * variable, the first number which we have to evaluate. Parameter operand2
	 * An integer variable, the second number which we have to evaluate.
	 * Parameter operator A String variable, tell us the operation we have to
	 * perform on the two numbers. Returns returns integer variable, The Answer
	 * after the evaluation of two number.
	 */
	public int evaluate(int operand1, int operand2, String operator) {
		switch (operator) {
		case "+":
			return operand1 + operand2;

		case "-":
			return operand1 - operand2;

		case "*":
			return operand1 * operand2;

		case "/":
			return operand1 / operand2;

		case ">":
			return (operand1 > operand2) ? 1 : 0;

		case "<":
			return (operand1 < operand2) ? 1 : 0;

		case ">=":
			return (operand1 >= operand2) ? 1 : 0;

		case "<=":
			return (operand1 <= operand2) ? 1 : 0;
		case "==":
			return (operand1 == operand2) ? 1 : 0;
		}
		return 0;
	}

	/**
	 * Evaluate the Expression Parameter expression An string variable, The
	 * Expression you want to Evaluate. Returns An Boolean Variable, The
	 * Evaluate Value of Expression.
	 */
	public boolean evaluateForLogical(String expression) {
		String postfix = infixToPostfix(expression);
		UseStack operands = new UseStack();
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int i = 0; i < splittedString.length; i++) {
			if (map.containsKey(splittedString[i])) {
				operand1 = Integer.parseInt((String) operands.top());
				operands.pop();
				operand2 = Integer.parseInt((String) operands.top());
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,
						splittedString[i]))));
			} else {
				operands.push(splittedString[i]);
			}
		}
		return ("1".equals(operands.top())) ? true : false;
	}
}