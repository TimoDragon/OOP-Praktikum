package Praktikum_3.commands;

public class Command {
    private final String command;
    private final String argument;

    /**
     * Konstruktor der Klasse Command
     * @param command der übergebene Command
     * @param argument das übergebene Argument
     */
    public Command(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    /**
     * Getter
     * @return command als String
     */
    public String getCommand() {
        return this.command;
    }

    /**
     * Getter
     * @return argument
     */
    public String getArgument() {
        return this.argument;
    }

    /**
     * Übprüft, ob der Command ein argument hat
     * @return boolean
     */
    public boolean hasArgument() {
        return this.argument != null;
    }
}