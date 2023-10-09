package command;

import app.App;
import snapshot.SnapshotCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLIParser implements Runnable {

    private final List<Command> commandList;
    private volatile boolean working = true;

    public CLIParser(SnapshotCollector collector) {
        commandList = new ArrayList<>();
        commandList.add(new SnapshotCommand(collector));
        commandList.add(new BroadcastCommand());
        commandList.add(new InfoCommand());
        commandList.add(new PauseCommand());
        commandList.add(new StopCommand());
        commandList.add(new TransactionBurstCommand());
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (working && sc.hasNextLine()) {
            String commandLine = sc.nextLine();

            if (commandLine.startsWith("#")) {
                continue;
            }

            int spacePos = commandLine.indexOf(" ");

            String commandName;
            String commandArgs = null;
            if (spacePos != -1) {
                commandName = commandLine.substring(0, spacePos);
                commandArgs = commandLine.substring(spacePos + 1);
            } else {
                commandName = commandLine;
            }

            boolean found = false;

            for (Command command : commandList) {
                if (command.commandName().equals(commandName)) {
                    command.execute(commandArgs);
                    found = true;
                    break;
                }
            }

            if (!found) {
                App.error("Unknown command: " + commandName);
            }
        }

        sc.close();
    }

    public void stop() {
        working = false;
    }
}
