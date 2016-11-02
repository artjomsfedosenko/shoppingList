package shopingList.ui;

import shopingList.CommandExecutor;
import shopingList.Product;
import shopingList.commands.Command;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainMenu {

    private Map<Integer, Draw> menuChoices;
    private CommandExecutor executor;

    public MainMenu(CommandExecutor executor, Object... args) {
        this.executor = executor;
        this.menuChoices = new TreeMap();
        for (int i = 0; i < args.length; i++) {
            this.menuChoices.put(i+1, (Draw) args[i]);
        }
    }

    public void displayAvailableChoices() {
        System.out.println("1 - add an item");
        System.out.println("2 - list items");
        System.out.println("3 - delete an item");
        System.out.println("4 - save list to file");
        System.out.println("5 - load list from file");
        System.out.println("6 - search for item");
        System.out.println("7 - exit");
    }

    public void promptUserToMakeChoice() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice");
        Integer choice = sc.nextInt();
        selectMenuItem(choice);

    }

    private void selectMenuItem(int input) throws Exception {
        switch (input) {
            case 1:
                Draw addItem = menuChoices.get(1);
                executor.executeCommand(addItem.draw());
                break;
            case 2:
                List<Product> list = (List) executor.executeCommand(2);
                Draw listItems = menuChoices.get(2);
                listItems.draw(list);
                break;
            case 3:
                Draw deleteItem = menuChoices.get(3);
                executor.executeCommand(deleteItem.draw());
                break;
            case 4:
                Draw saveListToFile = menuChoices.get(4);
                executor.executeCommand(saveListToFile.draw());
                break;
            case 5:
                Draw loadListFromFile = menuChoices.get(5);
                executor.executeCommand(loadListFromFile.draw());
                break;
            case 6:
                Draw searchForItem = menuChoices.get(6);
                list = (List) executor.executeCommand(searchForItem.draw());
                searchForItem.draw(list);
                break;
            case 7:
                executor.executeCommand(8);
                break;
            default:

        }


    }
}