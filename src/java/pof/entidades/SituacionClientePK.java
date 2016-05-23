/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cetecom
 */
@Embeddable
public class SituacionClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODSITUACION")
    private String codsituacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "NUMPROPIEDAD")
    private String numpropiedad;

    public SituacionClientePK() {
    }

    public SituacionClientePK(String codsituacion, String numpropiedad) {
        this.codsituacion = codsituacion;
        this.numpropiedad = numpropiedad;
    }

    public String getCodsituacion() {
        return codsituacion;
    }

    public void setCodsituacion(String codsituacion) {
        this.codsituacion = codsituacion;
    }

    public String getNumpropiedad() {
        return numpropiedad;
    }

    public void setNumpropiedad(String numpropiedad) {
        this.numpropiedad = numpropiedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsituacion != null ? codsituacion.hashCode() : 0);
        hash += (numpropiedad != null ? numpropiedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionClientePK)) {
            return false;
        }
        SituacionClientePK other = (SituacionClientePK) object;
        if ((this.codsituacion == null && other.codsituacion != null) || (this.codsituacion != null && !this.codsituacion.equals(other.codsituacion))) {
            return false;
        }
        if ((this.numpropiedad == null && other.numpropiedad != null) || (this.numpropiedad != null && !this.numpropiedad.equals(other.numpropiedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.SituacionClientePK[ codsituacion=" + codsituacion + ", numpropiedad=" + numpropiedad + " ]";
    }
    
}
