package project.dao;


import project.controller.Menu;
import project.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = DbFiller.createFactory();
        //DbFiller.populateDb(); //aby pracowac na juz zrobionej bazie wykomentuj to i zmien  w hibernate.cfg z create na validate

        Menu.menu(factory);



    }

}
