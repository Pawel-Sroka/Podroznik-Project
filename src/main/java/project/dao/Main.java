package project.dao;


import project.controller.Menu;
import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManager manager = DbFiller.createFactory().createEntityManager();
        DbFiller.populateDb();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Menu.menu(manager,transaction);


        manager.close();



    }

}
