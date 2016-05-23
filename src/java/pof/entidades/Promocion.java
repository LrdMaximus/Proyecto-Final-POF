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
@Table(name = "PROMOCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p"),
    @NamedQuery(name = "Promocion.findByIdpromocion", query = "SELECT p FROM Promocion p WHERE p.idpromocion = :idpromocion"),
    @NamedQuery(name = "Promocion.findByNombreprom", query = "SELECT p FROM Promocion p WHERE p.nombreprom = :nombreprom"),
    @NamedQuery(name = "Promocion.findByTipoprom", query = "SELECT p FROM Promocion p WHERE p.tipoprom = :tipoprom"),
    @NamedQuery(name = "Promocion.findByDescuento", query = "SELECT p FROM Promocion p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Promocion.findByFechainicio", query = "SELECT p FROM Promocion p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "Promocion.findByFechatermino", query = "SELECT p FROM Promocion p WHERE p.fechatermino = :fechatermino")})
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPROMOCION")
    private String idpromocion;
    @Size(max = 30)
    @Column(name = "NOMBREPROM")
    private String nombreprom;
    @Size(max = 30)
    @Column(name = "TIPOPROM")
    private String tipoprom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "FECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatermino;
    @JoinColumn(name = "NUMPROPIEDAD", referencedColumnName = "NUMPROPIEDAD")
    @ManyToOne
    private Propiedad numpropiedad;

    public Promocion() {
    }

    public Promocion(String idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(String idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getNombreprom() {
        return nombreprom;
    }

    public void setNombreprom(String nombreprom) {
        this.nombreprom = nombreprom;
    }

    public String getTipoprom() {
        return tipoprom;
    }

    public void setTipoprom(String tipoprom) {
        this.tipoprom = tipoprom;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(Date fechatermino) {
        this.fechatermino = fechatermino;
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
        hash += (idpromocion != null ? idpromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idpromocion == null && other.idpromocion != null) || (this.idpromocion != null && !this.idpromocion.equals(other.idpromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Promocion[ idpromocion=" + idpromocion + " ]";
    }
    
}
