class Cart {
    private int[] prices;
    private int itemCount;
    private final String cartId;

    // Constructor
    Cart(String cartId, int maximumItems) {
        this.cartId = cartId;
        prices = new int[maximumItems];
        itemCount = 0;
    }

    // Add item
    void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    // Calculate total
    int getTotal() {
        int total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    // Return item count
    int getItemCount() {
        return itemCount;
    }
}

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total = " + cart.getTotal());
        System.out.println("Item Count = " + cart.getItemCount());
    }
}
