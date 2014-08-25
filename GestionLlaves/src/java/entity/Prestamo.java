/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonny-PC
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByIdPrestamo", query = "SELECT p FROM Prestamo p WHERE p.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "Prestamo.findByQuienRetira", query = "SELECT p FROM Prestamo p WHERE p.quienRetira = :quienRetira"),
    @NamedQuery(name = "Prestamo.findByHorarioRetirada", query = "SELECT p FROM Prestamo p WHERE p.horarioRetirada = :horarioRetirada"),
    @NamedQuery(name = "Prestamo.findByQuienDevuelve", query = "SELECT p FROM Prestamo p WHERE p.quienDevuelve = :quienDevuelve"),
    @NamedQuery(name = "Prestamo.findByHorarioDevuelto", query = "SELECT p FROM Prestamo p WHERE p.horarioDevuelto = :horarioDevuelto"),
    @NamedQuery(name = "Prestamo.findByFecha", query = "SELECT p FROM Prestamo p WHERE p.fecha = :fecha ORDER BY p.idAulas"),
    @NamedQuery(name = "Prestamo.findByObservaciones", query = "SELECT p FROM Prestamo p WHERE p.observaciones = :observaciones")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrestamo")
    private Integer idPrestamo;
    @Size(max = 45)
    @Column(name = "QuienRetira")
    private String quienRetira;
    @Column(name = "HorarioRetirada")
    @Temporal(TemporalType.TIME)
    private Date horarioRetirada = new Date();
    @Size(max = 45)
    @Column(name = "QuienDevuelve")
    private String quienDevuelve;
    @Column(name = "HorarioDevuelto")
    @Temporal(TemporalType.TIME)
    private Date horarioDevuelto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha = new Date();
    @Size(max = 45)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "idAulas", referencedColumnName = "idAulas")
    @ManyToOne
    private Aulas idAulas;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne
    private Motivo idmotivo;

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getQuienRetira() {
        return quienRetira;
    }

    public void setQuienRetira(String quienRetira) {
        this.quienRetira = quienRetira;
    }

    public Date getHorarioRetirada() {
        return horarioRetirada;
    }

    public void setHorarioRetirada(Date horarioRetirada) {
        this.horarioRetirada = horarioRetirada;
    }

    public String getQuienDevuelve() {
        return quienDevuelve;
    }

    public void setQuienDevuelve(String quienDevuelve) {
        this.quienDevuelve = quienDevuelve;
    }

    public Date getHorarioDevuelto() {
        return horarioDevuelto;
    }

    public void setHorarioDevuelto(Date horarioDevuelto) {
        this.horarioDevuelto = horarioDevuelto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Aulas getIdAulas() {
        return idAulas;
    }

    public void setIdAulas(Aulas idAulas) {
        this.idAulas = idAulas;
    }

    public Motivo getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Motivo idmotivo) {
        this.idmotivo = idmotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prestamo[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
