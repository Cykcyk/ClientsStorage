package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ClientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Client getClient(Long id) {
        return entityManager.find(Client.class, id);
    }

    public Long addClient(Client client) {
        entityManager.persist(client);
        entityManager.flush();
        return client.getId();
    }

    public ClientDAO() {
    }

    public List getClients() {
        return entityManager.createQuery("SELECT c from Client c").getResultList();

    }
}
