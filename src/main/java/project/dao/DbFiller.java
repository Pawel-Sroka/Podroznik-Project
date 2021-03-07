package project.dao;

import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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

        Drivers driver1 = new Drivers();
        Drivers driver2 = new Drivers();
        Drivers driver3 = new Drivers();
        Drivers driver4 = new Drivers();

        Vehicles vehicle1 = new Vehicles();
        Vehicles vehicle2 = new Vehicles();
        Vehicles vehicle3 = new Vehicles();

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

            manager.persist(communicationNode1);
            manager.persist(communicationNode2);
            manager.persist(communicationNode3);

        }//communicationNode
        {
            driver1.setDriverFirstName("Tomasz");
            driver1.setDriverLastName("Kościuszko");
            driver1.setRate(5);

            driver2.setDriverFirstName("Sławomir");
            driver2.setDriverLastName("Konieczny");
            driver2.setRate(5);

            driver3.setDriverFirstName("Anna");
            driver3.setDriverLastName("Nowacka");
            driver3.setRate(4);

            driver4.setDriverFirstName("Wiesław");
            driver4.setDriverLastName("Kowalski");
            driver4.setRate(4);

            manager.persist(driver1);
            manager.persist(driver2);
            manager.persist(driver3);
            manager.persist(driver4);

        }//drivers
        {
            vehicle1.setVehicleName("Man");
            vehicle1.setSeatsNumber(50);
            vehicle1.setVehicleType(VehicleType.COACH);

            vehicle2.setVehicleName("Volvo");
            vehicle2.setSeatsNumber(50);
            vehicle2.setVehicleType(VehicleType.COACH);

            vehicle3.setVehicleName("Pendolino");
            vehicle3.setSeatsNumber(250);
            vehicle3.setVehicleType(VehicleType.TRAIN);

            manager.persist(vehicle1);
            manager.persist(vehicle2);
            manager.persist(vehicle3);

        }//vechicles
        {
            transportCompany1.setCompanyName("PolskiBus");
            transportCompany1.addDriver(driver2);
            transportCompany1.addVehicle(vehicle1);

            transportCompany2.setCompanyName("NeoBus");
            transportCompany2.addDriver(driver1);
            transportCompany2.addDriver(driver4);
            transportCompany2.addVehicle(vehicle2);

            transportCompany3.setCompanyName("Koleje Regionalne");
            transportCompany3.addDriver(driver3);
            transportCompany3.addVehicle(vehicle3);

            manager.persist(transportCompany1);
            manager.persist(transportCompany2);
            manager.persist(transportCompany3);

        }//transport company
        transaction.commit();
        manager.close();
    }
}
