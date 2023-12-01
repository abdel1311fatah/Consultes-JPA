package model;

import jakarta.persistence.*;

@Entity
@IdClass(RecuentoPK.class)
public class Recuento {

    @Id
    @Column(name = "mesa_colegio_idcolegio")
    private int mesaColegioIdcolegio;

    @Id
    @Column(name = "mesa_letra")
    private String mesaLetra;

    @Id
    @Column(name = "partido_siglas")
    private String partidoSiglas;
    @Basic
    @Column(name = "votos")
    private Integer votos;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "mesa_letra", referencedColumnName = "letra", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "mesa_colegio_idcolegio", referencedColumnName = "colegio_idcolegio", nullable = false, insertable = false, updatable = false)})
    private Mesa mesa;
    @ManyToOne
    @JoinColumn(name = "partido_siglas", referencedColumnName = "siglas", nullable = false, insertable = false, updatable = false)
    private Partido partidoByPartidoSiglas;

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

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recuento recuento = (Recuento) o;

        if (mesaColegioIdcolegio != recuento.mesaColegioIdcolegio) return false;
        if (mesaLetra != null ? !mesaLetra.equals(recuento.mesaLetra) : recuento.mesaLetra != null) return false;
        if (partidoSiglas != null ? !partidoSiglas.equals(recuento.partidoSiglas) : recuento.partidoSiglas != null)
            return false;
        if (votos != null ? !votos.equals(recuento.votos) : recuento.votos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mesaColegioIdcolegio;
        result = 31 * result + (mesaLetra != null ? mesaLetra.hashCode() : 0);
        result = 31 * result + (partidoSiglas != null ? partidoSiglas.hashCode() : 0);
        result = 31 * result + (votos != null ? votos.hashCode() : 0);
        return result;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Partido getPartidoByPartidoSiglas() {
        return partidoByPartidoSiglas;
    }

    public void setPartidoByPartidoSiglas(Partido partidoByPartidoSiglas) {
        this.partidoByPartidoSiglas = partidoByPartidoSiglas;
    }
}
