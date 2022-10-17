package Model;

import javax.persistence.*;

@Entity
@Table(name = "medicin", schema = "ambulancedb", catalog = "")
public class MedicinEntity {
    private int id;
    private String nazva;
    private int amount;
    private String dosage;
    private String form;
    public String toString(){return nazva;}
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nazva", nullable = false, length = 20)
    public String getNazva() {
        return nazva;
    }

    public void setNazva(String nazva) {
        this.nazva = nazva;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Dosage", nullable = false, length = 20)
    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Basic
    @Column(name = "Form", nullable = true, length = 50)
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicinEntity that = (MedicinEntity) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (nazva != null ? !nazva.equals(that.nazva) : that.nazva != null) return false;
        if (dosage != null ? !dosage.equals(that.dosage) : that.dosage != null) return false;
        if (form != null ? !form.equals(that.form) : that.form != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazva != null ? nazva.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (dosage != null ? dosage.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        return result;
    }
}
