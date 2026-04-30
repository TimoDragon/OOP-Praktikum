public class Main {
    static void main() {
        Inhaber i1 = new Inhaber("Timo","Kruse","Straße-1");
        Inhaber i2 = new Inhaber("Kevin","Kröger","Straße-2");

        Konto k1 = new Konto(1,i1);
        Konto k2 = new Konto(2,i1,50);

        Konto k3 = new Konto(3,i2,k2);

        System.out.println(k1.getKontoStand());
        System.out.println(k2.getKontoStand());
        System.out.println(k3.getKontoStand() + "\n");


        k3.einzahlen(0);
        k3.ueberweisen(k2,50);

        System.out.println(k1.getKontoStand());
        System.out.println(k2.getKontoStand());
        System.out.println(k3.getKontoStand());
    }
}
