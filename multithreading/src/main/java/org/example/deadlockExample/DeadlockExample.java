package org.example.deadlockExample;

/**
 * В данном коде нет явного dead lock. Dead lock возникает, когда два или более потока блокируются,
 * каждый ожидая действия другого потока, который в свою очередь ожидает действия первого потока.
 * В данном случае, оба потока блокируются, но они не ожидают действия друг друга.
 * <p>
 * Вместо этого, программа просто блокирует выполнение каждого потока до тех пор,
 * пока другой поток не вызовет метод callMe. После этого оба потока продолжают выполнение.
 * Таким образом, программа не попадает в dead lock, а просто блокирует выполнение каждого потока до тех пор,
 * пока другой поток не вызовет метод callMe.
 *
 * @param name
 */
public record DeadlockExample(String name) {

    public synchronized void callMe(DeadlockExample caller) {
        System.out.println(this.name() + " has called me " + caller.name());
    }

    public static void main(String[] args) {
        var caller1 = new DeadlockExample("caller-1");
        var caller2 = new DeadlockExample("caller-2");

        new Thread(() -> caller2.callMe(caller1)).start();
        new Thread(() -> caller1.callMe(caller2)).start();
    }
}
