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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cetecom
 */
@Embeddable
public class VisitaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMCLIENTE")
    private String numcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMPROPIEDAD")
    private String numpropiedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public VisitaPK() {
    }

    public VisitaPK(String numcliente, String numpropiedad, Date fecha) {
        this.numcliente = numcliente;
        this.numpropiedad = numpropiedad;
        this.fecha = fecha;
    }

    public String getNumcliente() {
        return numcliente;
    }

    public void setNumcliente(String numcliente) {
        this.numcliente = numcliente;
    }

    public String getNumpropiedad() {
        return numpropiedad;
    }

    public void setNumpropiedad(String numpropiedad) {
        this.numpropiedad = numpropiedad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcliente != null ? numcliente.hashCode() : 0);
        hash += (numpropiedad != null ? numpropiedad.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaPK)) {
            return false;
        }
        VisitaPK other = (VisitaPK) object;
        if ((this.numcliente == null && other.numcliente != null) || (this.numcliente != null && !this.numcliente.equals(other.numcliente))) {
            return false;
        }
        if ((this.numpropiedad == null && other.numpropiedad != null) || (this.numpropiedad != null && !this.numpropiedad.equals(other.numpropiedad))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.VisitaPK[ numcliente=" + numcliente + ", numpropiedad=" + numpropiedad + ", fecha=" + fecha + " ]";
    }
    
}
