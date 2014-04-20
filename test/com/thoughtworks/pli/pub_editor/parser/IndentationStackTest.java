package com.thoughtworks.pli.pub_editor.parser;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IndentationStackTest {

    private IndentationStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new IndentationStack();
    }

    @Test
    public void should_append_new_deeper_indentation() {
        stack.push(5);
        stack.push(10);
        assertThat(stack.all()).isEqualTo(Lists.newArrayList(10, 5, 0));
    }

    @Test
    public void should_remove_deeper_indentation_from_stack_when_pushing_a_shorter_indentation() {
        stack.push(3);
        stack.push(10);
        stack.push(5);
        assertThat(stack.all()).isEqualTo(Lists.newArrayList(5, 3, 0));
    }

}
