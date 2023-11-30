package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class Componente implements Serializable {
    @Id
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "f_nacimiento")
    private Date fNacimiento;
    @Basic
    @Column(name = "cargo")
    private String cargo;
    @Basic
    @Column(name = "mesa_letra")
    private String mesaLetra;
    @Basic
    @Column(name = "mesa_colegio_idcolegio")
    private int mesaColegioIdcolegio;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "mesa_letra", referencedColumnName = "letra", nullable = false), @JoinColumn(name = "mesa_colegio_idcolegio", referencedColumnName = "colegio_idcolegio", nullable = false)})
    private Mesa mesa;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMesaLetra() {
        return mesaLetra;
    }

    public void setMesaLetra(String mesaLetra) {
        this.mesaLetra = mesaLetra;
    }

    public int getMesaColegioIdcolegio() {
        return mesaColegioIdcolegio;
    }

    public void setMesaColegioIdcolegio(int mesaColegioIdcolegio) {
        this.mesaColegioIdcolegio = mesaColegioIdcolegio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Componente that = (Componente) o;

        if (mesaColegioIdcolegio != that.mesaColegioIdcolegio) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fNacimiento != null ? !fNacimiento.equals(that.fNacimiento) : that.fNacimiento != null) return false;
        if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
        if (mesaLetra != null ? !mesaLetra.equals(that.mesaLetra) : that.mesaLetra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fNacimiento != null ? fNacimiento.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (mesaLetra != null ? mesaLetra.hashCode() : 0);
        result = 31 * result + mesaColegioIdcolegio;
        return result;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", cargo='" + cargo + '\'' +
                ", mesaLetra='" + mesaLetra + '\'' +
                ", mesaColegioIdcolegio=" + mesaColegioIdcolegio +
                ", mesa=" + mesa +
                '}';
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
