package Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "log", schema = "var7kursovaya", catalog = "")
public class LogEntity {
    private int idLog;
    private Timestamp time;
    private String activity;
    private EmployeeEntity employeeByIdWorker;

    @Id
    @Column(name = "IdLog", nullable = false)
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    @Basic
    @Column(name = "Time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "Activity", nullable = true, length = 50)
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (idLog != logEntity.idLog) return false;
        if (time != null ? !time.equals(logEntity.time) : logEntity.time != null) return false;
        if (activity != null ? !activity.equals(logEntity.activity) : logEntity.activity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLog;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idWorker", referencedColumnName = "idWorker")
    public EmployeeEntity getEmployeeByIdWorker() {
        return employeeByIdWorker;
    }

    public void setEmployeeByIdWorker(EmployeeEntity employeeByIdWorker) {
        this.employeeByIdWorker = employeeByIdWorker;
    }
}
