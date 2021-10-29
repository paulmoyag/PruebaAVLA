package venta.adapter.in;

import org.springframework.stereotype.Controller;
import venta.domain.model.Productos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import venta.repository.ProductosRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/producto")
public class ProductoController {
    private final ProductosRepository productosRepository;

    public ProductoController(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewProducto(@RequestBody Productos producto){
        productosRepository.save(producto);

        return HttpStatus.OK.toString();
    }

    @GetMapping(path="/list/{id}")
    public @ResponseBody List<Productos> getProducto(@PathVariable long id){
        List<Long> ids = Arrays.asList(id);

        return StreamSupport.stream(
                productosRepository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(path="/list")
    public @ResponseBody List<Productos> listProducto(){
        return StreamSupport.stream(
                        productosRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
