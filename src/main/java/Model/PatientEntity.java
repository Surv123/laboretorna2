package Model;

import javax.persistence.*;

@Entity
@Table(name = "patient", schema = "ambulancedb", catalog = "")
public class PatientEntity {
    private int id;
    private String surname;
    private String forename;
    private String patronymic;
    private String allergy;
    private String diseas;

    public String toString(){return surname+" "+forename;};
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Surname", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Forename", nullable = false, length = 20)
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name = "Patronymic", nullable = false, length = 20)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "Allergy", nullable = true, length = 200)
    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Basic
    @Column(name = "Diseas", nullable = true, length = 200)
    public String getDiseas() {
        return diseas;
    }

    public void setDiseas(String diseas) {
        this.diseas = diseas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (id != that.id) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (forename != null ? !forename.equals(that.forename) : that.forename != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (allergy != null ? !allergy.equals(that.allergy) : that.allergy != null) return false;
        if (diseas != null ? !diseas.equals(that.diseas) : that.diseas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (allergy != null ? allergy.hashCode() : 0);
        result = 31 * result + (diseas != null ? diseas.hashCode() : 0);
        return result;
    }
}
