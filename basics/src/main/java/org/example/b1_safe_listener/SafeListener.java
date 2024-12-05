package org.example.b1_safe_listener;

/**
 * Чтобы зарегистрировать слушателя событий или запустить поток из конструктора,
 * воспользуйтесь приватным конструктором и публичным фабричным методом
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = this::doSomething;
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }
}
