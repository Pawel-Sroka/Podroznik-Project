package project.service;

import project.model.Transit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class TransitService {


    public static void getTransitData (EntityManager manager) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Lista dostępnych połączeń-----");
        TypedQuery<Transit> fromTransit = manager
                .createQuery("from Transit", Transit.class);
        List<Transit> fromTransitList = fromTransit.getResultList();
        for (Transit transit : fromTransitList) {
            System.out.println("Data: " + transit.getDepartueTime().getDayOfMonth() + "/" + transit.getDepartueTime().getMonth() + "/" + transit.getDepartueTime().getYear()
                    + "\nOdjazd z : " + transit.getDeparturNode().getNodeCity() + ", " + transit.getDeparturNode().getNodeName()
                    + " do: " + transit.getArrivalNode().getNodeCity() + ", " + transit.getArrivalNode().getNodeName()
                    + " \nOdjazd o godzinie: " + transit.getDepartueTime().getHour() + ":" + transit.getDepartueTime().getMinute()
                    + " przyjazd o godzinie: " + transit.getArrivalTime().getHour() + ":" + transit.getArrivalTime().getMinute()
                    + ". \nPrzewoźnik: "
                    + ". \nDostępne miejsca: "
                    + ". \nPojazd: " );
            System.out.println();
        }
        System.out.println("type enter to continue...");
        sc.nextLine();
    }



}
