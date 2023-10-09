package message;

import app.Servent;

public class TransactionMessage extends Message {

    private static final long serialVersionUID = 1L;
    private final int amount;
    private final Servent destination;

    public TransactionMessage(int amount, Servent destination) {
        super(Type.TRANSACTION);

        this.amount = amount;
        this.destination = destination;
    }

    public TransactionMessage(TransactionMessage m) {
        super(m);

        amount = m.amount;
        destination = m.destination;
    }

    @Override
    protected Message copy() {
        return new TransactionMessage(this);
    }

    @Override
    public String toString() {
        return getType() + " of " + amount + " bitcakes to " + destination + " with clock " + getClock();
    }

    public int getAmount() {
        return amount;
    }

    public Servent getDestination() {
        return destination;
    }
}



