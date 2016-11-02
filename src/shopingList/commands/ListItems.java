package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import java.util.List;

public class ListItems implements Command{

    @Override
    public Object execute(Object... args) {
        Cart cart = (Cart) args[0];
        List<Product> listToReturn = cart.listItems();
        return listToReturn;
    }
}
