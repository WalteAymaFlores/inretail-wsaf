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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WALTER
 */
@Service
public class IClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClient() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteDato getDataClient() {
        try {
            ClienteDato clienteDato = new ClienteDato();
            List<Cliente> clientes = clienteRepository.findAll();
            List<Date> fechaNac = new LinkedList<>();
            for (Cliente cliente : clientes) {
                fechaNac.add(cliente.getFechaNacimiento());
            }
            Double promedio = getAgeAverageClient(fechaNac);
            Double desviacionEstandar = getStandarDeviationClient(fechaNac);
            clienteDato.setPromedioEdad(promedio);
            clienteDato.setDesviacionEstandar(desviacionEstandar);
            return clienteDato;
        } catch (Exception e) {
            System.out.println("e = " + e);
            return null;
        }

    }

    @Override
    public Double getStandarDeviationClient(List<Date> fechaNac) {
        try {
            int cantidadClientes = 0;
            Double desviacionEstandar = 0.0;
            Double mediaAritmetica = getAgeAverageClient(fechaNac);
            Double sumatoria = 0.0;
            for (Date obj : fechaNac) {
                cantidadClientes++;
                Double edad = new Double(getAge(new SimpleDateFormat("dd/MM/yyyy").format(obj)));
                Double resta = edad - mediaAritmetica;
                Double numerador = Math.pow(resta, 2);
                sumatoria = sumatoria + numerador;
            }
            desviacionEstandar = Math.sqrt(sumatoria / (cantidadClientes - 1));
            return desviacionEstandar;
        } catch (Exception e) {
            System.out.println("e = " + e);
            return null;
        }

    }

    @Override
    public Double getAgeAverageClient(List<Date> fechaNac) {
        try {
            int cantidadClientes = 0;
            Double suma = 0.0;
            Double promedio = 0.0;

            for (Date obj : fechaNac) {
                cantidadClientes++;
                int edad = getAge(new SimpleDateFormat("dd/MM/yyyy").format(obj));
                System.out.println("edad = " + edad);
                suma = suma + edad;
            }

            promedio = Math.round(suma / cantidadClientes * 100d) / 100d;

            return promedio;
        } catch (Exception e) {
            System.out.println("e = " + e);
            return null;
        }

    }

    @Override
    public int getAge(String birthDay) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(birthDay, fmt);
        LocalDate now = LocalDate.now();
        Period periodo = Period.between(fechaNac, now);
        int age = periodo.getYears();
        return age;
    }

}
