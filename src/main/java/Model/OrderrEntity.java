package Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orderr", schema = "cleaner", catalog = "")
public class OrderrEntity {
    private int idOrder;
    private String f;
    private String i;
    private String o;
    private String tel;
    private String address;
    private Date orderdate;
    private Date execdate;
    private Double price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdOrder")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "f")
    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    @Basic
    @Column(name = "i")
    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    @Basic
    @Column(name = "o")
    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "orderdate")
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "execdate")
    public Date getExecdate() {
        return execdate;
    }

    public void setExecdate(Date execdate) {
        this.execdate = execdate;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        OrderrEntity that = (OrderrEntity) o1;
        return idOrder == that.idOrder && f.equals(that.f) && i.equals(that.i) && o.equals(that.o) && tel.equals(that.tel) && Objects.equals(address, that.address) && orderdate.equals(that.orderdate) && Objects.equals(execdate, that.execdate) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, f, i, o, tel, address, orderdate, execdate, price);
    }
}
