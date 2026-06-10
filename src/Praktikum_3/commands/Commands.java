package Praktikum_3.commands;

public class Commands {
    private static final String[] gueltigeBefehle = new String[]{"go", "quit", "help", "map", "attack", "use" , "inv" , "collect" , "look"};
    private int commandCount = 0;

    /**
     * Überprüft ob der übergebene command teil der gueltigenBefehle ist
     * @param eingabe der übergebene command als String
     * @return gültiger Befehl true/false
     */
    public boolean istBefehl(String eingabe) {
        for (String s : gueltigeBefehle) {
            if (s.equalsIgnoreCase(eingabe)) {
                commandCount++;
                return true;
            }
        }

        return false;
    }

    /**
     * Gibt alle gültigen Befehle aus
     */
    public void alleAusgeben() {
        for (String s : gueltigeBefehle) {
            System.out.print(s + "  ");
        }

        System.out.println();
    }

    /**
     * Gibt zurück, wie viele gültige Commands verarbeitet wurden
     * @return commandCount
     */
    public int getCommandCount() {
        return commandCount;
    }
}

