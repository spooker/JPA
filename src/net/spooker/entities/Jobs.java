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
public class Jobs
{
    private String jobId;

    @javax.persistence.Column(name = "JOB_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public String getJobId()
    {
        return jobId;
    }

    public void setJobId(String jobId)
    {
        this.jobId = jobId;
    }

    private String jobTitle;

    @javax.persistence.Column(name = "JOB_TITLE", nullable = false, insertable = true, updatable = true, length = 35, precision = 0)
    @Basic
    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    private Integer minSalary;

    @javax.persistence.Column(name = "MIN_SALARY", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public Integer getMinSalary()
    {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary)
    {
        this.minSalary = minSalary;
    }

    private Integer maxSalary;

    @javax.persistence.Column(name = "MAX_SALARY", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public Integer getMaxSalary()
    {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary)
    {
        this.maxSalary = maxSalary;
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

        Jobs jobs = (Jobs) o;

        if (jobId != null ? !jobId.equals(jobs.jobId) : jobs.jobId != null)
        {
            return false;
        }
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null)
        {
            return false;
        }
        if (maxSalary != null ? !maxSalary.equals(jobs.maxSalary) : jobs.maxSalary != null)
        {
            return false;
        }
        if (minSalary != null ? !minSalary.equals(jobs.minSalary) : jobs.minSalary != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (minSalary != null ? minSalary.hashCode() : 0);
        result = 31 * result + (maxSalary != null ? maxSalary.hashCode() : 0);
        return result;
    }

    private Collection<Employees> employeesesByJobId;

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<Employees> getEmployeesesByJobId()
    {
        return employeesesByJobId;
    }

    public void setEmployeesesByJobId(Collection<Employees> employeesesByJobId)
    {
        this.employeesesByJobId = employeesesByJobId;
    }


}
