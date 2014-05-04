package net.spooker.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/7/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Regions
{
    private Integer regionId;

    @javax.persistence.Column(name = "REGION_ID", nullable = false, insertable = true, updatable = true, length = 22, precision = 0)
    @Id
    public Integer getRegionId()
    {
        return regionId;
    }

    public void setRegionId(Integer regionId)
    {
        this.regionId = regionId;
    }

    private String regionName;

    @javax.persistence.Column(name = "REGION_NAME", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getRegionName()
    {
        return regionName;
    }

    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
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

        Regions regions = (Regions) o;

        if (regionId != null ? !regionId.equals(regions.regionId) : regions.regionId != null)
        {
            return false;
        }
        if (regionName != null ? !regionName.equals(regions.regionName) : regions.regionName != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = regionId != null ? regionId.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }

    private Collection<Countries> countriesesByRegionId;

    @OneToMany(mappedBy = "regionsByRegionId")
    public Collection<Countries> getCountriesesByRegionId()
    {
        return countriesesByRegionId;
    }

    public void setCountriesesByRegionId(Collection<Countries> countriesesByRegionId)
    {
        this.countriesesByRegionId = countriesesByRegionId;
    }
}
