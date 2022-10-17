package Model;

import javax.persistence.*;

@Entity
@Table(name = "supplier", schema = "var7kursovaya", catalog = "")
public class SupplierEntity {
    private int idSup;
    private String nameSup;
    private String addresSup;
    private String telephone;

    public String toString(){return nameSup;}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSup", nullable = false)
    public int getIdSup() {
        return idSup;
    }

    public void setIdSup(int idSup) {
        this.idSup = idSup;
    }

    @Basic
    @Column(name = "NameSup", nullable = true, length = 40)
    public String getNameSup() {
        return nameSup;
    }

    public void setNameSup(String nameSup) {
        this.nameSup = nameSup;
    }

    @Basic
    @Column(name = "AddresSup", nullable = true, length = 45)
    public String getAddresSup() {
        return addresSup;
    }

    public void setAddresSup(String addresSup) {
        this.addresSup = addresSup;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, length = 14)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierEntity that = (SupplierEntity) o;

        if (idSup != that.idSup) return false;
        if (nameSup != null ? !nameSup.equals(that.nameSup) : that.nameSup != null) return false;
        if (addresSup != null ? !addresSup.equals(that.addresSup) : that.addresSup != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSup;
        result = 31 * result + (nameSup != null ? nameSup.hashCode() : 0);
        result = 31 * result + (addresSup != null ? addresSup.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
