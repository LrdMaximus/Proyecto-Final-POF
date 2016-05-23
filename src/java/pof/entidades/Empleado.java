/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByNumempleado", query = "SELECT e FROM Empleado e WHERE e.numempleado = :numempleado"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empleado.findBySexo", query = "SELECT e FROM Empleado e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleado.findByFechnac", query = "SELECT e FROM Empleado e WHERE e.fechnac = :fechnac"),
    @NamedQuery(name = "Empleado.findByPrevision", query = "SELECT e FROM Empleado e WHERE e.prevision = :prevision"),
    @NamedQuery(name = "Empleado.findBySalario", query = "SELECT e FROM Empleado e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empleado.findByFechacontratoinic", query = "SELECT e FROM Empleado e WHERE e.fechacontratoinic = :fechacontratoinic"),
    @NamedQuery(name = "Empleado.findByFechacontratoterm", query = "SELECT e FROM Empleado e WHERE e.fechacontratoterm = :fechacontratoterm"),
    @NamedQuery(name = "Empleado.findByBono", query = "SELECT e FROM Empleado e WHERE e.bono = :bono")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMEMPLEADO")
    private String numempleado;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 35)
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "FECHNAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechnac;
    @Size(max = 20)
    @Column(name = "PREVISION")
    private String prevision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private Double salario;
    @Column(name = "FECHACONTRATOINIC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacontratoinic;
    @Column(name = "FECHACONTRATOTERM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacontratoterm;
    @Size(max = 2)
    @Column(name = "BONO")
    private String bono;
    @OneToMany(mappedBy = "numempleado")
    private Collection<Propiedad> propiedadCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Totpropempleado totpropempleado;
    @JoinColumn(name = "NUMOFICINA", referencedColumnName = "NUMOFICINA")
    @ManyToOne
    private Oficina numoficina;

    public Empleado() {
    }

    public Empleado(String numempleado) {
        this.numempleado = numempleado;
    }

    public String getNumempleado() {
        return numempleado;
    }

    public void setNumempleado(String numempleado) {
        this.numempleado = numempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechnac() {
        return fechnac;
    }

    public void setFechnac(Date fechnac) {
        this.fechnac = fechnac;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getFechacontratoinic() {
        return fechacontratoinic;
    }

    public void setFechacontratoinic(Date fechacontratoinic) {
        this.fechacontratoinic = fechacontratoinic;
    }

    public Date getFechacontratoterm() {
        return fechacontratoterm;
    }

    public void setFechacontratoterm(Date fechacontratoterm) {
        this.fechacontratoterm = fechacontratoterm;
    }

    public String getBono() {
        return bono;
    }

    public void setBono(String bono) {
        this.bono = bono;
    }

    @XmlTransient
    public Collection<Propiedad> getPropiedadCollection() {
        return propiedadCollection;
    }

    public void setPropiedadCollection(Collection<Propiedad> propiedadCollection) {
        this.propiedadCollection = propiedadCollection;
    }

    public Totpropempleado getTotpropempleado() {
        return totpropempleado;
    }

    public void setTotpropempleado(Totpropempleado totpropempleado) {
        this.totpropempleado = totpropempleado;
    }

    public Oficina getNumoficina() {
        return numoficina;
    }

    public void setNumoficina(Oficina numoficina) {
        this.numoficina = numoficina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numempleado != null ? numempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.numempleado == null && other.numempleado != null) || (this.numempleado != null && !this.numempleado.equals(other.numempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Empleado[ numempleado=" + numempleado + " ]";
    }
    
}
