package Praktikum_3.commands;

public class Commands {
    private static final String[] gueltigeBefehle = new String[]{"go", "quit", "help", "map", "attack"};

    public boolean istBefehl(String eingabe) {
        for (String s : gueltigeBefehle) {
            if (s.equalsIgnoreCase(eingabe)) {
                return true;
            }
        }

        return false;
    }

    public void alleAusgeben() {
        for (String s : gueltigeBefehle) {
            System.out.print(s + "  ");
        }

        System.out.println();
    }
}

