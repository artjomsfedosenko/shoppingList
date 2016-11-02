package shopingList;

public class StringParserForLoadFile {

    public String[] parseProductEntry (String str) {

        String string = str;
        string = string.substring(8, string.length() - 1);

        String[] tempStringArray = string.split(",");
        String name = tempStringArray[0].trim();
        String price = tempStringArray[1].trim();
        String quantity = tempStringArray[2].trim();
        String group = tempStringArray[3].trim();

        name = name.substring(name.indexOf("=") + 2, name.length() - 1);
        price = price.substring(price.indexOf("=") + 1, price.length());
        quantity = quantity.substring(quantity.indexOf("=") + 1, quantity.length());
        group = group.substring(group.indexOf("=") + 2, group.length() - 1);

        String[] parsedString = {name, price, quantity, group};

        return parsedString;
    }

}
