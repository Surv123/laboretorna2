package Model;

import javax.persistence.*;

@Entity
@Table(name = "material", schema = "cleaner", catalog = "")
public class MaterialEntity {
    private int idMaterial;
    private String name;
    private Double quantity;
    private CategoryEntity categoryByIdCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaterial")
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        MaterialEntity that = (MaterialEntity) o;

        if (idMaterial != that.idMaterial) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaterial;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "idCategory")
    public CategoryEntity getCategoryByIdCategory() {
        return categoryByIdCategory;
    }

    public void setCategoryByIdCategory(CategoryEntity categoryByIdCategory) {
        this.categoryByIdCategory = categoryByIdCategory;
    }
}
