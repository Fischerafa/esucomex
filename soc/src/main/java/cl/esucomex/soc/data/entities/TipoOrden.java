/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.data.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author richa
 */
@Entity
@Table(name = "TIPO_ORDEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrden.findAll", query = "SELECT t FROM TipoOrden t")
    , @NamedQuery(name = "TipoOrden.findById", query = "SELECT t FROM TipoOrden t WHERE t.id = :id")
    , @NamedQuery(name = "TipoOrden.findByDescripcion", query = "SELECT t FROM TipoOrden t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoOrden.findByVencimiento", query = "SELECT t FROM TipoOrden t WHERE t.vencimiento = :vencimiento")})
public class TipoOrden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "VENCIMIENTO")
    private Short vencimiento;
    @OneToMany(mappedBy = "tipoOrden", fetch = FetchType.LAZY)
    private List<OrdenCompra> ordenCompraList;

    public TipoOrden() {
    }

    public TipoOrden(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Short vencimiento) {
        this.vencimiento = vencimiento;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
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
        if (!(object instanceof TipoOrden)) {
            return false;
        }
        TipoOrden other = (TipoOrden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.esucomex.soc.data.entities.TipoOrden[ id=" + id + " ]";
    }
    
}
