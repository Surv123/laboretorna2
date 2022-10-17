package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "suppliermaterial", schema = "cleaner", catalog = "")
public class SuppliermaterialEntity {
    private int idSupplierMaterial;
    private Date supplydate;
    private Double quantity;
    private Double price;
    private SupplierEntity supplierByIdSupplier;
    private MaterialEntity materialByIdMaterial;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSupplierMaterial")
    public int getIdSupplierMaterial() {
        return idSupplierMaterial;
    }

    public void setIdSupplierMaterial(int idSupplierMaterial) {
        this.idSupplierMaterial = idSupplierMaterial;
    }

    @Basic
    @Column(name = "supplydate")
    public Date getSupplydate() {
        return supplydate;
    }

    public void setSupplydate(Date supplydate) {
        this.supplydate = supplydate;
    }

    @Basic
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuppliermaterialEntity that = (SuppliermaterialEntity) o;

        if (idSupplierMaterial != that.idSupplierMaterial) return false;
        if (supplydate != null ? !supplydate.equals(that.supplydate) : that.supplydate != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSupplierMaterial;
        result = 31 * result + (supplydate != null ? supplydate.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idSupplier", referencedColumnName = "idSupplier", nullable = false)
    public SupplierEntity getSupplierByIdSupplier() {
        return supplierByIdSupplier;
    }

    public void setSupplierByIdSupplier(SupplierEntity supplierByIdSupplier) {
        this.supplierByIdSupplier = supplierByIdSupplier;
    }

    @ManyToOne
    @JoinColumn(name = "idMaterial", referencedColumnName = "idMaterial", nullable = false)
    public MaterialEntity getMaterialByIdMaterial() {
        return materialByIdMaterial;
    }

    public void setMaterialByIdMaterial(MaterialEntity materialByIdMaterial) {
        this.materialByIdMaterial = materialByIdMaterial;
    }
}
