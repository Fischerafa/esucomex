/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.data.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "ORDEN_COMPRA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraDetalle.findAll", query = "SELECT o FROM OrdenCompraDetalle o")
    , @NamedQuery(name = "OrdenCompraDetalle.findById", query = "SELECT o FROM OrdenCompraDetalle o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenCompraDetalle.findByCantidad", query = "SELECT o FROM OrdenCompraDetalle o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenCompraDetalle.findByPrecio", query = "SELECT o FROM OrdenCompraDetalle o WHERE o.precio = :precio")})
public class OrdenCompraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OrdenCompraDetalleSeq")
    @SequenceGenerator(name="OrdenCompraDetalleSeq", sequenceName="ORDEN_COMPRA_DETALLE_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "PRECIO")
    private Float precio;
    @JoinColumn(name = "ORDEN_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public OrdenCompraDetalle() {
    }

    public OrdenCompraDetalle(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraDetalle)) {
            return false;
        }
        OrdenCompraDetalle other = (OrdenCompraDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.esucomex.soc.data.entities.OrdenCompraDetalle[ id=" + id + " ]";
    }
    
}
