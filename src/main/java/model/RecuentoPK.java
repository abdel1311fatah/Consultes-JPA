package model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class RecuentoPK implements Serializable {
    @Column(name = "mesa_colegio_idcolegio")
    @Id

    private int mesaColegioIdcolegio;
    @Column(name = "mesa_letra")
    @Id

    private String mesaLetra;
    @Column(name = "partido_siglas")
    @Id

    private String partidoSiglas;

    public int getMesaColegioIdcolegio() {
        return mesaColegioIdcolegio;
    }

    public void setMesaColegioIdcolegio(int mesaColegioIdcolegio) {
        this.mesaColegioIdcolegio = mesaColegioIdcolegio;
    }

    public String getMesaLetra() {
        return mesaLetra;
    }

    public void setMesaLetra(String mesaLetra) {
        this.mesaLetra = mesaLetra;
    }

    public String getPartidoSiglas() {
        return partidoSiglas;
    }

    public void setPartidoSiglas(String partidoSiglas) {
        this.partidoSiglas = partidoSiglas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecuentoPK that = (RecuentoPK) o;

        if (mesaColegioIdcolegio != that.mesaColegioIdcolegio) return false;
        if (mesaLetra != null ? !mesaLetra.equals(that.mesaLetra) : that.mesaLetra != null) return false;
        if (partidoSiglas != null ? !partidoSiglas.equals(that.partidoSiglas) : that.partidoSiglas != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mesaColegioIdcolegio;
        result = 31 * result + (mesaLetra != null ? mesaLetra.hashCode() : 0);
        result = 31 * result + (partidoSiglas != null ? partidoSiglas.hashCode() : 0);
        return result;
    }
}
