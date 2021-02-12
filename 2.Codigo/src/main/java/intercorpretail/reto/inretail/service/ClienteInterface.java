/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.service;
import intercorpretail.reto.inretail.entities.Cliente;
import intercorpretail.reto.inretail.entities.ClienteDato;
import java.util.List;

/**
 *
 * @author WALTER
 */
public interface ClienteInterface {
     public List<Cliente> getClient();     
     public Cliente saveCliente(Cliente cliente);
     public ClienteDato getAgeAverageClient(List<Cliente> clientes);
     public int getAge(String birthDay);

}
