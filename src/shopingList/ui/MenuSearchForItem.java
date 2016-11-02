package shopingList.ui;

import shopingList.Product;

import java.util.List;
import java.util.Scanner;
import static shopingList.ui.OutputAggregator.*;


public class MenuSearchForItem implements Draw{
    @Override
    public Object[] draw(Object... args) {
        if (args.length != 0) {
            List<Product> listToShow = (List) args[0];
            drawList(listToShow);
            return null;
        } else {
            Scanner sc = new Scanner(System.in);

            System.out.println();
            System.out.println("1 - search for item by price range");
            System.out.println("2 - search for item by name");
            int returnValue = sc.nextInt();
            if (returnValue == 1) {
                return getItemPriceRange();
            } else {
                return getItemName();
            }
        }

    }

    private Object[] getItemPriceRange () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter price range lower bound");
        Double from = sc.nextDouble();
        System.out.println("Enter price range higher bound");
        Double to = sc.nextDouble();
        Object[] returnStatement = OutputAggregator.prepareReturn(7, from, to);
        return returnStatement;
    }

    private Object[] getItemName () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item name");
        String itemName = sc.nextLine();
        Object[] returnStatement = OutputAggregator.prepareReturn(6, itemName);
        return returnStatement;
    }

    public void drawList(List<Product> listToShow) {
        int counter = 1;
        for (Product pr: listToShow) {
            System.out.println(counter + ". " + pr);
            counter++;
        }
        System.out.println();
    }
}
