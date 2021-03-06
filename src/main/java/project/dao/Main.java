package project.dao;


import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                SessionConnector.createFactory(ComunicationNode.class, Drivers.class, Reservations.class,
                        Tickets.class, Transit.class, TransportCompany.class, Users.class, Vehicles.class );
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();


        Users user1 = new Users();
        user1.setUserPersonalId("92019404346");
        user1.setUserFirstName("Adam");
        user1.setUserLastName("Kowalski");

        Users user2 = new Users();
        user1.setUserPersonalId("98021563528");
        user1.setUserFirstName("Tomasz");
        user1.setUserLastName("Niedzielski");

        Users user3 = new Users();
        user1.setUserPersonalId("20152056982");
        user1.setUserFirstName("Grzegorz");
        user1.setUserLastName("Potoczek");

        Users user4 = new Users();
        user1.setUserPersonalId("87120552486");
        user1.setUserFirstName("Andrzej");
        user1.setUserLastName("Kotek");

        Users user5 = new Users();
        user1.setUserPersonalId("76042512548");
        user1.setUserFirstName("Terasa");
        user1.setUserLastName("Górka");


        ComunicationNode comunicationNode1 = new ComunicationNode();
        comunicationNode1.setNodeName("Dworzec Główny");
        comunicationNode1.setNodeCity("Kraków");
        comunicationNode1.setNodeAdress("Pawia 10");

        ComunicationNode comunicationNode2 = new ComunicationNode();
        comunicationNode2.setNodeName("Warszawa Centralna");
        comunicationNode2.setNodeCity("Warszawa");
        comunicationNode2.setNodeAdress("Aleje Jerozolimskie 54");

        ComunicationNode comunicationNode3 = new ComunicationNode();
        comunicationNode3.setNodeName("Dworzec Centrlany");
        comunicationNode3.setNodeCity("Wrocław");
        comunicationNode3.setNodeAdress("Dworcowa 15");


        Drivers driver1 = new Drivers();
        driver1.setDriverFirstName("Tomasz");
        driver1.setDriverLastName("Kościuszko");
        driver1.setRate(5);

        Drivers driver2 = new Drivers();
        driver2.setDriverFirstName("Sławomir");
        driver2.setDriverLastName("Konieczny");
        driver2.setRate(5);

        Drivers driver3 = new Drivers();
        driver3.setDriverFirstName("Anna");
        driver3.setDriverLastName("Nowacka");
        driver3.setRate(4);

        Drivers driver4 = new Drivers();
        driver4.setDriverFirstName("Wiesław");
        driver4.setDriverLastName("Kowalski");
        driver4.setRate(4);

        TransportCompany transportCompany1 = new TransportCompany();
        transportCompany1.setCompanyName("PolskiBus");

        TransportCompany transportCompany2 = new TransportCompany();
        transportCompany2.setCompanyName("NeoBus");

        Vehicles vehicle1 = new Vehicles();
        vehicle1.setVehicleName("Man");
        vehicle1.setSeatsNumber(50);
        vehicle1.setVehicleType(VehicleType.COACH);

        Vehicles vehicle2 = new Vehicles();
        vehicle2.setVehicleName("Volvo");
        vehicle2.setSeatsNumber(50);
        vehicle2.setVehicleType(VehicleType.COACH);

        Vehicles vehicle3 = new Vehicles();
        vehicle3.setVehicleName("Pendolino");
        vehicle3.setSeatsNumber(250);
        vehicle3.setVehicleType(VehicleType.TRAIN);



        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);
        manager.persist(user4);
        manager.persist(user5);

        manager.persist(comunicationNode1);
        manager.persist(comunicationNode2);
        manager.persist(comunicationNode3);

        manager.persist(driver1);
        manager.persist(driver2);
        manager.persist(driver3);
        manager.persist(driver4);

        manager.persist(transportCompany1);
        manager.persist(transportCompany2);


        transaction.commit();
        manager.close();



    }

}
