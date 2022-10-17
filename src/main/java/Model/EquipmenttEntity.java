package Model;

import javax.persistence.*;

@Entity
@Table(name = "equipmentt", schema = "var7kursovaya", catalog = "")
public class EquipmenttEntity {
    private int idEquip;
    private String nameEquip;
    private Double widthe;
    private Double heighte;
    private Double lengthe;
    private Double electricPower;
    private Double capacity;
    private String extraInf;
    private CategoryEntity categoryByIdCateg;

    public String toString(){return nameEquip;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquip", nullable = false)
    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    @Basic
    @Column(name = "NameEquip", nullable = true, length = 40)
    public String getNameEquip() {
        return nameEquip;
    }

    public void setNameEquip(String nameEquip) {
        this.nameEquip = nameEquip;
    }

    @Basic
    @Column(name = "widthe", nullable = true, precision = 0)
    public Double getWidthe() {
        return widthe;
    }

    public void setWidthe(Double widthe) {
        this.widthe = widthe;
    }

    @Basic
    @Column(name = "heighte", nullable = true, precision = 0)
    public Double getHeighte() {
        return heighte;
    }

    public void setHeighte(Double heighte) {
        this.heighte = heighte;
    }

    @Basic
    @Column(name = "lengthe", nullable = true, precision = 0)
    public Double getLengthe() {
        return lengthe;
    }

    public void setLengthe(Double lengthe) {
        this.lengthe = lengthe;
    }

    @Basic
    @Column(name = "electricPower", nullable = true, precision = 0)
    public Double getElectricPower() {
        return electricPower;
    }

    public void setElectricPower(Double electricPower) {
        this.electricPower = electricPower;
    }

    @Basic
    @Column(name = "capacity", nullable = true, precision = 0)
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "extraInf", nullable = true, length = -1)
    public String getExtraInf() {
        return extraInf;
    }

    public void setExtraInf(String extraInf) {
        this.extraInf = extraInf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmenttEntity that = (EquipmenttEntity) o;

        if (idEquip != that.idEquip) return false;
        if (nameEquip != null ? !nameEquip.equals(that.nameEquip) : that.nameEquip != null) return false;
        if (widthe != null ? !widthe.equals(that.widthe) : that.widthe != null) return false;
        if (heighte != null ? !heighte.equals(that.heighte) : that.heighte != null) return false;
        if (lengthe != null ? !lengthe.equals(that.lengthe) : that.lengthe != null) return false;
        if (electricPower != null ? !electricPower.equals(that.electricPower) : that.electricPower != null)
            return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (extraInf != null ? !extraInf.equals(that.extraInf) : that.extraInf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquip;
        result = 31 * result + (nameEquip != null ? nameEquip.hashCode() : 0);
        result = 31 * result + (widthe != null ? widthe.hashCode() : 0);
        result = 31 * result + (heighte != null ? heighte.hashCode() : 0);
        result = 31 * result + (lengthe != null ? lengthe.hashCode() : 0);
        result = 31 * result + (electricPower != null ? electricPower.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (extraInf != null ? extraInf.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idCateg", referencedColumnName = "idCateg", nullable = false)
    public CategoryEntity getCategoryByIdCateg() {
        return categoryByIdCateg;
    }

    public void setCategoryByIdCateg(CategoryEntity categoryByIdCateg) {
        this.categoryByIdCateg = categoryByIdCateg;
    }
}
