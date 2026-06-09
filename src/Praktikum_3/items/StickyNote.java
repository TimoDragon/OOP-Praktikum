package Praktikum_3.items;

public class StickyNote extends Item {
    private final String description;

    public StickyNote(String description) {
        super("Sticky Note");
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
