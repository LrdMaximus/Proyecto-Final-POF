/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
@Table(name = "PROPIEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
    @NamedQuery(name = "Propiedad.findByNumpropiedad", query = "SELECT p FROM Propiedad p WHERE p.numpropiedad = :numpropiedad"),
    @NamedQuery(name = "Propiedad.findByCalle", query = "SELECT p FROM Propiedad p WHERE p.calle = :calle"),
    @NamedQuery(name = "Propiedad.findByComuna", query = "SELECT p FROM Propiedad p WHERE p.comuna = :comuna"),
    @NamedQuery(name = "Propiedad.findByCiudad", query = "SELECT p FROM Propiedad p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Propiedad.findByCodigopostal", query = "SELECT p FROM Propiedad p WHERE p.codigopostal = :codigopostal"),
    @NamedQuery(name = "Propiedad.findByTipo", query = "SELECT p FROM Propiedad p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Propiedad.findByHab", query = "SELECT p FROM Propiedad p WHERE p.hab = :hab"),
    @NamedQuery(name = "Propiedad.findByRenta", query = "SELECT p FROM Propiedad p WHERE p.renta = :renta"),
    @NamedQuery(name = "Propiedad.findByDisponibilidad", query = "SELECT p FROM Propiedad p WHERE p.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "Propiedad.findByNumarriendo", query = "SELECT p FROM Propiedad p WHERE p.numarriendo = :numarriendo")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMPROPIEDAD")
    private String numpropiedad;
    @Size(max = 30)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 25)
    @Column(name = "COMUNA")
    private String comuna;
    @Size(max = 25)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 10)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Size(max = 25)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "HAB")
    private BigInteger hab;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RENTA")
    private Double renta;
    @Size(max = 4)
    @Column(name = "DISPONIBILIDAD")
    private String disponibilidad;
    @Column(name = "NUMARRIENDO")
    private BigInteger numarriendo;
    @JoinColumn(name = "NUMEMPLEADO", referencedColumnName = "NUMEMPLEADO")
    @ManyToOne
    private Empleado numempleado;
    @JoinColumn(name = "NUMPROPIETARIO", referencedColumnName = "NUMPROPIETARIO")
    @ManyToOne
    private Propietario numpropietario;
    @OneToMany(mappedBy = "numpropiedad")
    private Collection<Publicidad> publicidadCollection;
    @OneToMany(mappedBy = "numpropiedad")
    private Collection<Arriendo> arriendoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedad")
    private Collection<SituacionCliente> situacionClienteCollection;
    @OneToMany(mappedBy = "numpropiedad")
    private Collection<Inspecciones> inspeccionesCollection;
    @OneToMany(mappedBy = "numpropiedad")
    private Collection<Promocion> promocionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedad")
    private Collection<Visita> visitaCollection;

    public Propiedad() {
    }

    public Propiedad(String numpropiedad) {
        this.numpropiedad = numpropiedad;
    }

    public String getNumpropiedad() {
        return numpropiedad;
    }

    public void setNumpropiedad(String numpropiedad) {
        this.numpropiedad = numpropiedad;
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

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigInteger getHab() {
        return hab;
    }

    public void setHab(BigInteger hab) {
        this.hab = hab;
    }

    public Double getRenta() {
        return renta;
    }

    public void setRenta(Double renta) {
        this.renta = renta;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public BigInteger getNumarriendo() {
        return numarriendo;
    }

    public void setNumarriendo(BigInteger numarriendo) {
        this.numarriendo = numarriendo;
    }

    public Empleado getNumempleado() {
        return numempleado;
    }

    public void setNumempleado(Empleado numempleado) {
        this.numempleado = numempleado;
    }

    public Propietario getNumpropietario() {
        return numpropietario;
    }

    public void setNumpropietario(Propietario numpropietario) {
        this.numpropietario = numpropietario;
    }

    @XmlTransient
    public Collection<Publicidad> getPublicidadCollection() {
        return publicidadCollection;
    }

    public void setPublicidadCollection(Collection<Publicidad> publicidadCollection) {
        this.publicidadCollection = publicidadCollection;
    }

    @XmlTransient
    public Collection<Arriendo> getArriendoCollection() {
        return arriendoCollection;
    }

    public void setArriendoCollection(Collection<Arriendo> arriendoCollection) {
        this.arriendoCollection = arriendoCollection;
    }

    @XmlTransient
    public Collection<SituacionCliente> getSituacionClienteCollection() {
        return situacionClienteCollection;
    }

    public void setSituacionClienteCollection(Collection<SituacionCliente> situacionClienteCollection) {
        this.situacionClienteCollection = situacionClienteCollection;
    }

    @XmlTransient
    public Collection<Inspecciones> getInspeccionesCollection() {
        return inspeccionesCollection;
    }

    public void setInspeccionesCollection(Collection<Inspecciones> inspeccionesCollection) {
        this.inspeccionesCollection = inspeccionesCollection;
    }

    @XmlTransient
    public Collection<Promocion> getPromocionCollection() {
        return promocionCollection;
    }

    public void setPromocionCollection(Collection<Promocion> promocionCollection) {
        this.promocionCollection = promocionCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numpropiedad != null ? numpropiedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.numpropiedad == null && other.numpropiedad != null) || (this.numpropiedad != null && !this.numpropiedad.equals(other.numpropiedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Propiedad[ numpropiedad=" + numpropiedad + " ]";
    }
    
}
