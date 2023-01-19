package ec.edu.espe.examen2jimenez.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen2jimenez.model.Cliente;
import ec.edu.espe.examen2jimenez.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findByCedula(String cedula) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findByCedula(cedula);
        if (clienteOpt.isPresent()) {
            return clienteOpt.get();
        } else {
            throw new RuntimeException("No se encontro el cliente");
        }
    }
}
