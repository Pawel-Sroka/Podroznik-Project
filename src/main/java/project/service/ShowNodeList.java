package project.service;

import project.dao.SessionConnector;
import project.model.CommunicationNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class ShowNodeList {

    public static void showNodeList(EntityManagerFactory factory){
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Scanner sc =new Scanner(System.in);

    TypedQuery<CommunicationNode> fromCommunicationNode = manager.createQuery("from CommunicationNode", CommunicationNode.class);
    List<CommunicationNode> fromNodeList = fromCommunicationNode.getResultList();
        System.out.println();
    for (CommunicationNode node : fromNodeList){
        System.out.println("Nazwa dworca: " + node.getNodeName() + "\nMiasto: " + node.getNodeCity() + "\nulica: " + node.getNodeAdress());
        System.out.println();
    }
        System.out.println("type enter to continue...");
    sc.nextLine();
    transaction.commit();
}
}
