import model.Category;
import model.Item;
import model.ItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alagapm on 12/16/15.
 */
public class SalesTaxCalculator {

    private double basicSalesTaxRate;
    private double importedGoodsRate;

    public SalesTaxCalculator(){

        //Set Tax Rates
        this.setBasicSalesTaxRate(10d);
        this.setImportedGoodsRate(5d);

        //To set default Values
        mockInitializeSystem();
    }

    public double getBasicSalesTaxRate() {
        return basicSalesTaxRate;
    }

    public void setBasicSalesTaxRate(double basicSalesTaxRate) {
        this.basicSalesTaxRate = basicSalesTaxRate;
    }

    public double getImportedGoodsRate() {
        return importedGoodsRate;
    }

    public void setImportedGoodsRate(double importedGoodsRate) {
        this.importedGoodsRate = importedGoodsRate;
    }

    private double calculateSalesTax(ItemData itemData){

        if(!ItemManager.isSalesTaxExempted(itemData.getItem())){
            return (itemData.getItem().getRate()*this.getBasicSalesTaxRate()/100d);
        }
        return 0d;
    }

    private double calculateImprtDuty(ItemData itemData){

        if(itemData.isImported()){
            return (itemData.getItem().getRate()*this.getImportedGoodsRate()/100d);
        }
        return 0d;
    }

    private double calculateTotalTax(ItemData itemData){

        return this.calculateSalesTax(itemData)+this.calculateImprtDuty(itemData);
    }

    public void generateReceipt(List<ItemData> allItems) {

        double totalAmount = 0d;
        double totalTax = 0d;

        for(ItemData itemData : allItems) {

            Item item = itemData.getItem();
            int quantity = itemData.getQuantity();

            //Calculate Tax
            double tax = this.calculateTotalTax(itemData) * quantity;
            tax = util.Math.roundTo0_05(tax);
            totalTax += tax;

            //Calculate Amount
            double amount = (item.getRate() * quantity) + tax;
            totalAmount += amount;

            String isImported = " ";
            if(itemData.isImported()){
                isImported = " imported ";
            }
            System.out.printf("%d%s%s - %.2f \n",quantity,isImported,item.getItemName(),amount);

        }

        System.out.printf("Sales Taxes - %.2f \n", totalTax);
        System.out.printf("Total - %.2f \n", totalAmount);
    }

    public static void main(String[] args) {

        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator();

        //Get sample Items
        List<ItemData> allItems = getSampleItems();

        //Generate Receipt
        salesTaxCalculator.generateReceipt(allItems);

    }


    private void mockInitializeSystem(){

        //All categories
        Category bookCategory = new Category(true);
        ItemManager.addCategory("book", bookCategory);

        Category foodCategory = new Category(true);
        ItemManager.addCategory("food", foodCategory);

        Category medicalCategory = new Category(true);
        ItemManager.addCategory("medical", medicalCategory);

        Category otherCategory = new Category(false);
        ItemManager.addCategory("other", otherCategory);

    }

    //Hardcoded Item List
    private static List<ItemData> getSampleItems() {

        List<ItemData> allItems = new ArrayList<ItemData>();
        ItemData itemData;

        //Set 1
        /*itemData = ItemManager.createItemData("book", 12.49, false, "book", 1);
        allItems.add(itemData);

        itemData = ItemManager.createItemData("music CD", 14.99, false, "other", 1);
        allItems.add(itemData);

        itemData = ItemManager.createItemData("chocolate bar", 0.85, false, "food", 1);
        allItems.add(itemData);*/

        //Set 2
        /*itemData = ItemManager.createItemData("box of chocolates", 10.00, true, "food", 1);
        allItems.add(itemData);

        itemData = ItemManager.createItemData("bottle of perfume", 47.50, true, "other", 1);
        allItems.add(itemData);*/

        //Set 3
        itemData = ItemManager.createItemData("bottle of perfume", 27.99, true, "other", 1);
        allItems.add(itemData);

        itemData = ItemManager.createItemData("bottle of perfume", 18.99, false, "other", 1);
        allItems.add(itemData);

        itemData = ItemManager.createItemData("packet of head ache pills", 9.75, false, "medical", 1);
        allItems.add(itemData);

        itemData= ItemManager.createItemData("imported chocolates", 11.25, true, "food", 1);
        allItems.add(itemData);


        return allItems;
    }
}
