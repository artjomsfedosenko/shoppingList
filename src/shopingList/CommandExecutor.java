package shopingList;

import shopingList.commands.Command;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class CommandExecutor {

    private Map<Integer, Command> commandMap;
    private Cart cartToWorkWith;

    public CommandExecutor (Cart cart, Object... args) {
        this.commandMap = new TreeMap();
        this.cartToWorkWith = cart;
        for (int i = 0; i < args.length; i++) {
            this.commandMap.put(i+1, (Command) args[i]);
        }
    }

    public Object executeCommand(Object... args) throws Exception {
        Command c = commandMap.get((Integer) args[0]);
        args[0] = this.cartToWorkWith;
        //Object[] argumentsToPass = prepareArgumentsForCommand(args);
        return c.execute(args);
    }

    private Object[] prepareArgumentsForCommand (Object... args) {
        Object[] tempArgs = new Object[args.length - 1];
        for (int i = 0; i < tempArgs.length; i++) {
            tempArgs[i] = args[i+1];
        }
        return tempArgs;
    }

}
