package project.service;

import project.model.Transit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class TransitService {


    public static void getTransitData (EntityManagerFactory factory) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Scanner sc = new Scanner(System.in);
        TypedQuery<Transit> fromTransit = manager
                .createQuery("from Transit order by departueTime", Transit.class);
        List<Transit> fromTransitList = fromTransit.getResultList();
        System.out.println("-----Lista dostępnych połączeń-----");
        for (Transit transit : fromTransitList) {
            System.out.println("Id połączenie: " + transit.getTransitId() +
                    "\nData: " + transit.getDepartueTime().getDayOfMonth() + "/" + transit.getDepartueTime().getMonth() + "/" + transit.getDepartueTime().getYear()
                    + "\nOdjazd z : " + transit.getDeparturNode().getNodeCity() + ", " + transit.getDeparturNode().getNodeName()
                    + " do: " + transit.getArrivalNode().getNodeCity() + ", " + transit.getArrivalNode().getNodeName()
                    + " \nOdjazd o godzinie: " + transit.getDepartueTime().getHour() + ":" + transit.getDepartueTime().getMinute()
                    + " przyjazd o godzinie: " + transit.getArrivalTime().getHour() + ":" + transit.getArrivalTime().getMinute()
                    + ". \nPrzewoźnik: " + transit.getTransportCompany().getCompanyName()
                    + ". \nDostępne miejsca: " + transit.getVehicle().getSeatsNumber()
                    + ". \nPojazd: " + transit.getVehicle().getVehicleName());
            System.out.println();
        }
        System.out.println("type enter to continue...");
        sc.nextLine();
        manager.close();
    }



}
