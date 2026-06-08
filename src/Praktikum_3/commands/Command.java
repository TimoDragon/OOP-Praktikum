package Praktikum_3.commands;

public class Command {
    private final String command;
    private final String argument;

    public Command(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    public String getCommand() {
        return this.command;
    }

    public String getArgument() {
        return this.argument;
    }

    public boolean hasArgument() {
        return this.argument != null;
    }
}