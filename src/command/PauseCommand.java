package command;

import app.App;

public class PauseCommand implements Command {

    @Override
    public String commandName() {
        return "pause";
    }

    @Override
    public void execute(String args) {

        int ms = -1;

        try{
            ms = Integer.parseInt(args);

            App.print("Pausing for " + ms + " ms");

            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }catch (NumberFormatException e) {
            App.print("Pause command should have one int argument, which is time in ms.");
        }
    }
}
