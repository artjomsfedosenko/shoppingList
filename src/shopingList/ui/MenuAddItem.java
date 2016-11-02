package shopingList.ui;

import static shopingList.ui.OutputAggregator.*;
import java.util.Scanner;

public class MenuAddItem implements Draw {

    @Override
    public Object[] draw(Object... args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter product name");
        String productName = sc.nextLine();

        System.out.println("Enter product price");
        Double productPrice = sc.nextDouble();

        System.out.println("Enter product quantity");
        Double productQuantity = sc.nextDouble();

        sc.nextLine();

        System.out.println("Enter product group");
        String productGroup = sc.nextLine();
        System.out.println();

        Object[] returnStatement = OutputAggregator.prepareReturn(1, productName, productPrice, productQuantity, productGroup);

        return returnStatement;
    }

}
