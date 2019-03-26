package app.service;

import app.dao.Address;
import app.dao.AddressDAO;
import app.dao.Client;
import app.dao.ClientDAO;
import app.dto.AddressDTO;
import app.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ClientService {

    @Autowired
    ClientDAO clientDAO;
    @Autowired
    AddressDAO addressDAO;

    public ClientDTO getClientWithAddresses(Long id) {
        Client client = clientDAO.getClient(id);
        List<Address> addresses = addressDAO.getAddressByClientId(id);
        List<AddressDTO> dtoAddresses = createDTOAddressesFromAddresses(addresses);
        return new ClientDTO(client.getFirstName(), client.getLastName(), client.getEmailAddress(), client.getPhoneNumber(), dtoAddresses);
    }

    public Long addClientWithAddresses(ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmailAddress(), clientDTO.getPhoneNumber());
        List<AddressDTO> dtoAddresses = clientDTO.getAddresses();
        Long clientId = clientDAO.addClient(client);
        List<Address> addresses = createAddressesFromDTOAddresses(dtoAddresses, clientId);
        addressDAO.addAddresses(addresses);
        return clientId;
    }

    public Long addAddressToClient(AddressDTO addressDTO, Long id) {
        Address address = new Address(addressDTO.getCity(), addressDTO.getStreetName(), addressDTO.getBuildingNumber(), addressDTO.getApartmentNumber(), addressDTO.getPostCode(), id);
        return addressDAO.addAddressToClient(address);
    }

    public List<ClientDTO> getClientsWithAddresses() {
        List<Client> clients = clientDAO.getClients();
        return createDTOClientsFromClients(clients);
    }

    private List<ClientDTO> createDTOClientsFromClients(List<Client> clients) {
        List<ClientDTO> dtoClients = new ArrayList<>();
        for (Client client : clients) {
            List<Address> addresses = addressDAO.getAddressByClientId(client.getId());
            List<AddressDTO> dtoAddresses = createDTOAddressesFromAddresses(addresses);
            dtoClients.add(new ClientDTO(client.getFirstName(), client.getLastName(), client.getEmailAddress(), client.getPhoneNumber(), dtoAddresses));
        }
        return dtoClients;
    }

    private List<AddressDTO> createDTOAddressesFromAddresses(List<Address> addresses) {
        List<AddressDTO> dtoAddresses = new ArrayList<>();
        for (Address address : addresses) {
            dtoAddresses.add(new AddressDTO(address.getCity(), address.getStreetName(), address.getBuildingNumber(), address.getApartmentNumber(), address.getPostCode()));
        }
        return dtoAddresses;
    }

    private List<Address> createAddressesFromDTOAddresses(List<AddressDTO> dtoAddresses, Long clientId) {
        List<Address> addresses = new ArrayList<>();
        for (AddressDTO address : dtoAddresses) {
            addresses.add(new Address(address.getCity(), address.getStreetName(), address.getBuildingNumber(), address.getApartmentNumber(), address.getPostCode(), clientId));
        }
        return addresses;
    }
}
