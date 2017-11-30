/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.data.repositories;

import cl.esucomex.soc.data.entities.Proveedor;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author richa
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, BigDecimal> {
    
}
