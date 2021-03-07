package project.service;

import project.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
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

       // TypedQuery<Users> query =
        //        manager.createQuery("FROM Users WHERE userPersonalID = ?1 ", Users.class);
        //boolean isOnTheList = query.getParameter(1).equals(personalId);

        //if (isOnTheList) {
         //   System.out.println("Ten użytkownik już istnieje! ");
         //   transaction.rollback();
        //} else {
            Users newUser = new Users();
            newUser.setUserPersonalId(personalId);
            newUser.setUserFirstName(firstName);
            newUser.setUserLastName(lastName);
            manager.persist(newUser);
            transaction.commit();
        //}

    }
}
