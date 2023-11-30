package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MesaPK implements Serializable {
    @Column(name = "colegio_idcolegio")
    @Id

    private int colegioIdcolegio;
    @Column(name = "letra")
    @Id

    private String letra;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MesaPK mesaPK = (MesaPK) o;

        if (colegioIdcolegio != mesaPK.colegioIdcolegio) return false;
        if (letra != null ? !letra.equals(mesaPK.letra) : mesaPK.letra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colegioIdcolegio;
        result = 31 * result + (letra != null ? letra.hashCode() : 0);
        return result;
    }
}
