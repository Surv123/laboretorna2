package Model;

import javax.persistence.*;

@Entity
@Table(name = "thing", schema = "cleaner", catalog = "")
public class ThingEntity {
    private int idThing;
    private String name;
    private String type;
    private String material;
    private String color;
    private String furniture;
    private String damage;
    private OrderrEntity orderrByIdOrder;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idThing")
    public int getIdThing() {
        return idThing;
    }

    public void setIdThing(int idThing) {
        this.idThing = idThing;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "furniture")
    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    @Basic
    @Column(name = "damage")
    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThingEntity that = (ThingEntity) o;

        if (idThing != that.idThing) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (furniture != null ? !furniture.equals(that.furniture) : that.furniture != null) return false;
        if (damage != null ? !damage.equals(that.damage) : that.damage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idThing;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (furniture != null ? furniture.hashCode() : 0);
        result = 31 * result + (damage != null ? damage.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idOrder", referencedColumnName = "IdOrder", nullable = false)
    public OrderrEntity getOrderrByIdOrder() {
        return orderrByIdOrder;
    }

    public void setOrderrByIdOrder(OrderrEntity orderrByIdOrder) {
        this.orderrByIdOrder = orderrByIdOrder;
    }
}
