package project.service;

import project.model.TransportCompany;
import project.model.Users;
import project.model.VehicleType;
import project.model.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class VehicleService {

    public static void addVehicle (EntityManager manager, EntityTransaction transaction) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę pojazdu: ");
        String name = sc.nextLine();
        System.out.println("Podaj liczbę dostępnych miejsc: ");
        int numberOfSeats = sc.nextInt();
        System.out.println("Wybierz typ pojazdu: ");
        System.out.println("Dostępne typy: ");
        System.out.println(Arrays.toString(VehicleType.values()));
        System.out.println("Wybierz swój typ: ");
        String vehicleType = sc.next().toUpperCase();

//        System.out.println("Przypisz pojazd do firmy przewozowej: ");
//        System.out.println("Dostępne firmy przewozowe: ");
//        TransitService.getTransitData(manager);
//        String company = sc.nextLine();



        Vehicles newVehicle = new Vehicles();
        newVehicle.setVehicleName(name);
        newVehicle.setSeatsNumber(numberOfSeats);
        switch (vehicleType) {
            case "COACH":
                newVehicle.setVehicleType(VehicleType.COACH);
            case "TRAIN":
                newVehicle.setVehicleType(VehicleType.TRAIN);
            case "SMALL_BUS":
                newVehicle.setVehicleType(VehicleType.SMALL_BUS);
        }




        manager.persist(newVehicle);
        transaction.commit();
        System.out.println();
        System.out.println("Pojazd został dodany");

        }


}
