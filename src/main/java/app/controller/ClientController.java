package app.controller;


import app.dto.AddressDTO;
import app.dto.ClientDTO;
import app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ClientsStorage")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public ClientDTO getClient(@PathVariable Long id) {
        return clientService.getClientWithAddresses(id);
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Long addClient(@RequestBody ClientDTO clientDTO){
        return clientService.addClientWithAddresses(clientDTO);
    }


    @RequestMapping(value = "/client/{id}/address", method = RequestMethod.POST)
    public Long addAddressToClient(@PathVariable Long id, @RequestBody AddressDTO addressDTO){
        return clientService.addAddressToClient(addressDTO, id);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ClientDTO> getClients(){
        return clientService.getClientsWithAddresses();
    }

}