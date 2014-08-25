/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonny-PC
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByIdAulas", query = "SELECT a FROM Aulas a WHERE a.idAulas = :idAulas"),
    @NamedQuery(name = "Aulas.findByDescripcion", query = "SELECT a FROM Aulas a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aulas.findByUbicacion", query = "SELECT a FROM Aulas a WHERE a.ubicacion = :ubicacion")})
public class Aulas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAulas")
    private Integer idAulas;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @OneToMany(mappedBy = "idAulas")
    private Collection<Prestamo> prestamoCollection;

    public Aulas() {
    }

    public Aulas(Integer idAulas) {
        this.idAulas = idAulas;
    }

    public Integer getIdAulas() {
        return idAulas;
    }

    public void setIdAulas(Integer idAulas) {
        this.idAulas = idAulas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAulas != null ? idAulas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.idAulas == null && other.idAulas != null) || (this.idAulas != null && !this.idAulas.equals(other.idAulas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aulas[ idAulas=" + idAulas + " ]";
    }
    
}
