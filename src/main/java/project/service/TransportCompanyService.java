package project.service;

import project.model.Transit;
import project.model.TransportCompany;
import project.model.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Scanner;

public class TransportCompanyService {



    public static void addTransportCompany (EntityManager manager, EntityTransaction transaction) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę firmy: ");
        String name = sc.nextLine();


        TransportCompany transportCompany = new TransportCompany();
        transportCompany.setCompanyName(name);


        manager.persist(transportCompany);
        transaction.commit();

    }
}
