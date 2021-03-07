package project.dao;

import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

public class DbFiller {

    private static EntityManagerFactory factory;

    public static EntityManagerFactory createFactory() {
        if (factory == null) {
            factory =
                    SessionConnector.createFactory(
                            CommunicationNode.class,
                            Drivers.class, Reservations.class,
                            Tickets.class,
                            Transit.class,
                            TransportCompany.class,
                            Users.class,
                            Vehicles.class);
        }
        return factory;
    }

    public static void populateDb() {
        EntityManager manager = createFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Users user1 = new Users();
        Users user2 = new Users();
        Users user3 = new Users();
        Users user4 = new Users();
        Users user5 = new Users();

        CommunicationNode communicationNode1 = new CommunicationNode();
        CommunicationNode communicationNode2 = new CommunicationNode();
        CommunicationNode communicationNode3 = new CommunicationNode();
        CommunicationNode communicationNode4 = new CommunicationNode();

        Drivers driver1 = new Drivers();
        Drivers driver2 = new Drivers();
        Drivers driver3 = new Drivers();
        Drivers driver4 = new Drivers();

        Vehicles vehicle1 = new Vehicles();
        Vehicles vehicle2 = new Vehicles();
        Vehicles vehicle3 = new Vehicles();

        Tickets tickets1 = new Tickets();
        Tickets tickets2 = new Tickets();

        Reservations reservations1 = new Reservations();

        Transit transit1 = new Transit();
        Transit transit2 = new Transit();
        Transit transit3 = new Transit();
        Transit transit4 = new Transit();
        Transit transit5 = new Transit();
        Transit transit6 = new Transit();

        TransportCompany transportCompany1 = new TransportCompany();
        TransportCompany transportCompany2 = new TransportCompany();
        TransportCompany transportCompany3 = new TransportCompany();

        {

            user1.setUserPersonalId("92019404346");
            user1.setUserFirstName("Adam");
            user1.setUserLastName("Kowalski");

            user2.setUserPersonalId("98021563528");
            user2.setUserFirstName("Tomasz");
            user2.setUserLastName("Niedzielski");
            user2.addReservation(reservations1);

            user3.setUserPersonalId("20152056982");
            user3.setUserFirstName("Grzegorz");
            user3.setUserLastName("Potoczek");

            user4.setUserPersonalId("87120552486");
            user4.setUserFirstName("Andrzej");
            user4.setUserLastName("Kotek");

            user5.setUserPersonalId("76042512548");
            user5.setUserFirstName("Terasa");
            user5.setUserLastName("Górka");

            manager.persist(user1);
            manager.persist(user2);
            manager.persist(user3);
            manager.persist(user4);
            manager.persist(user5);

        }//users

        {
            communicationNode1.setNodeName("Dworzec Główny");
            communicationNode1.setNodeCity("Kraków");
            communicationNode1.setNodeAdress("Pawia 10");

            communicationNode2.setNodeName("Warszawa Centralna");
            communicationNode2.setNodeCity("Warszawa");
            communicationNode2.setNodeAdress("Aleje Jerozolimskie 54");

            communicationNode3.setNodeName("Dworzec Centrlany");
            communicationNode3.setNodeCity("Wrocław");
            communicationNode3.setNodeAdress("Dworcowa 15");

            communicationNode4.setNodeName("Dworzec Centralny");
            communicationNode4.setNodeCity("Poznań");
            communicationNode4.setNodeAdress("Matyi 2");

            manager.persist(communicationNode1);
            manager.persist(communicationNode2);
            manager.persist(communicationNode3);
            manager.persist(communicationNode4);

        }//communicationNode

        {
            driver1.setDriverFirstName("Tomasz");
            driver1.setDriverLastName("Kościuszko");
            driver1.setRate(5);
            driver1.addVehicle(vehicle2);

            driver2.setDriverFirstName("Sławomir");
            driver2.setDriverLastName("Konieczny");
            driver2.setRate(5);
            driver2.addVehicle(vehicle1);

            driver3.setDriverFirstName("Anna");
            driver3.setDriverLastName("Nowacka");
            driver3.setRate(4);
            driver3.addVehicle(vehicle3);

            driver4.setDriverFirstName("Wiesław");
            driver4.setDriverLastName("Kowalski");
            driver4.setRate(4);
            driver4.addVehicle(vehicle2);

            manager.persist(driver1);
            manager.persist(driver2);
            manager.persist(driver3);
            manager.persist(driver4);

        }//drivers

        {
            vehicle1.setVehicleName("Man");
            vehicle1.setSeatsNumber(50);
            vehicle1.setVehicleType(VehicleType.COACH);
            vehicle1.getDriverSet().add(driver2);
            vehicle1.addTransit(transit1);
            vehicle1.addTransit(transit3);

            vehicle2.setVehicleName("Volvo");
            vehicle2.setSeatsNumber(50);
            vehicle2.setVehicleType(VehicleType.COACH);
            vehicle2.addTransit(transit5);
            vehicle2.addTransit(transit6);

            vehicle3.setVehicleName("Pendolino");
            vehicle3.setSeatsNumber(250);
            vehicle3.setVehicleType(VehicleType.TRAIN);
            vehicle3.addTransit(transit2);
            vehicle3.addTransit(transit4);

            manager.persist(vehicle1);
            manager.persist(vehicle2);
            manager.persist(vehicle3);

        }//vechicles

        {
            transportCompany1.setCompanyName("PolskiBus");
            transportCompany1.addDriver(driver2);
            transportCompany1.addVehicle(vehicle1);
            transportCompany1.addTransit(transit3);
            transportCompany1.addTransit(transit6);

            transportCompany2.setCompanyName("NeoBus");
            transportCompany2.addDriver(driver1);
            transportCompany2.addDriver(driver4);
            transportCompany2.addVehicle(vehicle2);
            transportCompany2.addTransit(transit1);
            transportCompany2.addTransit(transit5);

            transportCompany3.setCompanyName("Koleje Regionalne");
            transportCompany3.addDriver(driver3);
            transportCompany3.addVehicle(vehicle3);
            transportCompany3.addTransit(transit2);
            transportCompany3.addTransit(transit4);

            manager.persist(transportCompany1);
            manager.persist(transportCompany2);
            manager.persist(transportCompany3);

        }//transport company

        {
            tickets1.setReservations(reservations1);
            tickets1.setTransit(transit1);
            tickets1.setPrice(17.5);

            tickets2.setTransit(transit2);
            tickets2.setReservations(reservations1);
            tickets2.setPrice(17.0);

            manager.persist(tickets1);
            manager.persist(tickets2);
        }//tickets

        {
            reservations1.setStatus(ReservationStatus.PENDING);
            reservations1.setUsers(user3);
            reservations1.addTicket(tickets1);
            reservations1.addTicket(tickets2);

            manager.persist(reservations1);
        }//Reservations

        {
            transit1.setDepartueTime(LocalDateTime.of(2021,
                    03,10,12,15,00));
            transit1.setDeparturNode(communicationNode2);
            transit1.setArrivalNode(communicationNode3);
            transit1.setArrivalTime(LocalDateTime.of(2021,
                    03,10,13,30,00));
            transit1.addTicket(tickets1);



            transit2.setDepartueTime(LocalDateTime.of(2021,
                    03,11,9,10,00));
            transit2.setDeparturNode(communicationNode3);
            transit2.setArrivalNode(communicationNode2);
            transit2.setArrivalTime(LocalDateTime.of(2021,
                    03,11,10,30,00));
            transit2.addTicket(tickets2);



            transit3.setDepartueTime(LocalDateTime.of(2021,
                    03,21,19,10,00));
            transit3.setDeparturNode(communicationNode4);
            transit3.setArrivalNode(communicationNode2);
            transit3.setArrivalTime(LocalDateTime.of(2021,
                    03,21,21,30,00));


            transit4.setDepartueTime(LocalDateTime.of(2021,
                    03,11,19,10,00));
            transit4.setDeparturNode(communicationNode4);
            transit4.setArrivalNode(communicationNode1);
            transit4.setArrivalTime(LocalDateTime.of(2021,
                    03,11,20,30,00));


            transit5.setDepartueTime(LocalDateTime.of(2021,
                    03,11,15,10,00));
            transit5.setDeparturNode(communicationNode1);
            transit5.setArrivalNode(communicationNode3);
            transit5.setArrivalTime(LocalDateTime.of(2021,
                    03,11,20,30,00));


            transit6.setDepartueTime(LocalDateTime.of(2021,
                    03,9,19,10,00));
            transit6.setDeparturNode(communicationNode4);
            transit6.setArrivalNode(communicationNode3);
            transit6.setArrivalTime(LocalDateTime.of(2021,
                    03,11,11,30,00));


            manager.persist(transit1);
            manager.persist(transit2);
            manager.persist(transit3);
            manager.persist(transit4);
            manager.persist(transit5);
            manager.persist(transit6);
        }//transit

        transaction.commit();
        manager.close();
    }
}
