package test.commands;

import org.junit.Before;
import org.junit.Test;
import shopingList.Cart;
import shopingList.Product;
import shopingList.commands.AddItem;
import shopingList.exceptions.InvalidProductParametersException;

import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Artjom on 21.09.2016..
 */
public class AddItemTest {

    Object[] arguments;
    private Cart testCart;
    private List<Product> list;
    private String productName;
    private Double productPrice;
    private Double productQuantity;
    private String productGroup;
    private AddItem command;

    @Before
    public void beforeAll() throws Exception {
        testCart = new Cart();
        list = testCart.listItems();
        arguments = new Object[5];
        arguments[0] = testCart;
        arguments[1] = productName;
        arguments[2] = productPrice;
        arguments[3] = productQuantity;
        arguments[4] = productGroup;
        command = new AddItem();
    }

    @Test
    public void addSimpleValidProduct () {
        productName = "Name";
        productPrice = 2.5;
        productQuantity = 2.0;
        productGroup = "R";

        arguments[0] = testCart;
        arguments[1] = productName;
        arguments[2] = productPrice;
        arguments[3] = productQuantity;
        arguments[4] = productGroup;

        command.execute(arguments);

        assertThat(list.get(0).getName(), is("Name"));
    }

    @Test(expected =  InvalidProductParametersException.class)
    public void addNullFieldProductThrowsInvalidProductParametersException () {
        productName = null;
        arguments[1] = productName;

        command.execute(arguments);



    }

}