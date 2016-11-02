package test.commands;

import org.junit.Before;
import org.junit.Test;
import shopingList.Cart;
import shopingList.Product;
import shopingList.commands.SearchForItemByName;
import shopingList.commands.SearchItemByPriceRange;
import shopingList.exceptions.NoSuchItemException;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SearchItemByPriceRangeTest {

    private Cart cart;
    private SearchItemByPriceRange command;
    private Object[] arguments;
    private Product pr1;
    private Product pr2;
    private Product pr3;
    private Double priceFrom;
    private Double priceTo;

    @Before
    public void beforeAll() {
        pr1 = new Product("A", 2.5, 1.0, "G");
        pr2 = new Product("B", 2.7, 2.0, "R");
        pr3 = new Product("C", 6.0, 4.0, "R");
        cart = new Cart();
        cart.addItemToDataBase(pr1);
        cart.addItemToDataBase(pr2);
        cart.addItemToDataBase(pr3);
        arguments = new Object[3];
        arguments[0] = cart;
        command = new SearchItemByPriceRange();

    }

    @Test
    public void searchThreeProductListTwoAreInRange() {
        priceFrom = 2.0;
        priceTo = 3.0;
        arguments[1] = priceFrom;
        arguments[2] = priceTo;

        List<Product> resultList = (List) command.execute(arguments);

        assertThat(resultList.size(), is(2));
        assertThat(resultList.get(0).getName(), is("A"));
    }

    @Test (expected = NoSuchItemException.class)
    public void searchThreeProductListNoMatches () {
        priceFrom = 1.0;
        priceTo = 1.5;
        arguments[1] = priceFrom;
        arguments[2] = priceTo;

        List<Product> resultList = (List) command.execute(arguments);

    }



}