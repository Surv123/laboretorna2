package Model;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "var7kursovaya", catalog = "")
public class CategoryEntity {
    private int idCateg;
    private String nameCateg;
    private Integer dangerLevel;
    private String descript;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idCateg", nullable = false)
    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    @Basic
    @Column(name = "NameCateg", nullable = true, length = 20)
    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }

    @Basic
    @Column(name = "DangerLevel", nullable = true)
    public Integer getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Integer dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Basic
    @Column(name = "Descript", nullable = true, length = -1)
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (idCateg != that.idCateg) return false;
        if (nameCateg != null ? !nameCateg.equals(that.nameCateg) : that.nameCateg != null) return false;
        if (dangerLevel != null ? !dangerLevel.equals(that.dangerLevel) : that.dangerLevel != null) return false;
        if (descript != null ? !descript.equals(that.descript) : that.descript != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCateg;
        result = 31 * result + (nameCateg != null ? nameCateg.hashCode() : 0);
        result = 31 * result + (dangerLevel != null ? dangerLevel.hashCode() : 0);
        result = 31 * result + (descript != null ? descript.hashCode() : 0);
        return result;
    }
}
