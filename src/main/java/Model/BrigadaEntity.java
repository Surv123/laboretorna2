package Model;

import javax.persistence.*;

@Entity
@Table(name = "brigada", schema = "ambulancedb", catalog = "")

public class BrigadaEntity {
    private int idBrigada;
    private String nameB;
    public String toString(){return nameB;}

    @Id
    @Column(name = "idBrigada", nullable = false)
    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    @Basic
    @Column(name = "nameB", nullable = true, length = 30)
    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrigadaEntity that = (BrigadaEntity) o;

        if (idBrigada != that.idBrigada) return false;
        if (nameB != null ? !nameB.equals(that.nameB) : that.nameB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBrigada;
        result = 31 * result + (nameB != null ? nameB.hashCode() : 0);
        return result;
    }
}
