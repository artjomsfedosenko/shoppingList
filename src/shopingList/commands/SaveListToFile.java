package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class SaveListToFile implements Command {
    @Override
    public Object execute(Object... args) throws Exception {

        Cart cart = (Cart) args[0];
        String filePath = (String) args[1];
        List<Product> tempList = cart.listItems();

        FileWriter fileToWrite = new FileWriter(filePath);
        BufferedWriter writer = new BufferedWriter(fileToWrite);

        for (Product pr : tempList) {
            writer.write(pr.toString());
            writer.newLine();
        }

        writer.close();

        return null;
    }
}
