import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void add_item(String item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
        System.out.println("You collected: " + item);
    }

    public int item_counter(String item) {
        return items.getOrDefault(item, 0);
    }

    public void display_inventory() {
        System.out.println("\n=== Inventory ===");
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (String item : items.keySet()) {
            System.out.println(item + ": " + items.get(item));
        }
    }

    public boolean canCraftBoat() {
        return item_counter("Wood") >= 3 &&
                item_counter("Rope") >= 2 &&
                item_counter("Metal") >= 2;
    }

    public void craftBoat() {
        if (!canCraftBoat()) {
            System.out.println("Not enough materials to craft the boat!");
            return;
        }

        items.put("Wood", item_counter("Wood") - 3);
        items.put("Rope", item_counter("Rope") - 2);
        items.put("Metal", item_counter("Metal") - 2);

        System.out.println("You crafted the boat!");
    }

    // Check if item exists= Check if player has at least 1 of the item
    public boolean hasItem(String item) {
        return items.getOrDefault(item, 0) > 0;
    }
    //get items added to be used in saveManger class
    public Map<String, Integer> getItems() { return items; }
}
