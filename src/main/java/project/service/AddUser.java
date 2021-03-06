package project.service;

import project.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Scanner;

public class AddUser {
    public static void addUser(EntityManager manager, EntityTransaction transaction){
        Scanner sc = new Scanner(System.in);
        String personalId,firstName,lastName;
        System.out.println("Podaj imię: ");
        firstName = sc.nextLine();
        System.out.println("Podaj nazwisko: ");
        lastName = sc.nextLine();
        System.out.println("podaj pesel: ");
        personalId = sc.nextLine();

        transaction.begin();
        Users user = new Users();
        user.setUserPersonalId(personalId);
        user.setUserFirstName(firstName);
        user.setUserLastName(lastName);
        manager.persist(user);
        transaction.commit();


    }
}
