package com.emamagic.algorithm.stack;

import androidx.annotation.NonNull;
import java.util.Stack;

public class StringReverser {

    private static final String TAG = "StringReverser";
    private final StringBuilder builder = new StringBuilder();
    private final Stack<Character> stack = new Stack<>();

    public String revers(@NonNull String input) {
        for (char ch : input.toCharArray())
            stack.push(ch);

        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        String result = builder.toString();
        clean();
        return result;
    }

    private void clean() {
        builder.setLength(0);
        stack.clear();
    }


}
