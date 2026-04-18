import java.util.*;

class ExpressionTree {

    static int evaluatePostfix(String[] exp) {
        Stack<Integer> st = new Stack<>();

        for (String s : exp) {
            if (Character.isDigit(s.charAt(0))) {
                st.push(Integer.parseInt(s));
            } else {
                int b = st.pop();
                int a = st.pop();

                if (s.equals("+")) st.push(a + b);
                else if (s.equals("-")) st.push(a - b);
                else if (s.equals("*")) st.push(a * b);
                else if (s.equals("/")) st.push(a / b);
            }
        }
        return st.pop();
    }
}
