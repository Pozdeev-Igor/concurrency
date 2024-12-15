package org.example.a8_visibility;

import net.jcip.annotations.NotThreadSafe;

/**
 * MutableInteger не является thread-safe классом. Поскольку доступ к полю value
 * осуществляется как из метода get(), так и из метода set()
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
