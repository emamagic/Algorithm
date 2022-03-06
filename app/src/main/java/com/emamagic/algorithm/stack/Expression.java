package com.emamagic.algorithm.stack;

import java.util.Stack;

public class Expression {

    private final Stack<Character> stack = new Stack<>();

    public boolean isBalance(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isLeftBracket(input.charAt(i)))
                stack.push(input.charAt(i));

            if (isRightBracket(input.charAt(i))) {
                if (stack.empty()) return false;

                char top = stack.pop();
                if (bracketsMatch(top, input.charAt(i))) return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '<' || ch == '[' || ch == '{';
    }

    private boolean isRightBracket(char ch) {
        return ch == ')' || ch == '>' || ch == ']' || ch == '}';
    }

    private boolean bracketsMatch(char left, char right) {
        return  right == ')' && left != '(' ||
                right == ']' && left != '[' ||
                right == '>' && left != '<' ||
                right == '}' && left != '{';
    }
}
