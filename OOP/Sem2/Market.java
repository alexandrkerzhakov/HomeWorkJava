package GeekBrains.OOP.Sem2;

import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    List<Actor> actorList;

    public Market(List<Actor> actorList) {
        if (actorList == null) {
            this.actorList = new ArrayList<>();
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println("В магазине новый посетитель " + actor.getName() + ".");

    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        Actor deleteActor = actors
                .stream()
                .filter(actor -> actor.isTakeOrder == true)
                .toList()
                .get(0);
        System.out.println("Посетитель " + deleteActor.getName() + " покинул магазин.");
        actorList.remove(deleteActor);

    }

    @Override
    public void update(Actor actor) {
        takeOrders(actor);
        giveOrders(actor);
        releaseFromMarket(actorList);
    }

    @Override
    public void takeInQueue(Actor actor) {
        actor.setMakeOrder();
        if (actor.isMakeOrder) {
            actorList.add(actor);
            System.out.println("Посетитель " + actor.getName() + " находится в очереди.");
        }
    }

    @Override
    public void takeOrders(Actor actor) {
        System.out.println("Посетитель " + actor.getName() + " сделал заказ.");
    }

    @Override
    public void giveOrders(Actor actor) {
        actor.setTakeOrder();
        System.out.println("Посетитель " + actor.getName() + " забрал заказ.");
        releaseFromQueue(actor);
    }

    @Override
    public void releaseFromQueue(Actor actor) {
        System.out.println("Посетитель " + actor.getName() + " покинул очередь.");
    }

    public static void main(String[] args) {
        Human sasha = new Human("Sasha");
        Human pasha = new Human("Pasha");
        Human glasha = new Human("Glasha");

        System.out.println(glasha); // Human{name='Glasha', isMakeOrder=false, isTakeOrder=false}

        Market pyaterochka = new Market(null);

        pyaterochka.acceptToMarket(sasha); // В магазине новый посетитель Sasha.
        pyaterochka.takeInQueue(sasha); // Sasha готов делать заказ. /n Посетитель Sasha находится в очереди.

        pyaterochka.acceptToMarket(pasha); // В магазине новый посетитель Pasha.
        pyaterochka.takeInQueue(pasha); // Pasha готов делать заказ. /n Посетитель Pasha находится в очереди.

        pyaterochka.actorList.stream().forEach(System.out::println); // Human{name='Sasha', isMakeOrder=true, isTakeOrder=false} /n Human{name='Pasha', isMakeOrder=true, isTakeOrder=false}
        pyaterochka.update(sasha); // Посетитель Sasha  сделал заказ. /n Sasha готов забирать заказ. /n Посетитель Sasha забрал заказ. /n Посетитель Sasha покинул очередь. Посетитель Sasha покинул магазин. /n

        pyaterochka.actorList.stream().forEach(System.out::println); // Human{name='Pasha', isMakeOrder=true, isTakeOrder=false}


    }
}
