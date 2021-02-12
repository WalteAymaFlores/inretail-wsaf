/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.service;

import intercorpretail.reto.inretail.entities.ClienteDato;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import intercorpretail.reto.inretail.entities.Cliente;
import java.util.Date;
import java.util.LinkedList;


/**
 *
 * @author WALTER
 */
public class IClienteServiceImplTest {
    
   
    
    @Test
    public void getAge(){
        IClienteServiceImpl clienteService = new IClienteServiceImpl();
        int edad=clienteService.getAge("11/07/1993");
        int resultadoEsperado=27;        
        Assertions.assertEquals(resultadoEsperado,edad);
    }
    
    @Test
    public void getAverage(){
        IClienteServiceImpl clienteService = new IClienteServiceImpl();
        
        List<Date> listFechaNac = new LinkedList<>();
        listFechaNac.add(new Date("11/07/1993"));
        listFechaNac.add(new Date("11/07/2000"));
        listFechaNac.add(new Date("11/07/2015"));
        
        Double promedio=clienteService.getAgeAverageClient(listFechaNac);        
        Double resultadoEsperado=17.33;        
        Assertions.assertEquals(resultadoEsperado,promedio);
    }
    
    @Test
    public void getStandarDeviationClient(){
        IClienteServiceImpl clienteService = new IClienteServiceImpl();
        
        List<Date> listFechaNac = new LinkedList<>();
        listFechaNac.add(new Date("11/07/1993"));
        listFechaNac.add(new Date("11/07/2000"));
        listFechaNac.add(new Date("11/07/2015"));
        
        Double desviacionEstandar=clienteService.getStandarDeviationClient(listFechaNac);        
        Double resultadoEsperado=11.239810941470502;        
        Assertions.assertEquals(resultadoEsperado,desviacionEstandar);
    }    
//    @Test
//    public void getAgeAverageClient(){
//        IClienteServiceImpl clienteService = new IClienteServiceImpl();
//        List<Cliente> clientes = new LinkedList<Cliente>();
//        Cliente cliente1= new Cliente();
//        cliente1.setNombre("Walter");
//        cliente1.setApellido("Ayma Flores");
//        cliente1.setEdad(27);
//        cliente1.setFechaNacimiento(new Date("11/07/1993"));
//        
//        Cliente cliente2= new Cliente();
//        cliente2.setNombre("Tito");
//        cliente2.setApellido("Gomez Gomez");
//        cliente2.setEdad(20);
//        cliente2.setFechaNacimiento(new Date("11/07/2000"));
//        
//        Cliente cliente3= new Cliente();
//        cliente3.setNombre("Pepe");
//        cliente3.setApellido("Perez perez");
//        cliente3.setEdad(5);
//        cliente3.setFechaNacimiento(new Date("11/07/2015"));
//        
//        clientes.add(cliente1);
//        clientes.add(cliente2);
//        clientes.add(cliente3);
//        
//        ClienteDato clienteDato=clienteService.getAgeAverageClient(clientes);
//        Double resultadoEsperado=clienteDato.getPromedioEdad();
//        System.out.println("resultadoEsperado = " + resultadoEsperado);
//        Assertions.assertEquals(resultadoEsperado, 17.33);
//    }
}
