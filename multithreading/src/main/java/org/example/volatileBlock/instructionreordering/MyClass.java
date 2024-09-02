package org.example.volatileBlock.instructionreordering;

/**
 * The Java VM and the CPU are allowed to reorder instructions in the program for performance reasons,
 * as long as the semantic meaning of the instructions remain the same.
 * For instance, look at the following instructions:
 * <p>
 * {@code int a = 1;}<br>
 * {@code int b = 2;}<br><br>
 * <p>
 * {@code a++;}<br>
 * {@code b++;}
 * </p>
 * <p>
 * These instructions could be reordered to the following sequence without losing
 * the semantic meaning of the program:
 * <p>
 * {@code int a = 1;}<br>
 * {@code a++;}<br><br>
 * <p>
 * {@code int b = 2;}<br>
 * {@code b++;}
 * </p>
 * However, instruction reordering presents a challenge when
 * one of the variables is a volatile variable.
 */
public class MyClass {
    private int years;
    private int months;
    private volatile int days;

    /**
     * как только будет записано значение days,
     * остальные значения вместе с days будут перезаписаны в основную память
     *
     * @param years  годы
     * @param months месяцы
     * @param days   дни
     */
    public void correctUpdate(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    /**
     * Значения months и years по-прежнему записываются в основную память при изменении переменной
     * days, но на этот раз это происходит до того, как новые значения были записаны в months и years.
     * Таким образом, новые значения не становятся видимыми для других потоков.
     * Семантическое значение переупорядоченных инструкций изменилось.
     *
     * @param years  годы
     * @param months месяцы
     * @param days   дни
     */
    public void uncorrectUpdate(int years, int months, int days) {
        this.days = days;
        this.years = years;
        this.months = months;
    }
}
