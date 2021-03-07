package project.service;

import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class DoReservation {
    public static void doReservation(EntityManager manager){
        Reservations reservations = new Reservations();
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz użytkownika: ");
        TypedQuery<Users> fromUsers = manager.createQuery("from Users", Users.class);
        List<Users> usersResultList = fromUsers.getResultList();
        System.out.println();
        for (Users users: usersResultList){
            System.out.println(users.getUserId() + ". imie: " + users.getUserFirstName() + " nazwisko: " + users.getUserLastName());
        }
        Long selectedUserId = sc.nextLong();

        TypedQuery<Users> userSelectedToReservation = manager.createQuery("select u from Users u where u.userId = ' " + selectedUserId + "'", Users.class);
        Users userTypedToReservation = userSelectedToReservation.getSingleResult();

        TransitService.getTransitData(manager);
        System.out.println("wybierz Id połączenia które chcesz zarazerwowac: ");
        Long transitSelectedId = sc.nextLong();

        TypedQuery<Transit> selectedTransitToReservate = manager.createQuery("select u from Transit u where u.transitId = ' " + transitSelectedId + "'", Transit.class);
        Transit typedTransitToReservation = selectedTransitToReservate.getSingleResult();

        Tickets ticketToReservation = new Tickets();

        ticketToReservation.setReservations(reservations);
        ticketToReservation.setPrice(typedTransitToReservation.getTransitId() * 15.0);
        ticketToReservation.setTransit(typedTransitToReservation);


        reservations.setUsers(userTypedToReservation);
        reservations.setStatus(ReservationStatus.CONFIRMED);
        reservations.addTicket(ticketToReservation);

        manager.persist(ticketToReservation);
        manager.persist(reservations);

        System.out.println("Twoja rezerwacja: " + ticketToReservation.getTransit().getDeparturNode().getNodeCity() +  " - "
                +ticketToReservation.getTransit().getArrivalNode().getNodeCity()
        + "\n odjazd: " + ticketToReservation.getTransit().getDepartueTime().getHour() + ":" + ticketToReservation.getTransit().getDepartueTime().getMinute()
        + "\n Cena: " + ticketToReservation.getPrice());


    }



}
