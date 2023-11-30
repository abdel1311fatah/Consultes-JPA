package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@IdClass(MesaPK.class)
public class Mesa implements Serializable {
    @Id
    @Column(name = "colegio_idcolegio")
    private int colegioIdcolegio;

    @Id
    @Column(name = "letra")
    private String letra;
    @Basic
    @Column(name = "blancos")
    private Integer blancos;
    @Basic
    @Column(name = "nulos")
    private Integer nulos;
    @OneToMany(mappedBy = "mesa")
    private Collection<Componente> componentes;
    @ManyToOne
    @JoinColumn(name = "colegio_idcolegio", referencedColumnName = "idcolegio", nullable = false)
    private Colegio colegioByColegioIdcolegio;
    @OneToMany(mappedBy = "mesa")
    private Collection<Recuento> recuentos;

    public int getColegioIdcolegio() {
        return colegioIdcolegio;
    }

    public void setColegioIdcolegio(int colegioIdcolegio) {
        this.colegioIdcolegio = colegioIdcolegio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getBlancos() {
        return blancos;
    }

    public void setBlancos(Integer blancos) {
        this.blancos = blancos;
    }

    public Integer getNulos() {
        return nulos;
    }

    public void setNulos(Integer nulos) {
        this.nulos = nulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesa mesa = (Mesa) o;

        if (colegioIdcolegio != mesa.colegioIdcolegio) return false;
        if (letra != null ? !letra.equals(mesa.letra) : mesa.letra != null) return false;
        if (blancos != null ? !blancos.equals(mesa.blancos) : mesa.blancos != null) return false;
        if (nulos != null ? !nulos.equals(mesa.nulos) : mesa.nulos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colegioIdcolegio;
        result = 31 * result + (letra != null ? letra.hashCode() : 0);
        result = 31 * result + (blancos != null ? blancos.hashCode() : 0);
        result = 31 * result + (nulos != null ? nulos.hashCode() : 0);
        return result;
    }

    public Collection<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(Collection<Componente> componentes) {
        this.componentes = componentes;
    }

    public Colegio getColegioByColegioIdcolegio() {
        return colegioByColegioIdcolegio;
    }

    public void setColegioByColegioIdcolegio(Colegio colegioByColegioIdcolegio) {
        this.colegioByColegioIdcolegio = colegioByColegioIdcolegio;
    }

    public Collection<Recuento> getRecuentos() {
        return recuentos;
    }

    public void setRecuentos(Collection<Recuento> recuentos) {
        this.recuentos = recuentos;
    }
}
