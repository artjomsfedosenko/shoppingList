package shopingList;

import shopingList.ui.*;

/**
 * Created by Artjom on 23.09.2016..
 */
public class UICreator {

    public MainMenu create (CommandExecutor executor) {
        Draw[] argsForUI = new Draw[7];

        argsForUI[0] = new MenuAddItem();
        argsForUI[1] = new MenuListItems();
        argsForUI[2] = new MenuDeleteItem();
        argsForUI[3] = new MenuSaveListToFile();
        argsForUI[4] = new MenuLoadListFromFile();
        argsForUI[5] = new MenuSearchForItem();

        MainMenu mainMenu = new MainMenu(executor, argsForUI);
        return mainMenu;
    }

}
