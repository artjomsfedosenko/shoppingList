package test.commands;

import org.junit.Before;
import org.junit.Test;
import shopingList.Cart;
import shopingList.Product;
import shopingList.commands.Command;
import shopingList.commands.ListItems;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 no items
 1 item
 multiple items
 */
public class ListItemsTest {

    private Cart cart;
    private ListItems command;
    private Object[] arguments;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        arguments = new Object[1];
        arguments[0] = cart;
        command = new ListItems();
    }

    @Test
    public void getListOneItem () {
        Product pr1 = new Product("A", 1.5, 2.0, "G");
        cart.addItemToDataBase(pr1);

       List<Product> resultList = (List<Product>) command.execute(arguments);

        assertThat(resultList.size(), is(1));
    }

    @Test
    public void getListTwoItems () {
        Product pr1 = new Product("A", 1.5, 2.0, "G");
        Product pr2 = new Product("B", 2.5, 3.0, "X");
        cart.addItemToDataBase(pr1);
        cart.addItemToDataBase(pr2);

        List<Product> resultList = (List<Product>) command.execute(arguments);

        assertThat(resultList.size(), is(2));
    }

    @Test
    public void getListNoItems () {
        cart.removeItemFromDataBaseByName("A");
        cart.removeItemFromDataBaseByName("B");

        List<Product> resultList = (List<Product>) command.execute(arguments);

        assertThat(resultList.size(), is(0));
    }




}