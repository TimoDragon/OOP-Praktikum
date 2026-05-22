package Praktikum_1_2;

import java.util.Calendar;

public class Transaktion {
    private final Calendar cal;
    private final float amount;

    /**
     * @param pDate     Datum der Praktikum_1_2.Transaktion
     * @param pAmount   Betrag der Praktikum_1_2.Transaktion
     */
    public Transaktion(Calendar pDate, float pAmount) {
        this.cal = pDate;
        this.amount = pAmount;
    }

    /**
     * @return Datum der Praktikum_1_2.Transaktion
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     *
     * @return Betrag der Praktikum_1_2.Transaktion
     */
    public float getAmount() {
        return amount;
    }
}