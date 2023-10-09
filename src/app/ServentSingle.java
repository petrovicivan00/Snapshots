package app;

import command.CLIParser;
import message.MessageHandler;
import message.MessageListener;
import snapshot.SnapshotCollector;

public class ServentSingle {

    private static SnapshotCollector collector;
    private static MessageListener listener;
    private static CLIParser parser;

    public static void main(String[] args) {
        Config.load(args[0], Integer.parseInt(args[1]));

        App.print("Starting servent " + Config.LOCAL_SERVENT);

        collector = new SnapshotCollector();
        new Thread(collector).start();

        MessageHandler handler = new MessageHandler(collector);
        new Thread(handler).start();

        listener = new MessageListener();
        new Thread(listener).start();

        parser = new CLIParser(collector);
        new Thread(parser).start();

    }

    public static void stop() {
        App.print("Stopping");

        collector.stop();
        listener.stop();
        parser.stop();
    }
}
