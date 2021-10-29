package venta.adapter.in;

import org.springframework.stereotype.Controller;
import venta.domain.model.ProductosVendidos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import venta.repository.ProductosVendidosRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/productovendido")
public class ProductosVendidosController {
    private final ProductosVendidosRepository productosVendidosRepository;

    public ProductosVendidosController(ProductosVendidosRepository productosVendidosRepository) {
        this.productosVendidosRepository = productosVendidosRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewProductoVendido(@RequestBody ProductosVendidos productosVendidos){
        productosVendidosRepository.save(productosVendidos);

        return HttpStatus.OK.toString();
    }

    @GetMapping(path="/list/{id}")
    public @ResponseBody
    List<ProductosVendidos> getProductosVendidos(@PathVariable long id){
        List<Long> ids = Arrays.asList(id);

        return StreamSupport.stream(
                        productosVendidosRepository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(path="/list")
    public @ResponseBody List<ProductosVendidos> listProductosVendidos(){
        return StreamSupport.stream(
                        productosVendidosRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
