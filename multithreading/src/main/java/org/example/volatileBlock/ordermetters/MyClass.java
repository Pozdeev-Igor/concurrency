package org.example.volatileBlock.ordermetters;

public class MyClass {
    private int years;
    private int months;
    private volatile int days;

    /**
     * Метод начинается с того, что записывает в total сперва волатильную переменную days. Это гарантирует что остальные
     * переменные будут так же возвращены в основную память и их актуальные значения будут доступны другим потокам из
     * основной памяти.
     */
    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days){
        this.years  = years;
        this.months = months;
        this.days   = days;
    }
}
