package Model;

import javax.persistence.*;

@Entity
@Table(name = "depemployee", schema = "var7kursovaya", catalog = "")
public class DepemployeeEntity {
    private int idDepEmp;
    private String post;
    private EmployeeEntity employeeByIdWorker;
    private DepartmentEntity departmentByIdDepart;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idDepEmp", nullable = false)
    public int getIdDepEmp() {
        return idDepEmp;
    }

    public void setIdDepEmp(int idDepEmp) {
        this.idDepEmp = idDepEmp;
    }

    @Basic
    @Column(name = "post", nullable = true, length = 25)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepemployeeEntity that = (DepemployeeEntity) o;

        if (idDepEmp != that.idDepEmp) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDepEmp;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idWorker", referencedColumnName = "idWorker", nullable = false)
    public EmployeeEntity getEmployeeByIdWorker() {
        return employeeByIdWorker;
    }

    public void setEmployeeByIdWorker(EmployeeEntity employeeByIdWorker) {
        this.employeeByIdWorker = employeeByIdWorker;
    }

    @ManyToOne
    @JoinColumn(name = "idDepart", referencedColumnName = "idDepart", nullable = false)
    public DepartmentEntity getDepartmentByIdDepart() {
        return departmentByIdDepart;
    }

    public void setDepartmentByIdDepart(DepartmentEntity departmentByIdDepart) {
        this.departmentByIdDepart = departmentByIdDepart;
    }
}
