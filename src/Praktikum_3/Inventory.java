package Praktikum_3;

import Praktikum_3.items.Item;
import Praktikum_3.items.StickyNote;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }

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
