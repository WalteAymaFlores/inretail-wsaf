/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.controller;

import intercorpretail.reto.inretail.repository.ClienteRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import intercorpretail.reto.inretail.entities.Cliente;
import intercorpretail.reto.inretail.entities.ClienteDato;
import intercorpretail.reto.inretail.service.IClienteServiceImpl;
import intercorpretail.reto.inretail.service.IClienteService;

/**
 *
 * @author WALTER
 */
@RestController
@RequestMapping("/")
public class ClienteRestController {

    @Autowired
    IClienteService clienteInterface;

    @GetMapping("/clientes")
    public List<Cliente> getClient() {
        return clienteInterface.getClient();
    }

    @GetMapping("/kpideclientes")
    public ClienteDato getAverageAndStandarDeviationClient() {
        ClienteDato clientes = clienteInterface.getDataClient();
        return clientes;
    }

    @PostMapping("/creacliente")
    public ResponseEntity<Cliente> saveClient(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteInterface.saveCliente(cliente));
    }

}
