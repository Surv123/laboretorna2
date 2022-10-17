package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee", schema = "var7kursovaya", catalog = "")
public class EmployeeEntity {
    private int idWorker;
    private String surnameW;
    private String nameW;
    private String fNameW;
    private Date dateStart;
    private Date dateEnd;
    private Integer totalExp;
    private String login;
    private String password;
    private Integer usertype;

    public String toString(){return surnameW+" "+nameW;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idWorker", nullable = false)
    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    @Basic
    @Column(name = "SurnameW", nullable = false, length = 25)
    public String getSurnameW() {
        return surnameW;
    }

    public void setSurnameW(String surnameW) {
        this.surnameW = surnameW;
    }

    @Basic
    @Column(name = "NameW", nullable = false, length = 25)
    public String getNameW() {
        return nameW;
    }

    public void setNameW(String nameW) {
        this.nameW = nameW;
    }

    @Basic
    @Column(name = "FNameW", nullable = false, length = 25)
    public String getfNameW() {
        return fNameW;
    }

    public void setfNameW(String fNameW) {
        this.fNameW = fNameW;
    }

    @Basic
    @Column(name = "DateStart", nullable = true)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "DateEnd", nullable = true)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "TotalExp", nullable = true)
    public Integer getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(Integer totalExp) {
        this.totalExp = totalExp;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 40)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "usertype", nullable = true)
    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity employee = (EmployeeEntity) o;

        if (idWorker != employee.idWorker) return false;
        if (surnameW != null ? !surnameW.equals(employee.surnameW) : employee.surnameW != null) return false;
        if (nameW != null ? !nameW.equals(employee.nameW) : employee.nameW != null) return false;
        if (fNameW != null ? !fNameW.equals(employee.fNameW) : employee.fNameW != null) return false;
        if (dateStart != null ? !dateStart.equals(employee.dateStart) : employee.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(employee.dateEnd) : employee.dateEnd != null) return false;
        if (totalExp != null ? !totalExp.equals(employee.totalExp) : employee.totalExp != null) return false;
        if (login != null ? !login.equals(employee.login) : employee.login != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;
        if (usertype != null ? !usertype.equals(employee.usertype) : employee.usertype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorker;
        result = 31 * result + (surnameW != null ? surnameW.hashCode() : 0);
        result = 31 * result + (nameW != null ? nameW.hashCode() : 0);
        result = 31 * result + (fNameW != null ? fNameW.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (totalExp != null ? totalExp.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (usertype != null ? usertype.hashCode() : 0);
        return result;
    }
}
