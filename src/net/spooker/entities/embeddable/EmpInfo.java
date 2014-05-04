package net.spooker.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/26/13
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class EmpInfo
{
    private String address;

    private Date birthDate;

    @Column(name = "ADDRESS")
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate()
    {
        return birthDate;
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

        EmpInfo empInfo = (EmpInfo) o;

        if (address != null ? !address.equals(empInfo.address) : empInfo.address != null)
        {
            return false;
        }
        if (birthDate != null ? !birthDate.equals(empInfo.birthDate) : empInfo.birthDate != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }
}
