import java.util.Calendar;

public class Transaktion {
    private final Calendar cal;
    private final float amount;

    /**
     * @param pDate     Datum der Transaktion
     * @param pAmount   Betrag der Transaktion
     */
    public Transaktion(Calendar pDate, float pAmount) {
        this.cal = pDate;
        this.amount = pAmount;
    }

    /**
     * @return Datum der Transaktion
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     *
     * @return Betrag der Transaktion
     */
    public float getAmount() {
        return amount;
    }
}