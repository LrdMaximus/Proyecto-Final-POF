/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "PUBLICIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicidad.findAll", query = "SELECT p FROM Publicidad p"),
    @NamedQuery(name = "Publicidad.findByIdpublicidad", query = "SELECT p FROM Publicidad p WHERE p.idpublicidad = :idpublicidad"),
    @NamedQuery(name = "Publicidad.findByNombreempresa", query = "SELECT p FROM Publicidad p WHERE p.nombreempresa = :nombreempresa"),
    @NamedQuery(name = "Publicidad.findByTipo", query = "SELECT p FROM Publicidad p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Publicidad.findByFincontrato", query = "SELECT p FROM Publicidad p WHERE p.fincontrato = :fincontrato"),
    @NamedQuery(name = "Publicidad.findByComision", query = "SELECT p FROM Publicidad p WHERE p.comision = :comision")})
public class Publicidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPUBLICIDAD")
    private String idpublicidad;
    @Size(max = 30)
    @Column(name = "NOMBREEMPRESA")
    private String nombreempresa;
    @Size(max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FINCONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fincontrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISION")
    private Double comision;
    @JoinColumn(name = "NUMPROPIEDAD", referencedColumnName = "NUMPROPIEDAD")
    @ManyToOne
    private Propiedad numpropiedad;

    public Publicidad() {
    }

    public Publicidad(String idpublicidad) {
        this.idpublicidad = idpublicidad;
    }

    public String getIdpublicidad() {
        return idpublicidad;
    }

    public void setIdpublicidad(String idpublicidad) {
        this.idpublicidad = idpublicidad;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFincontrato() {
        return fincontrato;
    }

    public void setFincontrato(Date fincontrato) {
        this.fincontrato = fincontrato;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Propiedad getNumpropiedad() {
        return numpropiedad;
    }

    public void setNumpropiedad(Propiedad numpropiedad) {
        this.numpropiedad = numpropiedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpublicidad != null ? idpublicidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicidad)) {
            return false;
        }
        Publicidad other = (Publicidad) object;
        if ((this.idpublicidad == null && other.idpublicidad != null) || (this.idpublicidad != null && !this.idpublicidad.equals(other.idpublicidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Publicidad[ idpublicidad=" + idpublicidad + " ]";
    }
    
}
