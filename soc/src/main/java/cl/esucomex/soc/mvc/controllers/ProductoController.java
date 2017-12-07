/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.controllers;

import cl.esucomex.soc.data.entities.Producto;
import cl.esucomex.soc.data.repositories.ProductoRepository;
import cl.esucomex.soc.mvc.mappers.ProductoMapper;
import cl.esucomex.soc.mvc.utils.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author richa
 */
@RestController
@RequestMapping("/data/producto")
public class ProductoController {
    @Autowired
    ProductoRepository productoRepo;
    
    @RequestMapping(method=RequestMethod.GET)
    public Map<String, Object> getAll() {
        List<Producto> productos = productoRepo.findAll();
        List<ProductoMapper> respuesta = new ArrayList<>();
        for (Producto producto : productos)
            respuesta.add(new ProductoMapper(producto));
        return Wrapper.ok(respuesta, (long) respuesta.size());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Map<String, Object> getOne(@PathVariable Long id) {
        Producto producto =  productoRepo.findOne(id);
        List<ProductoMapper> respuesta = new ArrayList<>();
        if (producto != null) {
            respuesta.add(new ProductoMapper(producto));
            return Wrapper.ok(respuesta, 1L);
        }
        else {
            return Wrapper.error("El producto " + id + " no existe");
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    @Transactional
    public Map<String, Object> create(@RequestBody ProductoMapper producto){
        List<ProductoMapper> respuesta = new ArrayList<>();
        respuesta.add(new ProductoMapper(productoRepo.saveAndFlush(producto.obtenerProducto())));
        return Wrapper.ok(respuesta, 1L);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @Transactional
    public Map<String, Object> edit(@PathVariable Long id, @RequestBody ProductoMapper producto) {
        List<ProductoMapper> respuesta = new ArrayList<>();
        respuesta.add(new ProductoMapper(productoRepo.saveAndFlush(producto.obtenerProducto())));
        return Wrapper.ok(respuesta, 1L);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @Transactional
    public Map<String, Object> delete(@PathVariable Long id) {
        Producto producto =  productoRepo.findOne(id);
        if (producto != null) {
            List<ProductoMapper> respuesta = new ArrayList<>();
            respuesta.add(new ProductoMapper(producto));
            productoRepo.delete(id);
            return Wrapper.ok(respuesta, 1L);
        }
        else {
            return Wrapper.error("El producto " + id + " no existe");
        }
    }
}
