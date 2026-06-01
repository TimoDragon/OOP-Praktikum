package Praktikum_3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Parser {
    private Commands befehle = new Commands();

    public Parser() {
    }

    public Command liefereBefehl() {
        String eingabezeile = "";
        System.out.print("> ");
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

        try {
            eingabezeile = eingabe.readLine();
        } catch (IOException exc) {
            System.out.println("There was an error during reading: " + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(eingabezeile);
        String wort1;
        if (tokenizer.hasMoreTokens()) {
            wort1 = tokenizer.nextToken();
        } else {
            wort1 = null;
        }

        String wort2;
        if (tokenizer.hasMoreTokens()) {
            wort2 = tokenizer.nextToken();
        } else {
            wort2 = null;
        }

        return this.befehle.istBefehl(wort1) ? new Command(wort1, wort2) : new Command((String)null, wort2);
    }

    public void zeigeBefehle() {
        this.befehle.alleAusgeben();
    }
}