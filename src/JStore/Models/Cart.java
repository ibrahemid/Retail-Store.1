package JStore.Models;

import java.util.ArrayList;

public class Cart {


    public ArrayList<OrderProduct> cart;

    private static Cart CurrentInstance = new Cart();

    public static Cart getInstance() {
        return CurrentInstance;
    }

    private Cart() {
        cart = new ArrayList<>();

    }

}
