package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import shopingList.exceptions.NoSuchItemException;

import java.util.ArrayList;
import java.util.List;

public class SearchItemByPriceRange implements Command {

    @Override
    public Object execute(Object... args) {
        Cart cart = (Cart) args[0];
        double from = (Double) args[1];
        double to = (Double) args[2];

        List<Product> listContainsFoundProducts = new ArrayList();
        List<Product> listToSearchIn = cart.listItems();

        for (Product pr : listToSearchIn) {
            double currentProductPrice = pr.getPrice();
            if (currentProductPrice >= from && currentProductPrice <= to) {
                listContainsFoundProducts.add(pr);
            }
        }

        if (listContainsFoundProducts.size() == 0) {
            throw new NoSuchItemException();
        }

        return listContainsFoundProducts;
    }
}
