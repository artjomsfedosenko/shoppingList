package shopingList.ui;

import java.util.Arrays;
import java.util.Scanner;
import static shopingList.ui.OutputAggregator.*;

public class MenuLoadListFromFile implements Draw {
    @Override
    public Object[] draw(Object... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path to read from, Use / as path delimiter");
        String filepath = sc.nextLine();
        Object[] returnStatement = OutputAggregator.prepareReturn(5, filepath);
        System.out.println();
        return returnStatement;
    }
}
