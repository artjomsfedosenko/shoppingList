package shopingList.commands;

public class Exit implements Command {
    @Override
    public Object execute(Object... args) throws Exception {
        System.exit(0);
        return null;
    }
}
