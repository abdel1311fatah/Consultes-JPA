package model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Colegio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcolegio")
    private int idcolegio;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "color")
    private String color;
    @OneToMany(mappedBy = "colegioByColegioIdcolegio")
    private Collection<Mesa> mesasByIdcolegio;

    public int getIdcolegio() {
        return idcolegio;
    }

    public void setIdcolegio(int idcolegio) {
        this.idcolegio = idcolegio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Colegio colegio = (Colegio) o;

        if (idcolegio != colegio.idcolegio) return false;
        if (direccion != null ? !direccion.equals(colegio.direccion) : colegio.direccion != null) return false;
        if (color != null ? !color.equals(colegio.color) : colegio.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcolegio;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    public Collection<Mesa> getMesasByIdcolegio() {
        return mesasByIdcolegio;
    }

    public void setMesasByIdcolegio(Collection<Mesa> mesasByIdcolegio) {
        this.mesasByIdcolegio = mesasByIdcolegio;
    }
}
