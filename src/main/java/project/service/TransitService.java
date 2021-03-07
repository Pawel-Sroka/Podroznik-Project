package project.service;

import project.model.Transit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransitService {


    public static void getTransitData (EntityManager manager) {

        System.out.println("Lista dostępnych połączeń");
        TypedQuery<Transit> fromTransit = manager
                .createQuery("from transit", Transit.class);
        List<Transit> fromTransitList = fromTransit.getResultList();
        for (Transit transit : fromTransitList) {
            System.out.println("Odjazd z : " + transit.getDeparturNode()
                    + " do: " + transit.getArrivalNode()
                    + " odjazd o godzinie: " + transit.getDepartueTime()
                    + " przyjazd o godzinie: " + transit.getArrivalTime()
                    + ". Przewoźnik: "
                    + ". Dostępne miejsca: "
                    + ". Pojazd: ");
        }

    }
}
