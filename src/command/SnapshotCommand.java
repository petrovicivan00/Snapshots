package command;

import app.App;
import snapshot.SnapshotCollector;

public class SnapshotCommand implements Command {

    private final SnapshotCollector collector;

    public SnapshotCommand(SnapshotCollector collector) {
        this.collector = collector;
    }

    @Override
    public String commandName() {
        return "snapshot";
    }

    @Override
    public void execute(String args) {
        App.print("Snapshotting");

        collector.startCollecting();
    }
}
