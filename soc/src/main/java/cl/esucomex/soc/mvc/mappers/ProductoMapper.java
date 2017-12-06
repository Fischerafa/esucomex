/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.mappers;

import cl.esucomex.soc.data.entities.Producto;

/**
 *
 * @author richa
 */
public class ProductoMapper {
    private Long id;
    private String codigo;
    private String descripcion;

    public ProductoMapper() {
    }

    public ProductoMapper(Long id, String codigo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public ProductoMapper(Producto producto) {
        this.id = producto.getId();
        this.codigo = producto.getCodigo();
        this.descripcion = producto.getDescripcion();
    }

    public Producto obtenerProducto() {
        Producto producto = new Producto();
        producto.setId(id);
        producto.setCodigo(codigo);
        producto.setDescripcion(descripcion);
        return producto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
