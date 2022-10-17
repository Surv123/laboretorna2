package Model;

import javax.persistence.*;

@Entity
@Table(name = "room", schema = "var7kursovaya", catalog = "")
public class RoomEntity {
    private int idRoom;
    private Double widthr;
    private Double heightr;
    private Double lengthr;
    private DepartmentEntity departmentByIdDepart;

    public String toString(){return idRoom+"";}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRoom", nullable = false)
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "widthr", nullable = true, precision = 0)
    public Double getWidthr() {
        return widthr;
    }

    public void setWidthr(Double widthr) {
        this.widthr = widthr;
    }

    @Basic
    @Column(name = "heightr", nullable = true, precision = 0)
    public Double getHeightr() {
        return heightr;
    }

    public void setHeightr(Double heightr) {
        this.heightr = heightr;
    }

    @Basic
    @Column(name = "lengthr", nullable = true, precision = 0)
    public Double getLengthr() {
        return lengthr;
    }

    public void setLengthr(Double lengthr) {
        this.lengthr = lengthr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (idRoom != that.idRoom) return false;
        if (widthr != null ? !widthr.equals(that.widthr) : that.widthr != null) return false;
        if (heightr != null ? !heightr.equals(that.heightr) : that.heightr != null) return false;
        if (lengthr != null ? !lengthr.equals(that.lengthr) : that.lengthr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (widthr != null ? widthr.hashCode() : 0);
        result = 31 * result + (heightr != null ? heightr.hashCode() : 0);
        result = 31 * result + (lengthr != null ? lengthr.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idDepart", referencedColumnName = "idDepart", nullable = false)
    public DepartmentEntity getDepartmentByIdDepart() {
        return departmentByIdDepart;
    }

    public void setDepartmentByIdDepart(DepartmentEntity departmentByIdDepart) {
        this.departmentByIdDepart = departmentByIdDepart;
    }
}
