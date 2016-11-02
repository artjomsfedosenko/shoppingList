package test.commands;

import org.junit.Before;
import org.junit.Test;
import shopingList.Cart;
import shopingList.Product;
import shopingList.commands.DeleteItem;
import shopingList.exceptions.NoSuchItemException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Artjom on 23.09.2016..
 */
public class DeleteItemTest {

    private Cart cart;
    private List<Product> list;
    private Object[] arguments;
    private DeleteItem command;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        Product pr = new Product("Name", 2.5, 2.0, "R");
        cart.addItemToDataBase(pr);
        list = cart.listItems();
        arguments = new Object[2];
        arguments[0] = cart;
        command = new DeleteItem();
    }

    @Test
    public void removeProduct () {
        arguments[1] = "Name";
        command.execute(arguments);
        assertThat(list.size(), is(0));
    }

    @Test (expected = NoSuchItemException.class)
    public void noSuchProduct () {
        cart.removeItemFromDataBaseByName("Name");
        arguments[1] = "Name";
        command.execute(arguments);
    }
}