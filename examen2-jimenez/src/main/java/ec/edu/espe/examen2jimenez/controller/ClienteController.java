package ec.edu.espe.examen2jimenez.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2jimenez.model.Cliente;
import ec.edu.espe.examen2jimenez.repository.ClienteRepository;
import ec.edu.espe.examen2jimenez.service.ClienteService;

@RestController
@RequestMapping(value = "api/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{cedula}")
    public ResponseEntity<Cliente> obtenerClientePorCedula(@PathVariable("cedula") String cedula) {
        Cliente cliente = this.clienteService.findByCedula(cedula);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
