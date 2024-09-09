package org.example.threadlocal;

public class Example {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        createLocal(threadLocal);
        removeLocal(threadLocal);

        var withInitialValue = createWithInitialValue();
        createLocal(withInitialValue);

    }

    /**
     * Пример создания threadLocal
     */
    private static void createLocal(ThreadLocal<String> threadLocal) {
        System.out.println("Before method 'set()': " + threadLocal.get());
        threadLocal.set("Hello");
        System.out.println("After method 'set()': " + threadLocal.get());
    }

    /**
     * Пример создания threadLocal с инициализацией
     * @return threadLocal
     */
    private static ThreadLocal<String> createWithInitialValue() {
        return ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));
    }

    /**
     * Пример удаления threadLocal
     */
    private static void removeLocal(ThreadLocal<String> threadLocal) {
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
