package project.service;

import project.dao.SessionConnector;
import project.model.CommunicationNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShowNodeList {

    public static void showNodeList(EntityManager manager){

    TypedQuery<CommunicationNode> fromCommunicationNode = manager.createQuery("from CommunicationNode", CommunicationNode.class);
    List<CommunicationNode> fromNodeList = fromCommunicationNode.getResultList();
    for (CommunicationNode node : fromNodeList){
        System.out.println("Nazwa dworca: " + node.getNodeName() + "\nMiasto: " + node.getNodeCity() + "\nulica: " + node.getNodeAdress());
    }

}
}
