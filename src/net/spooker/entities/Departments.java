package net.spooker.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/7/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Departments
{
    private Integer departmentId;

    @javax.persistence.Column(name = "DEPARTMENT_ID", nullable = false, insertable = true, updatable = true, length = 4, precision = 0)
    @Id
    public Integer getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId)
    {
        this.departmentId = departmentId;
    }

    private String departmentName;

    @javax.persistence.Column(name = "DEPARTMENT_NAME", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    @Basic
    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Departments that = (Departments) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null)
        {
            return false;
        }
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }

    private Employees employeesByManagerId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    public Employees getEmployeesByManagerId()
    {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employees employeesByManagerId)
    {
        this.employeesByManagerId = employeesByManagerId;
    }


    private Collection<Employees> employeesesByDepartmentId;

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<Employees> getEmployeesesByDepartmentId()
    {
        return employeesesByDepartmentId;
    }

    public void setEmployeesesByDepartmentId(Collection<Employees> employeesesByDepartmentId)
    {
        this.employeesesByDepartmentId = employeesesByDepartmentId;
    }


}
