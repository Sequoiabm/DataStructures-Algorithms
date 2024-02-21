public class InfixToPostfixTester {
    public static void main(String[] args) {
        // Test cases
        String[] infixExpressions = {"2+3*4", "5*(6+7)", "(8-3)/2", "9*(4-2)/(1+1)"};
        
        for (String infixExpression : infixExpressions) {
            String postfixExpression = InfixToPostfix.convert(infixExpression);
            System.out.println("Infix Expression: " + infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);
            System.out.println();
        }
    }
}
