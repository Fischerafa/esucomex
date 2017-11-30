/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.data.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "ORDEN_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o")
    , @NamedQuery(name = "OrdenCompra.findById", query = "SELECT o FROM OrdenCompra o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenCompra.findByFechaEmision", query = "SELECT o FROM OrdenCompra o WHERE o.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "OrdenCompra.findByFechaVigencia", query = "SELECT o FROM OrdenCompra o WHERE o.fechaVigencia = :fechaVigencia")
    , @NamedQuery(name = "OrdenCompra.findByFechaVencimiento", query = "SELECT o FROM OrdenCompra o WHERE o.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "OrdenCompra.findByTotalCantidad", query = "SELECT o FROM OrdenCompra o WHERE o.totalCantidad = :totalCantidad")
    , @NamedQuery(name = "OrdenCompra.findByTotalPrecio", query = "SELECT o FROM OrdenCompra o WHERE o.totalPrecio = :totalPrecio")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Column(name = "TOTAL_CANTIDAD")
    private BigInteger totalCantidad;
    @Column(name = "TOTAL_PRECIO")
    private BigInteger totalPrecio;
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoOrden estadoOrden;
    @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;
    @JoinColumn(name = "TIPO_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoOrden tipoOrden;
    @OneToMany(mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<OrdenCompraDetalle> ordenCompraDetalleList;

    public OrdenCompra() {
    }

    public OrdenCompra(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigInteger getTotalCantidad() {
        return totalCantidad;
    }

    public void setTotalCantidad(BigInteger totalCantidad) {
        this.totalCantidad = totalCantidad;
    }

    public BigInteger getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(BigInteger totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @XmlTransient
    public List<OrdenCompraDetalle> getOrdenCompraDetalleList() {
        return ordenCompraDetalleList;
    }

    public void setOrdenCompraDetalleList(List<OrdenCompraDetalle> ordenCompraDetalleList) {
        this.ordenCompraDetalleList = ordenCompraDetalleList;
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
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.esucomex.soc.data.entities.OrdenCompra[ id=" + id + " ]";
    }
    
}
