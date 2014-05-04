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
public class Projects
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

    private String description;

    @javax.persistence.Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 2000, precision = 0)
    @Basic
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

        Projects projects = (Projects) o;

        if (description != null ? !description.equals(projects.description) : projects.description != null)
        {
            return false;
        }
        if (id != null ? !id.equals(projects.id) : projects.id != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}
