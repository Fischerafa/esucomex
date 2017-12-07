/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.controllers;

import cl.esucomex.soc.data.entities.Proveedor;
import cl.esucomex.soc.data.repositories.ProveedorRepository;
import cl.esucomex.soc.mvc.mappers.ProveedorMapper;
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
@RequestMapping("/data/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorRepository proveedorRepo;
    
    @RequestMapping(method=RequestMethod.GET)
    public Map<String, Object> getAll() {
        List<Proveedor> proveedores = proveedorRepo.findAll();
        List<ProveedorMapper> respuesta = new ArrayList<>();
        for (Proveedor proveedor : proveedores)
            respuesta.add(new ProveedorMapper(proveedor));
        return Wrapper.ok(respuesta, (long) respuesta.size());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Map<String, Object> getOne(@PathVariable Long id) {
        Proveedor proveedor =  proveedorRepo.findOne(id);
        List<ProveedorMapper> respuesta = new ArrayList<>();
        if (proveedor != null) {
            respuesta.add(new ProveedorMapper(proveedor));
            return Wrapper.ok(respuesta, 1L);
        }
        else {
            return Wrapper.error("El proveedor " + id + " no existe");
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    @Transactional
    public Map<String, Object> create(@RequestBody ProveedorMapper proveedor){
        List<ProveedorMapper> respuesta = new ArrayList<>();
        respuesta.add(new ProveedorMapper(proveedorRepo.saveAndFlush(proveedor.obtenerProveedor())));
        return Wrapper.ok(respuesta, 1L);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @Transactional
    public Map<String, Object> edit(@PathVariable Long id, @RequestBody ProveedorMapper proveedor) {
        if (proveedorRepo.findOne(id) != null) {
            List<ProveedorMapper> respuesta = new ArrayList<>();
            respuesta.add(new ProveedorMapper(proveedorRepo.saveAndFlush(proveedor.obtenerProveedor())));
            return Wrapper.ok(respuesta, 1L);
        }
        else {
            return Wrapper.error("El proveedor " + id + " no existe");
        }
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @Transactional
    public Map<String, Object> delete(@PathVariable Long id) {
        Proveedor proveedor =  proveedorRepo.findOne(id);
        if (proveedor != null) {
            List<ProveedorMapper> respuesta = new ArrayList<>();
            respuesta.add(new ProveedorMapper(proveedor));
            proveedorRepo.delete(id);
            return Wrapper.ok(respuesta, 1L);
        }
        else {
            return Wrapper.error("El proveedor " + id + " no existe");
        }
    }
}
