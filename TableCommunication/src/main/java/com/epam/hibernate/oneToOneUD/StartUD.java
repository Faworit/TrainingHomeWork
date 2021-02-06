package com.epam.hibernate.oneToOneUD;

import com.epam.hibernate.oneToOneUD.dao.CredentialDAO;
import com.epam.hibernate.oneToOneUD.dao.HumanDAO;
import com.epam.hibernate.oneToOneUD.dao.impl.CredentialDAOImpl;
import com.epam.hibernate.oneToOneUD.dao.impl.HumanDAOImpl;

public class StartUD {
    private static HumanDAO humanDAO = new HumanDAOImpl();
    private static CredentialDAO credentialDAO = new CredentialDAOImpl();

    public static void main(String[] args) {
        //createHuman();

    }

    private static void createHuman() {
        Credential credential = new Credential("ataman", "horse");
        Human human = new Human("Taras", "Bulba", credential);

        humanDAO.save(human);
    }

    private static Human getHuman(int id) {
        Human human = humanDAO.getHuman(id);
        return human;
    }

    private static void deleteHuman(int id) {
        Human human = getHuman(id);
        humanDAO.deleteHuman(human);
    }

    private static void updateHuman(int id) {
        Human human = getHuman(id);
        humanDAO.updateHuman(human);
    }

    private static void createCredential() {
        Credential credential = new Credential("Faworit", "qwe");
        credentialDAO.saveCredential(credential);
    }

    private static Credential getCredential(int id) {
        Credential credential = credentialDAO.getCredential(id);
        return credential;
    }

    private static void updateCredential(int id) {
        Credential credential = getCredential(id);
        credentialDAO.updateCredential(credential);
    }
}
