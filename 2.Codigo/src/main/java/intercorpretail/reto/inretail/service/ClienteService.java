/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.service;

import intercorpretail.reto.inretail.entities.Cliente;
import intercorpretail.reto.inretail.entities.ClienteDato;
import intercorpretail.reto.inretail.repository.ClienteRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WALTER
 */
@Service
public class ClienteService implements ClienteInterface{

    @Autowired
    ClienteRepository clienteRepository;
    
     public List<Cliente> getClient() {
         return clienteRepository.findAll();
     } 
     
     public Cliente saveCliente(Cliente cliente){
         return clienteRepository.save(cliente);
     }
    
    public ClienteDato getAgeAverageClient(List<Cliente> clientes) {
        ClienteDato datos= new ClienteDato();
        int cant=clientes.size();
        Double suma=0.0;
        Double promedio=0.0;
        
        for (Cliente cliente : clientes) {            
            int edad = getAge(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getFechaNacimiento()));
            System.out.println("edad = " + edad);
            suma = suma + edad;            
        }        
        promedio=suma/cant;               
        datos.setPromedioEdad(Math.round(promedio * 100d) / 100d);        
        return datos;
    }
    public int getAge(String birthDay){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(birthDay, fmt);
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(fechaNac, now);
        int age = periodo.getYears();
        return age;
    }
    
        
    
    

}
