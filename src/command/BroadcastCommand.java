package command;

import message.Message;
import message.MessageHandler;
import message.Type;

public class BroadcastCommand implements Command {

    @Override
    public String commandName() {
        return "broadcast";
    }

    @Override
    public void execute(String args) {
        MessageHandler.handle(new Message(Type.BROADCAST, args));
    }
}