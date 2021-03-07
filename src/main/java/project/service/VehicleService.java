package project.service;

import project.model.VehicleType;
import project.model.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
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
        String vehicleType = sc.next();


        Vehicles newVehicle = new Vehicles();
        newVehicle.setVehicleName(name);
        newVehicle.setSeatsNumber(numberOfSeats);
        newVehicle.setVehicleType(VehicleType.valueOf(vehicleType));

        manager.persist(newVehicle);
        transaction.commit();

        }


}
