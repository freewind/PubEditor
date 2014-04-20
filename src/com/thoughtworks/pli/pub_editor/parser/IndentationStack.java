package com.thoughtworks.pli.pub_editor.parser;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class IndentationStack {

    private Stack<Integer> stack;

    public IndentationStack() {
        this.stack = new Stack<Integer>();
        this.stack.add(0);
    }

    public void push(int newIndentation) {
        if (newIndentation > current()) {
            stack.push(newIndentation);
        } else {
            while (newIndentation <= current()) {
                stack.pop();
            }
            stack.push(newIndentation);
        }
    }

    public int current() {
        return stack.peek();
    }

    public List<Integer> all() {
        List<Integer> all = new ArrayList<Integer>();
        Enumeration<Integer> elements = stack.elements();
        while (elements.hasMoreElements()) {
            all.add(0, elements.nextElement());
        }
        return all;
    }

}
