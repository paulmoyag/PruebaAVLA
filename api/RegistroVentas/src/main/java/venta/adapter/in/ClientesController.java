package venta.adapter.in;

import venta.domain.model.Clientes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import venta.repository.ClientesRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/cliente")
public class ClientesController {
    private final ClientesRepository clientesRepository;

    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewClient(@RequestBody Clientes cliente){
        clientesRepository.save(cliente);

        return HttpStatus.OK.toString();
    }

    @GetMapping(path="/list/{id}")
    public @ResponseBody List<Clientes> getClient(@PathVariable long id){
        List<Long> ids = Arrays.asList(id);

        return StreamSupport.stream(
                clientesRepository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(path="/list")
    public @ResponseBody List<Clientes> listClient(){
        return StreamSupport.stream(
                        clientesRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }
}
