package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "worker", schema = "cleaner", catalog = "")
public class WorkerEntity {
    private int idWorker;
    private String f;
    private String i;
    private String o;
    private Date birthdate;
    private Double salary;
    private String additionalinfo;
    private String login;
    private String password;
    private int usertype;
    private Date startdate;
    private Date enddate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorker")
    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
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
    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "additionalinfo")
    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertype")
    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;

        WorkerEntity that = (WorkerEntity) o1;

        if (idWorker != that.idWorker) return false;
        if (usertype != that.usertype) return false;
        if (f != null ? !f.equals(that.f) : that.f != null) return false;
        if (i != null ? !i.equals(that.i) : that.i != null) return false;
        if (o != null ? !o.equals(that.o) : that.o != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (additionalinfo != null ? !additionalinfo.equals(that.additionalinfo) : that.additionalinfo != null)
            return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorker;
        result = 31 * result + (f != null ? f.hashCode() : 0);
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (o != null ? o.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (additionalinfo != null ? additionalinfo.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + usertype;
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return f + " " + i;
    }
}
