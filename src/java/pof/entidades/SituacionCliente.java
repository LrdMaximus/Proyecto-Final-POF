/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "SITUACION_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionCliente.findAll", query = "SELECT s FROM SituacionCliente s"),
    @NamedQuery(name = "SituacionCliente.findByCodsituacion", query = "SELECT s FROM SituacionCliente s WHERE s.situacionClientePK.codsituacion = :codsituacion"),
    @NamedQuery(name = "SituacionCliente.findByNombre", query = "SELECT s FROM SituacionCliente s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SituacionCliente.findByApellido", query = "SELECT s FROM SituacionCliente s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "SituacionCliente.findByNumpropiedad", query = "SELECT s FROM SituacionCliente s WHERE s.situacionClientePK.numpropiedad = :numpropiedad"),
    @NamedQuery(name = "SituacionCliente.findByEstado", query = "SELECT s FROM SituacionCliente s WHERE s.estado = :estado"),
    @NamedQuery(name = "SituacionCliente.findByDeuda", query = "SELECT s FROM SituacionCliente s WHERE s.deuda = :deuda")})
public class SituacionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SituacionClientePK situacionClientePK;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEUDA")
    private BigInteger deuda;
    @JoinColumn(name = "NUMCLIENTE", referencedColumnName = "NUMCLIENTE")
    @ManyToOne(optional = false)
    private Cliente numcliente;
    @JoinColumn(name = "NUMPROPIEDAD", referencedColumnName = "NUMPROPIEDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Propiedad propiedad;

    public SituacionCliente() {
    }

    public SituacionCliente(SituacionClientePK situacionClientePK) {
        this.situacionClientePK = situacionClientePK;
    }

    public SituacionCliente(SituacionClientePK situacionClientePK, BigInteger deuda) {
        this.situacionClientePK = situacionClientePK;
        this.deuda = deuda;
    }

    public SituacionCliente(String codsituacion, String numpropiedad) {
        this.situacionClientePK = new SituacionClientePK(codsituacion, numpropiedad);
    }

    public SituacionClientePK getSituacionClientePK() {
        return situacionClientePK;
    }

    public void setSituacionClientePK(SituacionClientePK situacionClientePK) {
        this.situacionClientePK = situacionClientePK;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getDeuda() {
        return deuda;
    }

    public void setDeuda(BigInteger deuda) {
        this.deuda = deuda;
    }

    public Cliente getNumcliente() {
        return numcliente;
    }

    public void setNumcliente(Cliente numcliente) {
        this.numcliente = numcliente;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (situacionClientePK != null ? situacionClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionCliente)) {
            return false;
        }
        SituacionCliente other = (SituacionCliente) object;
        if ((this.situacionClientePK == null && other.situacionClientePK != null) || (this.situacionClientePK != null && !this.situacionClientePK.equals(other.situacionClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.SituacionCliente[ situacionClientePK=" + situacionClientePK + " ]";
    }
    
}
