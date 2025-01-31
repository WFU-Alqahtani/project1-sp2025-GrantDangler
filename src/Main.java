import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Item[] completeStore = setupStore();

        ArrayList<Item> items = createCart(args, completeStore);

        printReceiptInOrder(items);

        emptyCartReverseOrder(items);
    }

    public static Item[] setupStore(){
        Item[] storeItem = new Item[8];
        storeItem[0] = new Item("Basketball" , 30.0);
        storeItem[1] = new Item("Football" , 25.0);
        storeItem[2] = new Item("Sneakers" , 60.0);
        storeItem[3] = new Item("Shorts" , 35.0);
        storeItem[4] = new Item("Short-sleeve shirt" , 40.0);
        storeItem[5] = new Item("Long-sleeve shirt" , 45.0);
        storeItem[6] = new Item("Baseball bucket" , 20.0);
        storeItem[7] = new Item("Baseball glove" , 40.0);
        return storeItem;
    }

    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        ArrayList<Item> shop = new ArrayList<Item>();
        int token = 0;
        try {
            try{
                token = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid token number");
            }

            for (int i = 1; i < args.length; i++) {
                try {
                    int items = Integer.parseInt(args[i]);
                    if (items < 0 || items >= store.length) {
                        System.out.println("Invalid item number: " + items);
                    } else {
                        shop.add(store[items]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid item number");
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
                System.out.println("No valid input to cart.");
            }

            if (token > (args.length - 1)) {
                System.out.println("Your entered token amount is greater than then amount of items you entered");
            }
            if (token < args.length) {
                System.out.println("You entered more items than your intended tokens");
            }
            return shop;
        }

    public static void printReceiptInOrder(ArrayList<Item> shop){
        System.out.println("Receipt");
        System.out.println("------------------------------------------");
        double subtotal = 0.0;

        for (Item items : shop) {
            System.out.println(items.getItemName() + "\t" + items.getItemPrice());
            subtotal += items.getItemPrice();
        }

        double tax = subtotal * 0.05;
        double total = subtotal + tax;
        System.out.println("------------------------------------------");
        System.out.print("Subtotal: $");
        System.out.printf("%.2f", subtotal);
        System.out.println();
        System.out.print("5% Tax: $");
        System.out.printf("%.2f", tax);
        System.out.println();
        System.out.print("Total: $");
        System.out.printf("%.2f", total);
        System.out.println();
    }

    public static void emptyCartReverseOrder(ArrayList<Item> shop){
        System.out.println("Removing all items from the cart in \"Last in First out\" order...");
        while (!shop.isEmpty()) {
            Item remove = shop.remove(shop.size() - 1);
            System.out.println("Removing: " + remove.getItemName());
        }
        System.out.println("Cart has been emptied.");
    }
}