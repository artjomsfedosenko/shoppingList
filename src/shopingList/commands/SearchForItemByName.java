package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import shopingList.exceptions.NoSuchItemException;

import java.util.ArrayList;
import java.util.List;

public class SearchForItemByName implements Command {

    @Override
    public Object execute(Object... args) {
        Cart cart = (Cart) args[0];
        String nameToSearchBy = (String) args[1];
        List<Product> listContainsFoundProducts = new ArrayList();
        List<Product> listToSearchIn = cart.listItems();

        for (Product pr : listToSearchIn) {
            if (pr.getName().equals(nameToSearchBy)) {
                listContainsFoundProducts.add(pr);
            }
        }

        if (listContainsFoundProducts.size() == 0) {
            throw new NoSuchItemException();
        }

        return listContainsFoundProducts;
    }
}
