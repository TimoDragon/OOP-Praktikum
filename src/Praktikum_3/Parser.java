package Praktikum_3;

import Praktikum_3.commands.Command;
import Praktikum_3.commands.Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parser {
    private Commands commands = new Commands();

    /**
     * Default Konstuktor
     */
    public Parser() {
    }

    /**
     * Gibt den Command zurpck
     * @return
     */
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

        return this.commands.istBefehl(wort1) ? new Command(wort1, wort2) : new Command((String)null, wort2);
    }

    /**
     * Gibt alle Befehle aus
     */
    public void zeigeBefehle() {
        this.commands.alleAusgeben();
    }

    /**
     * Gibt den Command zurück
     * @return
     */
    public Commands getCommand() {
        return commands;
    }

}