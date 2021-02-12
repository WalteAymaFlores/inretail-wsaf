/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercorpretail.reto.inretail.Controller;

import intercorpretail.reto.inretail.entities.Cliente;
import intercorpretail.reto.inretail.service.IClienteService;
import intercorpretail.reto.inretail.service.IClienteServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author WALTER
 */
public class ClienteRestControllerTest {
    
    @Mock
    private IClienteServiceImpl iClienteServiceImpl;
    
    @InjectMocks
    private ClienteRestController clienteRestController;
    
    @BeforeAll
    public void init(){        
        MockitoAnnotations.initMocks(this);
        final Cliente cliente=new Cliente();
        Mockito.when(iClienteServiceImpl.getClient()).thenReturn(Arrays.asList(cliente));
    }
    
    @Test
    public void getClienteTest() throws Exception{        
        final List<Cliente> clientes=clienteRestController.getClient();
        Assertions.assertNotNull(clientes);
        Assertions.assertFalse(clientes.isEmpty());
    }
    
    
}
