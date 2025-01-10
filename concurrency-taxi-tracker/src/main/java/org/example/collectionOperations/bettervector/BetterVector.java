package org.example.collectionOperations.bettervector;

import java.util.Vector;

/**
 * Не имея доступа к исходному коду, можно добавить атомарность путем расширения класса,
 * предназначенного для расширения.
 * Но после расширения реализация политики синхронизации распределится по нескольким отдельно
 * сопровождаемым исходным файлам. Т.е., если базовый класс изменит замок для защиты своих
 * переменных состояния, то подкласс станет использовать неправильный замок
 */
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x) {
        var absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
