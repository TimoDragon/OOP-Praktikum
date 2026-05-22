import Praktikum_1_2.Inhaber;
import Praktikum_1_2.Konto;
import Praktikum_1_2.Sparkonto;

import java.util.Calendar;

public class Main {
    static void main() throws Exception {
        Inhaber i1 = new Inhaber("Timo","Kruse","Straße-1");
        Inhaber i2 = new Inhaber("Kevin","Kröger","Straße-2");

        Konto k1 = new Konto(i1,100);
        Sparkonto s1 = new Sparkonto(i2, 5);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();

        c2.set(Calendar.DATE, 22);
        c3.set(Calendar.DATE, 23);

        k1.abheben(5,c3);
        k1.abheben(10, c1);

        k1.einzahlen(10,c2);

        k1.printKontoauszuege(null);

        s1.einzahlen(20, c1);
        if(s1.zinszahlung(c1) == false) {
            System.out.println("Zinszahlung nicht möglich");
        }

        if(s1.zinszahlung(c1) == false) {
            System.out.println("Zinszahlung nicht möglich");
        }
        s1.printKontoauszuege(c1);

        c2.set(Calendar.MONTH, 7);
        c2.set(Calendar.DATE, 11);
        k1.ueberweisen(s1, 30, c2);
        s1.printKontoauszuege(c2);
        k1.printKontoauszuege(c2);


        c3.set(Calendar.YEAR, 2027);
        c3.set(Calendar.MONTH, 11);
        s1.zinszahlung(c3);
        k1.printKontoauszuege(null);
        s1.printKontoauszuege(null);
    }
}
