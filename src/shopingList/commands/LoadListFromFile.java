package shopingList.commands;

import shopingList.Cart;
import shopingList.Product;
import shopingList.StringParserForLoadFile;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoadListFromFile implements Command {
    @Override
    public Object execute(Object... args) throws Exception {
        Cart cart = (Cart) args[0];
        String filepath = (String) args[1];

        FileReader fileToRead = new FileReader(filepath);
        BufferedReader reader = new BufferedReader(fileToRead);
        String stringToParse = new String();
        StringParserForLoadFile parser = new StringParserForLoadFile();

        while ((stringToParse = reader.readLine()) != null) {

            String[] tempArray = parser.parseProductEntry(stringToParse);

            String name = tempArray[0];
            double price = new Double(tempArray[1]);
            double quantity = new Double(tempArray[2]);
            String group = tempArray[3];

            Product pr = new Product(name, price, quantity, group);
            cart.addItemToDataBase(pr);

        }

        reader.close();

        return null;
    }
}
