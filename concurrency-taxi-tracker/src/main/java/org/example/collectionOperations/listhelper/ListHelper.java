package org.example.collectionOperations.listhelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    /**
     * Блокировка на стороне клиента.
     *
     * Влечет за собой внедрение замкового кода для класса С в классы, которые никак не связаны с С,
     * поэтому нужно проявлять осторожность при использовании такого вида блокировки
     */
    public boolean putIfAbsent(E x) {
        synchronized (list) {
            var absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
