package shopingList.ui;

import java.util.Arrays;
import java.util.Scanner;
import static shopingList.ui.OutputAggregator.*;
import static shopingList.ui.OutputAggregator.*;

public class MenuDeleteItem implements Draw {

    @Override
    public Object[] draw(Object... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product to remove");
        String productToRemoveName = sc.nextLine();
        Object[] statementToReturn = OutputAggregator.prepareReturn(3, productToRemoveName);
        System.out.println();
        return statementToReturn;
    }
}
