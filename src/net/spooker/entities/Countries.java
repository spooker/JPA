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
public class Countries
{
    private String countryId;

    @javax.persistence.Column(name = "COUNTRY_ID", nullable = false, insertable = true, updatable = true, length = 2, precision = 0)
    @Id
    public String getCountryId()
    {
        return countryId;
    }

    public void setCountryId(String countryId)
    {
        this.countryId = countryId;
    }

    private String countryName;

    @javax.persistence.Column(name = "COUNTRY_NAME", nullable = true, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
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

        Countries countries = (Countries) o;

        if (countryId != null ? !countryId.equals(countries.countryId) : countries.countryId != null)
        {
            return false;
        }
        if (countryName != null ? !countryName.equals(countries.countryName) : countries.countryName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    private Regions regionsByRegionId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    public Regions getRegionsByRegionId()
    {
        return regionsByRegionId;
    }

    public void setRegionsByRegionId(Regions regionsByRegionId)
    {
        this.regionsByRegionId = regionsByRegionId;
    }


}
