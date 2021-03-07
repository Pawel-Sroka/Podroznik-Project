package project;


import project.controller.Menu;
import project.dao.DbFiller;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = DbFiller.createFactory();
        //DbFiller.populateDb(); //aby pracowac na juz zrobionej bazie wykomentuj to i zmien  w hibernate.cfg z create na validate
        Menu.menu(factory);
    }
    // Application starts

    // pakiety:
    // 1. controller
    // 2. service
    // 3. dao (data access object) <- baza danych
    // 4. model

    // Model (domain):
    // Wszystkie encje, wszystkie klasy, które są w jakis sposób zapisyuwane w bazie danych

    // Controller <- mapowanie "raw" danych na klasy
    // wejscie do aplikacji (interfejs konsolowy)
    // wc zytaj od uzytkownika
    // wypisz do uzytkownika
    // pokaz menu itd.

    // service (logika biznesowa)
    // operacje na bazach danych
    // obsluga sytuacji biznesowo nieprzewidzianych

    // dao
    // dostep do bazy danych
    // zapisywanie do bazy danych
    // wczytywanie z bazy danych
    // sprawdzanie czy istnieje w bazie
    // cała komunikacja z bazą danych

}
