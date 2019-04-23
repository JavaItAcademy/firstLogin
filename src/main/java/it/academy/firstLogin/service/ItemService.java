package it.academy.firstLogin.service;

import it.academy.firstLogin.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ItemService {
    private static List<Item> items;

    static {
        items = new ArrayList<>(
                Arrays.asList(
                   new Item(1, "item1", "Dress"),
                   new Item(2, "item2", "T-shirt"),
                   new Item(3, "item3", "Boots")
                ));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(int id) {
        items.removeIf(i -> i.getId().equals(id));
    }


}
