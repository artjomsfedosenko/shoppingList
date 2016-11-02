package shopingList.ui;

public class OutputAggregator {

    public static Object[] prepareReturn (int commandIndex, Object... args) {
        Object[] returnStatement = new Object[args.length + 1];
        for (int i = 1; i < returnStatement.length; i++) {
            returnStatement[i] = args[i-1];
        }
        returnStatement[0] = commandIndex;
        return returnStatement;
    }
}

