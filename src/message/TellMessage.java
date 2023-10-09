package message;

import app.Servent;
import snapshot.Snapshot;
import message.Type;

public class TellMessage extends Message {

    private static final long serialVersionUID = 1L;

    private final Snapshot snapshot;
    private final Servent destination;

    public TellMessage(Snapshot snapshot, Servent destination) {
        super(Type.TELL);

        this.snapshot = snapshot;
        this.destination = destination;
    }

    public TellMessage(TellMessage m) {
        super(m);

        snapshot = m.snapshot;
        destination = m.destination;
    }

    @Override
    protected Message copy() {
        return new TellMessage(this);
    }

    @Override
    public String toString() {
        return getType() + " of " + snapshot.getBalance() + " bitcakes with clock " + getClock();
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public Servent getDestination() {
        return destination;
    }
}
