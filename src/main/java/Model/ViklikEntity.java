package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "viklik", schema = "ambulancedb", catalog = "")
public class ViklikEntity {
    private int idViklik;
    private Integer idBrigade;
    private Date date;
    private PatientEntity patientByIdPatient;

    @Id
    @Column(name = "idViklik", nullable = false)
    public int getIdViklik() {
        return idViklik;
    }

    public void setIdViklik(int idViklik) {
        this.idViklik = idViklik;
    }

    @Basic
    @Column(name = "idBrigade", nullable = true)
    public Integer getIdBrigade() {
        return idBrigade;
    }

    public void setIdBrigade(Integer idBrigade) {
        this.idBrigade = idBrigade;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViklikEntity that = (ViklikEntity) o;

        if (idViklik != that.idViklik) return false;
        if (idBrigade != null ? !idBrigade.equals(that.idBrigade) : that.idBrigade != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idViklik;
        result = 31 * result + (idBrigade != null ? idBrigade.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idPatient", referencedColumnName = "id")
    public PatientEntity getPatientByIdPatient() {
        return patientByIdPatient;
    }

    public void setPatientByIdPatient(PatientEntity patientByIdPatient) {
        this.patientByIdPatient = patientByIdPatient;
    }
}
