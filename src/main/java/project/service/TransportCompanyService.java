package project.service;

import project.model.Transit;
import project.model.TransportCompany;
import project.model.Users;
import project.model.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class TransportCompanyService {



    public static void addTransportCompany (EntityManager manager, EntityTransaction transaction) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę firmy: ");
        String name = sc.nextLine();


        TransportCompany transportCompany = new TransportCompany();
        transportCompany.setCompanyName(name);

        //<Users> query =
         //       manager.createQuery("FROM TransportCompany WHERE companyName = " + name, Users.class);





            manager.persist(transportCompany);
            transaction.commit();


    }
}
