package project.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class ConnectToDb {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure();

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();



        transaction.commit();
        session.close();
    }

}
