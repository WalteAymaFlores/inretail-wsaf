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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity<?> getClient() {
        List<Cliente> clientes = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clientes = clienteInterface.getClient();
        } catch (DataAccessException e) {
            response.put("success", false);
            response.put("message", "Error al consultar la base de datos");
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("success", true);
        response.put("message", "Se consulto correctamete la base de datos.");
        response.put("data", clientes);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<?> getAverageAndStandarDeviationClient() {
        ClienteDato clienteDato = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clienteDato = clienteInterface.getDataClient();
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al consultar la información");
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("success", true);
        response.put("message", "Se consulto correctamente la información.");
        response.put("data", clienteDato);
        return new ResponseEntity(response, HttpStatus.OK);        
    }

    @PostMapping("/creacliente")
    public ResponseEntity<?> saveClient(@RequestBody Cliente cliente) {
        Cliente clientNew = null;
        Map<String, Object> response = new HashMap<>();
        int ageClient = cliente.getEdad();
        Date birthDate = cliente.getFechaNacimiento();
        int ageClientBirthDate = clienteInterface.getAge(new SimpleDateFormat("dd/MM/yyyy").format(birthDate));
        try {
            if (ageClient > 100 || ageClient < 0) {
                response.put("success", false);
                response.put("message", "La edad del cliente no es correcta");
                response.put("data", null);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            } else if (ageClientBirthDate < 0 || ageClientBirthDate > 100) {
                response.put("success", false);
                response.put("message", "La fecha de nacimiento del cliente no es correcta");
                response.put("data", null);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            clientNew = clienteInterface.saveCliente(cliente);
        } catch (DataAccessException e) {
            response.put("success", false);
            response.put("message", "Error al insertar en la base de datos");
            response.put("data", null);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("success", true);
        response.put("message", "El cliente ha sido creado con exito");
        response.put("data", clientNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
