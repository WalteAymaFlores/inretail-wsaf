/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.service;
import intercorpretail.reto.inretail.entities.Cliente;
import intercorpretail.reto.inretail.entities.ClienteDato;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WALTER
 */
public interface IClienteService {
     public List<Cliente> getClient();     
     public Cliente saveCliente(Cliente cliente);
     public ClienteDato getDataClient();
     public Double getAgeAverageClient(List<Date> edades);
     public Double getStandarDeviationClient(List<Date> edades);
     public int getAge(String birthDay);

}
