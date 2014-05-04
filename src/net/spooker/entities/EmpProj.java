package net.spooker.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/7/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(net.spooker.entities.EmpProjPK.class)
@javax.persistence.Table(name = "EMP_PROJ", schema = "HR", catalog = "")
@Entity
public class EmpProj
{
    private Integer empId;

    @javax.persistence.Column(name = "EMP_ID", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public Integer getEmpId()
    {
        return empId;
    }

    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }

    private Integer prjId;

    @javax.persistence.Column(name = "PRJ_ID", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Id
    public Integer getPrjId()
    {
        return prjId;
    }

    public void setPrjId(Integer prjId)
    {
        this.prjId = prjId;
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

        EmpProj empProj = (EmpProj) o;

        if (empId != null ? !empId.equals(empProj.empId) : empProj.empId != null)
        {
            return false;
        }
        if (prjId != null ? !prjId.equals(empProj.prjId) : empProj.prjId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (prjId != null ? prjId.hashCode() : 0);
        return result;
    }


}
