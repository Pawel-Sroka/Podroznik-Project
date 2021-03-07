package project.service;

import project.model.Transit;
import project.model.TransportCompany;
import project.model.Users;
import project.model.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class TransportCompanyService {



    public static void addTransportCompany (EntityManagerFactory factory){

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę firmy: ");
        String name = sc.nextLine();


        TransportCompany transportCompany = new TransportCompany();
        transportCompany.setCompanyName(name);

        //<Users> query =
         //       manager.createQuery("FROM TransportCompany WHERE companyName = " + name, Users.class);





            manager.persist(transportCompany);
            transaction.commit();
            manager.close();


    }

    public static void getCompanyData (EntityManagerFactory factory) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        TypedQuery<TransportCompany> fromTransportCompany = manager.createQuery("from TransportCompany", TransportCompany.class);
        List<TransportCompany> fromCompanyList = fromTransportCompany.getResultList();
        for (TransportCompany company : fromCompanyList) {
            System.out.println(company.getCompanyName());
        }
        transaction.commit();
        manager.close();
    }

}
