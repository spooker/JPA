package net.spooker.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/22/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "EMP_HOBBIES", schema = "HR", catalog = "")
@Entity
public class EmpHobbies
{
    private Integer id;

    @javax.persistence.Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Id
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    private String hobbie;

    @javax.persistence.Column(name = "HOBBIE", nullable = false, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getHobbie()
    {
        return hobbie;
    }

    public void setHobbie(String hobbie)
    {
        this.hobbie = hobbie;
    }

    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    public Employees getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employees employee)
    {
        this.employee = employee;
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

        EmpHobbies that = (EmpHobbies) o;

        if (!employee.equals(that.employee))
        {
            return false;
        }
        if (!hobbie.equals(that.hobbie))
        {
            return false;
        }
        if (!id.equals(that.id))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id.hashCode();
        result = 31 * result + hobbie.hashCode();
        result = 31 * result + employee.hashCode();
        return result;
    }
}
