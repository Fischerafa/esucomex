/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.controllers;

import cl.esucomex.soc.data.entities.Proveedor;
import cl.esucomex.soc.data.repositories.ProveedorRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author richa
 */
@Controller
public class HomeController {
    @Autowired
    ProveedorRepository proveedorRepo;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        Proveedor proveedor = proveedorRepo.findOne(BigDecimal.ONE);
        return proveedor.getRazonSocial();
    }
}
