/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.mappers;

import cl.esucomex.soc.data.entities.Proveedor;

/**
 *
 * @author richa
 */
public class ProveedorMapper {
    private Long id;
    private String razonSocial;

    public ProveedorMapper() {
    }

    public ProveedorMapper(Long id, String razonSocial) {
        this.id = id;
        this.razonSocial = razonSocial;
    }

    public ProveedorMapper(Proveedor proveedor) {
        this.id = proveedor.getId();
        this.razonSocial = proveedor.getRazonSocial();
    }
    
    public Proveedor getProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setRazonSocial(razonSocial);
        return proveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
