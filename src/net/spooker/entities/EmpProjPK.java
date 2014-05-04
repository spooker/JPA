package net.spooker.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/7/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmpProjPK implements Serializable
{
    private Integer empId;

    @Id
    @Column(name = "EMP_ID", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public Integer getEmpId()
    {
        return empId;
    }

    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }

    private Integer prjId;

    @Id
    @Column(name = "PRJ_ID", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
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

        EmpProjPK empProjPK = (EmpProjPK) o;

        if (empId != null ? !empId.equals(empProjPK.empId) : empProjPK.empId != null)
        {
            return false;
        }
        if (prjId != null ? !prjId.equals(empProjPK.prjId) : empProjPK.prjId != null)
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
