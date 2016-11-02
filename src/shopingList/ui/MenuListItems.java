package shopingList.ui;

import shopingList.Product;

import java.util.List;

public class MenuListItems implements Draw {
    @Override
    public Object[] draw(Object... args) {
        List<Product> listToShow = (List) args[0];
        int counter = 1;

        for (Product pr: listToShow) {
            System.out.println(counter + ". " + pr);
            counter++;
        }

        System.out.println();
        return null;
    }
}
