package shopingList.commands;

import shopingList.Cart;
import shopingList.exceptions.NoSuchItemException;

public class DeleteItem implements Command {

    @Override
    public Object execute(Object... args) {
        Cart cart = (Cart) args[0];
        String productName = (String) args[1];
        boolean result = cart.removeItemFromDataBaseByName(productName);
        if (!result) {
            throw new NoSuchItemException();
        }
        return null;
    }
}
