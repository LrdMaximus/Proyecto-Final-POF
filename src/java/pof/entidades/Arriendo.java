/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ARRIENDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a"),
    @NamedQuery(name = "Arriendo.findByNumarriendo", query = "SELECT a FROM Arriendo a WHERE a.numarriendo = :numarriendo"),
    @NamedQuery(name = "Arriendo.findByRenta", query = "SELECT a FROM Arriendo a WHERE a.renta = :renta"),
    @NamedQuery(name = "Arriendo.findByFormapago", query = "SELECT a FROM Arriendo a WHERE a.formapago = :formapago"),
    @NamedQuery(name = "Arriendo.findByTemporada", query = "SELECT a FROM Arriendo a WHERE a.temporada = :temporada"),
    @NamedQuery(name = "Arriendo.findByDeposito", query = "SELECT a FROM Arriendo a WHERE a.deposito = :deposito"),
    @NamedQuery(name = "Arriendo.findByPagado", query = "SELECT a FROM Arriendo a WHERE a.pagado = :pagado"),
    @NamedQuery(name = "Arriendo.findByIniciorenta", query = "SELECT a FROM Arriendo a WHERE a.iniciorenta = :iniciorenta"),
    @NamedQuery(name = "Arriendo.findByFinrenta", query = "SELECT a FROM Arriendo a WHERE a.finrenta = :finrenta")})
public class Arriendo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMARRIENDO")
    private BigDecimal numarriendo;
    @Column(name = "RENTA")
    private Double renta;
    @Size(max = 10)
    @Column(name = "FORMAPAGO")
    private String formapago;
    @Size(max = 4)
    @Column(name = "TEMPORADA")
    private String temporada;
    @Column(name = "DEPOSITO")
    private Double deposito;
    @Column(name = "PAGADO")
    private Character pagado;
    @Column(name = "INICIORENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iniciorenta;
    @Column(name = "FINRENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finrenta;
    @JoinColumn(name = "NUMCLIENTE", referencedColumnName = "NUMCLIENTE")
    @ManyToOne
    private Cliente numcliente;
    @JoinColumn(name = "NUMPROPIEDAD", referencedColumnName = "NUMPROPIEDAD")
    @ManyToOne
    private Propiedad numpropiedad;

    public Arriendo() {
    }

    public Arriendo(BigDecimal numarriendo) {
        this.numarriendo = numarriendo;
    }

    public BigDecimal getNumarriendo() {
        return numarriendo;
    }

    public void setNumarriendo(BigDecimal numarriendo) {
        this.numarriendo = numarriendo;
    }

    public Double getRenta() {
        return renta;
    }

    public void setRenta(Double renta) {
        this.renta = renta;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Double getDeposito() {
        return deposito;
    }

    public void setDeposito(Double deposito) {
        this.deposito = deposito;
    }

    public Character getPagado() {
        return pagado;
    }

    public void setPagado(Character pagado) {
        this.pagado = pagado;
    }

    public Date getIniciorenta() {
        return iniciorenta;
    }

    public void setIniciorenta(Date iniciorenta) {
        this.iniciorenta = iniciorenta;
    }

    public Date getFinrenta() {
        return finrenta;
    }

    public void setFinrenta(Date finrenta) {
        this.finrenta = finrenta;
    }

    public Cliente getNumcliente() {
        return numcliente;
    }

    public void setNumcliente(Cliente numcliente) {
        this.numcliente = numcliente;
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
        hash += (numarriendo != null ? numarriendo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arriendo)) {
            return false;
        }
        Arriendo other = (Arriendo) object;
        if ((this.numarriendo == null && other.numarriendo != null) || (this.numarriendo != null && !this.numarriendo.equals(other.numarriendo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pof.entidades.Arriendo[ numarriendo=" + numarriendo + " ]";
    }
    
}
