import java.util.Stack;

public class InfixToPostfix {

    public static String convert(String infixExpression) 
    {

        // create a new stack of characters 
        Stack<Character> stack = new Stack<>();

        // create a new stringBuilder to hold the conversion
        StringBuilder postfixExpression = new StringBuilder();

        // scan the expression left to right
        for(int i = 0; i < infixExpression.length(); i++)
        {
            
            // container for counter/ current string index 
            char c = infixExpression.charAt(i);

            // if its a number or variable:
            if(Character.isDigit(c))
            {
                postfixExpression.append(c);  // add directly to output:
            }
            // else if its an operator or parentheses:
            else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')')
            {

                // if ( 
                if(c == '('){
                    stack.push(c); // then push onto stack
                }
                // else if ) 
                else if(c == ')'){

                    while(!stack.isEmpty() && stack.peek() != '('){
                        postfixExpression.append(stack.pop());
                    }
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop(); // Remove the opening parenthesis '(' from the stack
                    }
                    else{
                        return "Invalid Expression"; // Handling the case of unbalanced parentheses
                    }
                }

                else {
                    // pop from stack, add to otuput. until i find an operator 
                    // thats not pareenthesis. 
                    while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                        if(stack.peek() == '('){ // if top of stack is '('
                            break;
                        }
                        postfixExpression.append(stack.pop());
                    }
                    stack.push(c); // push current operator onto stack
                }
            }
        }

        while(!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }
        
        return postfixExpression.toString();
    }

    // method to determine precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }



    public static void main(String[] args){
        // logic here for testing
    }
}