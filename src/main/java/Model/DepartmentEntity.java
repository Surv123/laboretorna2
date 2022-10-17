package Model;

import javax.persistence.*;

@Entity
@Table(name = "department", schema = "var7kursovaya", catalog = "")
public class DepartmentEntity {
    private int idDepart;
    private String nameDep;
    private String address;
    private int chef;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idDepart", nullable = false)
    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    @Basic
    @Column(name = "NameDep", nullable = false, length = 25)
    public String getNameDep() {
        return nameDep;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 40)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Chef", nullable = false)
    public int getChef() {
        return chef;
    }

    public void setChef(int chef) {
        this.chef = chef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (idDepart != that.idDepart) return false;
        if (chef != that.chef) return false;
        if (nameDep != null ? !nameDep.equals(that.nameDep) : that.nameDep != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepart;
        result = 31 * result + (nameDep != null ? nameDep.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + chef;
        return result;
    }
}
