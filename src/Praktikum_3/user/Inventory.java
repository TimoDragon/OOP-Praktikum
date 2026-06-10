package Praktikum_3.user;

import Praktikum_3.items.Item;
import Praktikum_3.items.StickyNote;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    /**
     * fügt ein Item zum Inventar hinzu
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Gib das Item an der Index Stelle zurück
     * @param index
     * @return
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * Gibt das ganze Inventar zurück
     * @return
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Ausgeben des Inventars auf der Kommandozeile
     */
    public void printInventory() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            System.out.print("(" + i + ") " + item.getName());

            if (item instanceof StickyNote stickyNote) {
                System.out.println(" | Inhalt: \"" + stickyNote.getDescription() + "\"");
            } else {
                System.out.println();
            }
        }
    }
}
