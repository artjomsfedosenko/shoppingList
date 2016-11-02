package shopingList.ui;

import java.util.Scanner;
import static shopingList.ui.OutputAggregator.*;

public class MenuSaveListToFile implements Draw {
    @Override
    public Object[] draw(Object... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path and file name to save to. Use / as path delimiter");
        String filePath = sc.nextLine();
        Object[] statementToReturn = OutputAggregator.prepareReturn(4, filePath);
        System.out.println();
        return statementToReturn;
    }
}
