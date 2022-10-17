package Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "repairs", schema = "var7kursovaya", catalog = "")
public class RepairsEntity {
    private int idRep;
    private Date dateRepair;
    private Integer price;
    private String executor;
    private int reciever;
    private ApparatEntity apparatByIdAp;

    @Id
    @Column(name = "idRep", nullable = false)
    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    @Basic
    @Column(name = "DateRepair", nullable = true)
    public Date getDateRepair() {
        return dateRepair;
    }

    public void setDateRepair(Date dateRepair) {
        this.dateRepair = dateRepair;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Executor", nullable = true, length = -1)
    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    @Basic
    @Column(name = "Reciever", nullable = false)
    public int getReciever() {
        return reciever;
    }

    public void setReciever(int reciever) {
        this.reciever = reciever;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairsEntity that = (RepairsEntity) o;

        if (idRep != that.idRep) return false;
        if (reciever != that.reciever) return false;
        if (dateRepair != null ? !dateRepair.equals(that.dateRepair) : that.dateRepair != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (executor != null ? !executor.equals(that.executor) : that.executor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRep;
        result = 31 * result + (dateRepair != null ? dateRepair.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (executor != null ? executor.hashCode() : 0);
        result = 31 * result + reciever;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idAp", referencedColumnName = "idAp", nullable = false)
    public ApparatEntity getApparatByIdAp() {
        return apparatByIdAp;
    }

    public void setApparatByIdAp(ApparatEntity apparatByIdAp) {
        this.apparatByIdAp = apparatByIdAp;
    }
}
