package project.controller;

import project.model.TransportCompany;
import project.service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Scanner;

public class Menu {


    public static void menu (EntityManagerFactory factory) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do  {
            System.out.println("\n******* Witamy w Podróżnik 2.0 *******\n");
            System.out.println("1. Lista dostępnych połączeń ");
            System.out.println("2. Dokonaj rezerwacji ");
            System.out.println("3. Lista Wezwłów komunikacyjnych ");
            System.out.println("4. Twoje bilety ");
            System.out.println("5. Dodaj użytkownika");
            System.out.println("6. Dodaj połączenie");
            System.out.println("7. Dodaj pojazd");
            System.out.println("8. Dodaj firmę przewozową");

            System.out.println("10. Wyjście\n");

            System.out.println("Wybierz opcję: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista dostępnych połączeń: ");
                    TransitService.getTransitData(factory);
                    break;
                case 2:
                    System.out.println("Dokonaj rezerwacji: ");
                    DoReservation.doReservation(factory);
                    break;
                case 3:
                    System.out.println("Lista Wezwłów komunikacyjnych: ");
                    ShowNodeList.showNodeList(factory);
                    break;
                case 4:
                    System.out.println("Twoje bilety: ");

                    break;
                case 5:
                    System.out.println("Dodaj użytkownika: ");
                    AddUser.addUser(factory);
                    break;
                case 6:
                    System.out.println("Dodaj połączenie: ");

                    break;
                case 7:
                    System.out.println("Dodaj pojazd: ");
                    VehicleService.addVehicle(factory);
                    break;
                case 8:
                    System.out.println("Dodaj firmę przewozową: ");
                    TransportCompanyService.addTransportCompany(factory);
                    break;
                case 10:
                    System.out.println("Dziekujemy do zobaczenia ponownie.");
                    break;
                default:
                    System.out.println("Wypierz poprawną opcję");

            }

        }
        while (choice != 10);
    }


}
