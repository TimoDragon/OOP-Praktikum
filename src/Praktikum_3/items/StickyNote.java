package Praktikum_3.items;


public class StickyNote extends Item {
    private final String description;

    /**
     * Konstruktor der Klasse Stickynot
     * @param description Beschreibung
     */
    public StickyNote(String description) {
        super("Sticky Note");
        this.description = description;
    }

    /**
     * Gibt die Beschreibung zurück
     * @return description
     */
    public String getDescription() {
        return this.description;
    }
}
