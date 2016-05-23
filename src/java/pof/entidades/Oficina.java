/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author cetecom
 */
@Entity
@Table(name = "OFICINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o"),
    @NamedQuery(name = "Oficina.findByNumoficina", query = "SELECT o FROM Oficina o WHERE o.numoficina = :numoficina"),
    @NamedQuery(name = "Oficina.findByCalle", query = "SELECT o FROM Oficina o WHERE o.calle = :calle"),
    @NamedQuery(name = "Oficina.findByCiudad", query = "SELECT o FROM Oficina o WHERE o.ciudad = :ciudad"),
    @NamedQuery(name = "Oficina.findByCodigopostal", query = "SELECT o FROM Oficina o WHERE o.codigopostal = :codigopostal")})
public class Oficina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMOFICINA")
    private String numoficina;
    @Size(max = 30)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 25)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 10)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @OneToMany(mappedBy = "numoficina")
    private Collection<Empleado> empleadoCollection;

    public Oficina() {
    }

    public Oficina(String numoficina) {
        this.numoficina = numoficina;
    }

    public String getNumoficina() {
        return numoficina;
    }

    public void setNumoficina(String numoficina) {
        this.numoficina = numoficina;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numoficina != null ? numoficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.numoficina == null && other.numoficina != null) || (this.numoficina != null && !this.numoficina.equals(other.numoficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Oficina[ numoficina=" + numoficina + " ]";
    }
    
}
