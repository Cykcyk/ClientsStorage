package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addAddresses(List<Address> addresses) {
        for(Address address: addresses){
            entityManager.persist(address);
        }
    }

    public List<Address> getAddressByClientId(Long clientId){
        return entityManager.createQuery("select a from Address a where clientId = :clientId").setParameter("clientId", clientId).getResultList();
    }

    public Long addAddressToClient(Address address) {
        entityManager.persist(address);
        entityManager.flush();
        return address.getId();
    }
}
