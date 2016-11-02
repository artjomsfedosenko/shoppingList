package shopingList;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> list = new ArrayList();

    public void addItemToDataBase (Product product) {
        this.list.add(product);
    }

    public boolean removeItemFromDataBaseByName (String name) {

        if (!containsName(name)) {
            return false;
        }
        while (containsName(name)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(name)) {
                    list.remove(i);
                }
            }
        }
        return true;
    }

    private boolean containsName (String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> listItems () {
        return this.list;
    }

}
