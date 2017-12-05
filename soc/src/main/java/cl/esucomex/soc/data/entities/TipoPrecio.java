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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "TIPO_PRECIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrecio.findAll", query = "SELECT t FROM TipoPrecio t")
    , @NamedQuery(name = "TipoPrecio.findById", query = "SELECT t FROM TipoPrecio t WHERE t.id = :id")
    , @NamedQuery(name = "TipoPrecio.findByDescripcion", query = "SELECT t FROM TipoPrecio t WHERE t.descripcion = :descripcion")})
public class TipoPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TipoPrecioSeq")
    @SequenceGenerator(name="TipoPrecioSeq", sequenceName="TIPO_PRECIO_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipoPrecio", fetch = FetchType.LAZY)
    private List<Precio> precioList;

    public TipoPrecio() {
    }

    public TipoPrecio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
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
        if (!(object instanceof TipoPrecio)) {
            return false;
        }
        TipoPrecio other = (TipoPrecio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.esucomex.soc.data.entities.TipoPrecio[ id=" + id + " ]";
    }
    
}
