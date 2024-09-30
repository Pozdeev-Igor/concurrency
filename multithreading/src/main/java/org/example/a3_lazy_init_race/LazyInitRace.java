package org.example.a3_lazy_init_race;


/**
 * ТАК ДЕЛАТЬ НЕ СЛЕДУЕТ
 * <br>
 * <br>
 * метод getInstance() содержит в себе race condition
 */
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}
