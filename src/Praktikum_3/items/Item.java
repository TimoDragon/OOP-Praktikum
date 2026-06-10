package Praktikum_3.items;

public abstract class Item {

    private final String name;

    /**
     * Konstruktor der Klasse Items
     * @param name Name des Items
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Gibt den Namen des Items zurück
     * @return name
     */
    public String getName() {
        return this.name;
    }
}
