package test.commands;

import org.junit.Before;
import org.junit.Test;
import shopingList.Cart;
import shopingList.Product;
import shopingList.commands.ListItems;
import shopingList.commands.SearchForItemByName;
import shopingList.exceptions.NoSuchItemException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Item is present
 No item
 */
public class SearchForItemByNameTest {

    private Cart cart;
    private SearchForItemByName command;
    private Object[] arguments;
    private Product pr;
    private String productNameToSearch;

    @Before
    public void setUp() throws Exception {
        pr = new Product("Name", 2.5, 1.0, "G");
        cart = new Cart();
        cart.addItemToDataBase(pr);
        arguments = new Object[2];
        arguments[0] = cart;
        command = new SearchForItemByName();

    }

    @Test
    public void itemIsPresentInDB () {
        productNameToSearch = "Name";
        arguments[1] = productNameToSearch;

        List<Product> resultList = (List) command.execute(arguments);

        assertThat(resultList.get(0).getName(), is("Name"));

    }

    @Test (expected = NoSuchItemException.class)
    public void noSuchItem () {
        productNameToSearch = "AnotherName";
        arguments[1] = productNameToSearch;

        List<Product> resultList = (List) command.execute(arguments);

    }





}