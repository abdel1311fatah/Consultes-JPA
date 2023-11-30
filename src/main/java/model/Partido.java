package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Partido implements Serializable {

    @Id
    @Column(name = "siglas")
    private String siglas;
    @Basic
    @Column(name = "lider")
    private String lider;
    @OneToMany(mappedBy = "partidoByPartidoSiglas")
    private Collection<Recuento> recuentosBySiglas;

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partido partido = (Partido) o;

        if (siglas != null ? !siglas.equals(partido.siglas) : partido.siglas != null) return false;
        if (lider != null ? !lider.equals(partido.lider) : partido.lider != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = siglas != null ? siglas.hashCode() : 0;
        result = 31 * result + (lider != null ? lider.hashCode() : 0);
        return result;
    }

    public Collection<Recuento> getRecuentosBySiglas() {
        return recuentosBySiglas;
    }

    public void setRecuentosBySiglas(Collection<Recuento> recuentosBySiglas) {
        this.recuentosBySiglas = recuentosBySiglas;
    }
}
