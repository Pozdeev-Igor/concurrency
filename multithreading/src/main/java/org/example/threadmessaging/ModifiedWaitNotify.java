package org.example.threadmessaging;

/**
 * Для защиты от ложных срабатываний переменная-член сигнала проверяется внутри цикла while,
 * а не внутри if-статьи. Такой цикл while также называется спин-блокировкой.
 * Пробудившийся поток вращается до тех пор, пока условие в блокировке (цикл while) не станет ложным.
 * <p>
 * Цикл while также является хорошим решением, если у вас есть несколько ожидающих потоков,
 * которые все пробуждаются с помощью notifyAll(),
 * но только одному из них должно быть разрешено продолжить выполнение.
 */
public class ModifiedWaitNotify {
    final MonitorObject monitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait() {
        synchronized (monitorObject) {
            while (!wasSignalled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            wasSignalled = true;
            monitorObject.notify();
        }
    }
}
