package venta.adapter.in;

import org.springframework.stereotype.Controller;
import venta.domain.model.Ventas;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import venta.repository.VentasRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/venta")
public class VentasController {
    private final VentasRepository ventasRepository;

    public VentasController(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewVenta(@RequestBody Ventas venta){
        ventasRepository.save(venta);

        return HttpStatus.OK.toString();
    }

    @GetMapping(path="/list/{id}")
    public @ResponseBody
    List<Ventas> getVenta(@PathVariable long id){
        List<Long> ids = Arrays.asList(id);

        return StreamSupport.stream(
                        ventasRepository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(path="/list")
    public @ResponseBody List<Ventas> listVenta(){
        return StreamSupport.stream(
                        ventasRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
