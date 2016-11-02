package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import shopingList.exceptions.InvalidProductParametersException;

public class AddItem implements Command {

    @Override
    public Object execute(Object... args) {
        Cart cart = (Cart) args[0];

        String productName = (String) args[1];
        Double productPrice = (Double) args[2];
        Double productQuantity = (Double) args[3];
        String productGroup = (String) args[4];

        Product product = createProduct(productName, productPrice, productQuantity, productGroup);
        cart.addItemToDataBase(product);
        return null;
    }

    private Product createProduct (String name, Double price, Double quantity, String group) {
        if (name == null || price == null || quantity == null || group == null) {
            throw new InvalidProductParametersException();
        } else {
            Product pr = new Product(name, price, quantity, group);
            return pr;
        }
    }
}
