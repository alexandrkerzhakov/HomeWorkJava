package GeekBrains.OOP.Sem2;

public interface QueueBehaviour {

    void takeInQueue(Actor actor);

    void takeOrders(Actor actor);

    void giveOrders(Actor actor);

    void releaseFromQueue(Actor actor);

}
