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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cetecom
 */
@Entity
@Table(name = "TOTPROPEMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Totpropempleado.findAll", query = "SELECT t FROM Totpropempleado t"),
    @NamedQuery(name = "Totpropempleado.findByNumempleado", query = "SELECT t FROM Totpropempleado t WHERE t.numempleado = :numempleado"),
    @NamedQuery(name = "Totpropempleado.findByTotprop", query = "SELECT t FROM Totpropempleado t WHERE t.totprop = :totprop")})
public class Totpropempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMEMPLEADO")
    private String numempleado;
    @Column(name = "TOTPROP")
    private BigInteger totprop;
    @JoinColumn(name = "NUMEMPLEADO", referencedColumnName = "NUMEMPLEADO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;

    public Totpropempleado() {
    }

    public Totpropempleado(String numempleado) {
        this.numempleado = numempleado;
    }

    public String getNumempleado() {
        return numempleado;
    }

    public void setNumempleado(String numempleado) {
        this.numempleado = numempleado;
    }

    public BigInteger getTotprop() {
        return totprop;
    }

    public void setTotprop(BigInteger totprop) {
        this.totprop = totprop;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        if (!(object instanceof Totpropempleado)) {
            return false;
        }
        Totpropempleado other = (Totpropempleado) object;
        if ((this.numempleado == null && other.numempleado != null) || (this.numempleado != null && !this.numempleado.equals(other.numempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Totpropempleado[ numempleado=" + numempleado + " ]";
    }
    
}
