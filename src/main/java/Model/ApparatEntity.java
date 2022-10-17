package Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "apparat", schema = "var7kursovaya", catalog = "")
public class ApparatEntity {
    private int idAp;
    private String state;
    private Integer priceAp;
    private Date dateBuy;
    private String pointPower;
    private String location;
    private RoomEntity roomByIdRoom;
    private EquipmenttEntity equipmenttByIdEquip;
    private SupplierEntity supplierByIdSup;
    private EmployeeEntity employeeByIdEmp;

    public String toString(){return idAp+"";}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAp", nullable = false)
    public int getIdAp() {
        return idAp;
    }

    public void setIdAp(int idAp) {
        this.idAp = idAp;
    }

    @Basic
    @Column(name = "State", nullable = true, length = 20)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "PriceAp", nullable = true, precision = 0)
    public Integer getPriceAp() {
        return priceAp;
    }

    public void setPriceAp(Integer priceAp) {
        this.priceAp = priceAp;
    }

    @Basic
    @Column(name = "DateBuy", nullable = true)
    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    @Basic
    @Column(name = "PointPower", nullable = true, length = 25)
    public String getPointPower() {
        return pointPower;
    }

    public void setPointPower(String pointPower) {
        this.pointPower = pointPower;
    }

    @Basic
    @Column(name = "Location", nullable = true, length = 20)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApparatEntity that = (ApparatEntity) o;

        if (idAp != that.idAp) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (priceAp != null ? !priceAp.equals(that.priceAp) : that.priceAp != null) return false;
        if (dateBuy != null ? !dateBuy.equals(that.dateBuy) : that.dateBuy != null) return false;
        if (pointPower != null ? !pointPower.equals(that.pointPower) : that.pointPower != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAp;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (priceAp != null ? priceAp.hashCode() : 0);
        result = 31 * result + (dateBuy != null ? dateBuy.hashCode() : 0);
        result = 31 * result + (pointPower != null ? pointPower.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idRoom", referencedColumnName = "idRoom", nullable = true)
    public RoomEntity getRoomByIdRoom() {
        return roomByIdRoom;
    }

    public void setRoomByIdRoom(RoomEntity roomByIdRoom) {
        this.roomByIdRoom = roomByIdRoom;
    }

    @ManyToOne
    @JoinColumn(name = "idEquip", referencedColumnName = "idEquip", nullable = true)
    public EquipmenttEntity getEquipmenttByIdEquip() {
        return equipmenttByIdEquip;
    }

    public void setEquipmenttByIdEquip(EquipmenttEntity equipmenttByIdEquip) {
        this.equipmenttByIdEquip = equipmenttByIdEquip;
    }

    @ManyToOne
    @JoinColumn(name = "idSup", referencedColumnName = "idSup", nullable = true)
    public SupplierEntity getSupplierByIdSup() {
        return supplierByIdSup;
    }

    public void setSupplierByIdSup(SupplierEntity supplierByIdSup) {
        this.supplierByIdSup = supplierByIdSup;
    }

    @ManyToOne
    @JoinColumn(name = "idEmp", referencedColumnName = "idWorker")
    public EmployeeEntity getEmployeeByIdEmp() {
        return employeeByIdEmp;
    }

    public void setEmployeeByIdEmp(EmployeeEntity employeeByIdEmp) {
        this.employeeByIdEmp = employeeByIdEmp;
    }
}
