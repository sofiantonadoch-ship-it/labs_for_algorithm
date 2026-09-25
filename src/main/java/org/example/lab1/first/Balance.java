package org.example.lab1.first;
import java.util.ArrayDeque;
import java.util.Deque;
public class Balance
{
    private static final int LENGTH = 10000;
    public static boolean balanced(String str)
    {
        if (str == null || str.isEmpty() || str.length() > LENGTH)
        {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray())
        {
            if (!bracket(c))
            {
                return false;
            }
            if (c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{'))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean bracket(char c)
    {
        return c == '(' || c == ')' ||
                c == '[' || c == ']' ||
                c == '{' || c == '}';
    }
}