package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usedmaterial", schema = "cleaner", catalog = "")
public class UsedmaterialEntity {
    private int idUsedMaterial;
    private Double quantity;
    private WorkerEntity workerByIdWorker;
    private OrderrEntity orderrByIdOrder;
    private MaterialEntity materialByIdMaterial;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsedMaterial")
    public int getIdUsedMaterial() {
        return idUsedMaterial;
    }

    public void setIdUsedMaterial(int idUsedMaterial) {
        this.idUsedMaterial = idUsedMaterial;
    }

    @Basic
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsedmaterialEntity that = (UsedmaterialEntity) o;
        return idUsedMaterial == that.idUsedMaterial && quantity.equals(that.quantity) && workerByIdWorker.equals(that.workerByIdWorker) && orderrByIdOrder.equals(that.orderrByIdOrder) && materialByIdMaterial.equals(that.materialByIdMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsedMaterial, quantity, workerByIdWorker, orderrByIdOrder, materialByIdMaterial);
    }

    @ManyToOne
    @JoinColumn(name = "IdWorker", referencedColumnName = "idWorker")
    public WorkerEntity getWorkerByIdWorker() {
        return workerByIdWorker;
    }

    public void setWorkerByIdWorker(WorkerEntity workerByIdWorker) {
        this.workerByIdWorker = workerByIdWorker;
    }

    @ManyToOne
    @JoinColumn(name = "IdOrder", referencedColumnName = "IdOrder")
    public OrderrEntity getOrderrByIdOrder() {
        return orderrByIdOrder;
    }

    public void setOrderrByIdOrder(OrderrEntity orderrByIdOrder) {
        this.orderrByIdOrder = orderrByIdOrder;
    }

    @ManyToOne
    @JoinColumn(name = "IdMaterial", referencedColumnName = "idMaterial")
    public MaterialEntity getMaterialByIdMaterial() {
        return materialByIdMaterial;
    }

    public void setMaterialByIdMaterial(MaterialEntity materialByIdMaterial) {
        this.materialByIdMaterial = materialByIdMaterial;
    }
}
