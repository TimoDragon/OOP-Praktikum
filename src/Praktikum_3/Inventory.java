package Praktikum_3;

import Praktikum_3.items.Item;
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
}
