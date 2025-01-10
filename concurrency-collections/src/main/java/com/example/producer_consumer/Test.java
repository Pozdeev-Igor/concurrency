package com.example.producer_consumer;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        ProducerConsumer.startIndexing(new File[]{new File("C:\\Users\\igorp\\Desktop")});
    }
}
