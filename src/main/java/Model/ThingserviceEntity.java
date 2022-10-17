package Model;

import javax.persistence.*;

@Entity
@Table(name = "thingservice", schema = "cleaner", catalog = "")
public class ThingserviceEntity {
    private int idThingService;
    private ThingEntity thingByIdThing;
    private ServiceEntity serviceByIdService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idThingService")
    public int getIdThingService() {
        return idThingService;
    }

    public void setIdThingService(int idThingService) {
        this.idThingService = idThingService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThingserviceEntity that = (ThingserviceEntity) o;

        if (idThingService != that.idThingService) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idThingService;
    }

    @ManyToOne
    @JoinColumn(name = "idThing", referencedColumnName = "idThing", nullable = false)
    public ThingEntity getThingByIdThing() {
        return thingByIdThing;
    }

    public void setThingByIdThing(ThingEntity thingByIdThing) {
        this.thingByIdThing = thingByIdThing;
    }

    @ManyToOne
    @JoinColumn(name = "idService", referencedColumnName = "idService", nullable = false)
    public ServiceEntity getServiceByIdService() {
        return serviceByIdService;
    }

    public void setServiceByIdService(ServiceEntity serviceByIdService) {
        this.serviceByIdService = serviceByIdService;
    }
}
