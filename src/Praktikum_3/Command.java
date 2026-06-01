package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Command {
    private String befehlswort;
    private String zweitesWort;

    public Command(String erstesWort, String zweitesWort) {
        this.befehlswort = erstesWort;
        this.zweitesWort = zweitesWort;
    }

    public String gibBefehlswort() {
        return this.befehlswort;
    }

    public String gibZweitesWort() {
        return this.zweitesWort;
    }

    public boolean istUnbekannt() {
        return this.befehlswort == null;
    }

    public boolean hatZweitesWort() {
        return this.zweitesWort != null;
    }
}