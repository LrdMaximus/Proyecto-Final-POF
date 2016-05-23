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
@Table(name = "INSPECCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspecciones.findAll", query = "SELECT i FROM Inspecciones i"),
    @NamedQuery(name = "Inspecciones.findByIdinspeccion", query = "SELECT i FROM Inspecciones i WHERE i.idinspeccion = :idinspeccion"),
    @NamedQuery(name = "Inspecciones.findByNumpropietario", query = "SELECT i FROM Inspecciones i WHERE i.numpropietario = :numpropietario"),
    @NamedQuery(name = "Inspecciones.findByTipoprop", query = "SELECT i FROM Inspecciones i WHERE i.tipoprop = :tipoprop"),
    @NamedQuery(name = "Inspecciones.findByCodigopostal", query = "SELECT i FROM Inspecciones i WHERE i.codigopostal = :codigopostal"),
    @NamedQuery(name = "Inspecciones.findByCalle", query = "SELECT i FROM Inspecciones i WHERE i.calle = :calle"),
    @NamedQuery(name = "Inspecciones.findByComuna", query = "SELECT i FROM Inspecciones i WHERE i.comuna = :comuna"),
    @NamedQuery(name = "Inspecciones.findByCiudad", query = "SELECT i FROM Inspecciones i WHERE i.ciudad = :ciudad"),
    @NamedQuery(name = "Inspecciones.findByFechainspeccion", query = "SELECT i FROM Inspecciones i WHERE i.fechainspeccion = :fechainspeccion")})
public class Inspecciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDINSPECCION")
    private String idinspeccion;
    @Size(max = 20)
    @Column(name = "NUMPROPIETARIO")
    private String numpropietario;
    @Size(max = 30)
    @Column(name = "TIPOPROP")
    private String tipoprop;
    @Size(max = 30)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Size(max = 30)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 30)
    @Column(name = "COMUNA")
    private String comuna;
    @Size(max = 30)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "FECHAINSPECCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainspeccion;
    @JoinColumn(name = "NUMPROPIEDAD", referencedColumnName = "NUMPROPIEDAD")
    @ManyToOne
    private Propiedad numpropiedad;

    public Inspecciones() {
    }

    public Inspecciones(String idinspeccion) {
        this.idinspeccion = idinspeccion;
    }

    public String getIdinspeccion() {
        return idinspeccion;
    }

    public void setIdinspeccion(String idinspeccion) {
        this.idinspeccion = idinspeccion;
    }

    public String getNumpropietario() {
        return numpropietario;
    }

    public void setNumpropietario(String numpropietario) {
        this.numpropietario = numpropietario;
    }

    public String getTipoprop() {
        return tipoprop;
    }

    public void setTipoprop(String tipoprop) {
        this.tipoprop = tipoprop;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechainspeccion() {
        return fechainspeccion;
    }

    public void setFechainspeccion(Date fechainspeccion) {
        this.fechainspeccion = fechainspeccion;
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
        hash += (idinspeccion != null ? idinspeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspecciones)) {
            return false;
        }
        Inspecciones other = (Inspecciones) object;
        if ((this.idinspeccion == null && other.idinspeccion != null) || (this.idinspeccion != null && !this.idinspeccion.equals(other.idinspeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Inspecciones[ idinspeccion=" + idinspeccion + " ]";
    }
    
}
