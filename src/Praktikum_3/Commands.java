package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Commands {
    private static final String[] gueltigeBefehle = new String[]{"go", "quit", "help"};

    public Commands() {
    }

    public boolean istBefehl(String eingabe) {
        for(int i = 0; i < gueltigeBefehle.length; ++i) {
            if (gueltigeBefehle[i].equals(eingabe)) {
                return true;
            }
        }

        return false;
    }

    public void alleAusgeben() {
        for(int i = 0; i < gueltigeBefehle.length; ++i) {
            System.out.print(gueltigeBefehle[i] + "  ");
        }

        System.out.println();
    }
}

