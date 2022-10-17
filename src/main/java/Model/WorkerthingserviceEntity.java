package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "workerthingservice", schema = "cleaner", catalog = "")
public class WorkerthingserviceEntity {
    private int idWorkerThingService;
    private Date executdate;
    private WorkerEntity workerByIdWorker;
    private ThingserviceEntity thingserviceByIdThingService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorkerThingService")
    public int getIdWorkerThingService() {
        return idWorkerThingService;
    }

    public void setIdWorkerThingService(int idWorkerThingService) {
        this.idWorkerThingService = idWorkerThingService;
    }

    @Basic
    @Column(name = "executdate")
    public Date getExecutdate() {
        return executdate;
    }

    public void setExecutdate(Date executdate) {
        this.executdate = executdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerthingserviceEntity that = (WorkerthingserviceEntity) o;

        if (idWorkerThingService != that.idWorkerThingService) return false;
        if (executdate != null ? !executdate.equals(that.executdate) : that.executdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorkerThingService;
        result = 31 * result + (executdate != null ? executdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idWorker", referencedColumnName = "idWorker", nullable = false)
    public WorkerEntity getWorkerByIdWorker() {
        return workerByIdWorker;
    }

    public void setWorkerByIdWorker(WorkerEntity workerByIdWorker) {
        this.workerByIdWorker = workerByIdWorker;
    }

    @ManyToOne
    @JoinColumn(name = "idThingService", referencedColumnName = "idThingService", nullable = false)
    public ThingserviceEntity getThingserviceByIdThingService() {
        return thingserviceByIdThingService;
    }

    public void setThingserviceByIdThingService(ThingserviceEntity thingserviceByIdThingService) {
        this.thingserviceByIdThingService = thingserviceByIdThingService;
    }
}
