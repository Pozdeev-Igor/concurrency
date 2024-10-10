package org.example.a9_publishing_escape;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        var states = new UnsafeStates().getStates();
        System.out.println("states = " + Arrays.toString(states));
        var string = states[0].toLowerCase();
        states[0] = string;
        System.out.println("states = " + Arrays.toString(states));
    }
}
