import model.Category;
import model.Item;
import model.ItemData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by alagapm on 12/16/15.
 */
public class ItemManager {

    private static Map<Item, Category> allItems = new HashMap<>();
    private static Map<String, Category> allCategories = new HashMap<>();

    public static boolean isSalesTaxExempted(Item item){
        return getCategory(item).isSalesTaxExempted();
    }

    private static Category getCategory(Item item){
        return allItems.get(item);
    }

    public static void addCategory(String categoryString, Category category){
        allCategories.put(categoryString, category);
    }

    public static Item createItem(String itemName, double price, String categoryString){
        Item item = null;
        if(allCategories.containsKey(categoryString)){
            Category category = allCategories.get(categoryString);
            item = new Item(itemName, price);
            allItems.put(item, category);
        } else {
            System.out.println("Category Not Available !!");
        }
        return item;

    }

    public static ItemData createItemData(String itemName, double price, boolean isImported, String categoryString,
                                          int quantity){
        ItemData itemData;
        Item item = createItem(itemName, price, categoryString);
        itemData = new ItemData(item, quantity, isImported);
        return itemData;
    }

}
