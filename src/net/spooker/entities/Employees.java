package net.spooker.entities;

import net.spooker.entities.embeddable.EmpInfo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 5/7/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Access(AccessType.PROPERTY)
public class Employees
{
    private Integer id;

    @javax.persistence.Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    @Id
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    private String firstName;

    @javax.persistence.Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private String lastName;

    @javax.persistence.Column(name = "LAST_NAME", nullable = false, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    private String email;

    @javax.persistence.Column(name = "EMAIL", nullable = false, insertable = true, updatable = true, length = 25, precision = 0)
    @Basic
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    private String phoneNumber;

    @javax.persistence.Column(name = "PHONE_NUMBER", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    private Timestamp hireDate;

    @javax.persistence.Column(name = "HIRE_DATE", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public Timestamp getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate)
    {
        this.hireDate = hireDate;
    }

    private BigDecimal salary;

    @javax.persistence.Column(name = "SALARY", nullable = true, insertable = true, updatable = true, length = 8, precision = 2)
    @Basic
    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    private BigDecimal commissionPct;

    @javax.persistence.Column(name = "COMMISSION_PCT", nullable = true, insertable = true, updatable = true, length = 2, precision = 2)
    @Basic
    public BigDecimal getCommissionPct()
    {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct)
    {
        this.commissionPct = commissionPct;
    }

    private EmpInfo empInfo;

    @Embedded
    public EmpInfo getEmpInfo()
    {
        return empInfo;
    }

    public void setEmpInfo(EmpInfo empInfo)
    {
        this.empInfo = empInfo;
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

        Employees employees = (Employees) o;

        if (id != null ? !id.equals(employees.id) : employees.id != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }

    private Collection<Departments> departmentsesById;

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Departments> getDepartmentsesById()
    {
        return departmentsesById;
    }

    public void setDepartmentsesById(Collection<Departments> departmentsesById)
    {
        this.departmentsesById = departmentsesById;
    }

    private Departments departmentsByDepartmentId;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public Departments getDepartmentsByDepartmentId()
    {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId)
    {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    private Employees employeesByManagerId;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    public Employees getEmployeesByManagerId()
    {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employees employeesByManagerId)
    {
        this.employeesByManagerId = employeesByManagerId;
    }

    private Collection<Employees> employeesesById;

    @OneToMany(mappedBy = "employeesByManagerId")
    public Collection<Employees> getEmployeesesById()
    {
        return employeesesById;
    }

    public void setEmployeesesById(Collection<Employees> employeesesById)
    {
        this.employeesesById = employeesesById;
    }

    private Jobs jobsByJobId;

    @ManyToOne
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    public Jobs getJobsByJobId()
    {
        return jobsByJobId;
    }

    public void setJobsByJobId(Jobs jobsByJobId)
    {
        this.jobsByJobId = jobsByJobId;
    }

    private Collection<Projects> projects;

    @ManyToMany
    @JoinTable(name="EMP_PROJ",joinColumns = @JoinColumn(name = "EMP_ID"),inverseJoinColumns = @JoinColumn(name = "PRJ_ID"))
    public Collection<Projects> getProjects()
    {
        return projects;
    }

    public void setProjects(Collection<Projects> projects)
    {
        this.projects = projects;
    }

    private Map<String,EmpHobbies> empHobbies;

    @OneToMany(mappedBy = "employee")
    @MapKey(name = "hobbie")
    public Map<String, EmpHobbies> getEmpHobbies()
    {
        return empHobbies;
    }

    public void setEmpHobbies(Map<String, EmpHobbies> empHobbies)
    {
        this.empHobbies = empHobbies;
    }




//    public enum PhoneType
//    {
//        HOME("HOME"),MOBILE("MOBILE");
//        private String value;
//
//        private PhoneType(String type)
//        {
//            value = type;
//        }
//
//    };
//    private List<String> nickNames;
//
//    @ElementCollection(targetClass=String.class)
//    @CollectionTable(name = "EMP_NICKNAMES",joinColumns = @JoinColumn(name = "EMP_ID"))
//    @Column(name = "NICKNAME")
//    @OrderColumn(name = "ORDER_COLUMN")
//    public List<String> getNickNames()
//    {
//        return nickNames;
//    }
//
//    public void setNickNames(List<String> nickNames)
//    {
//        this.nickNames = nickNames;
//    }
//
//    private Map<PhoneType,String> phones;
//
//    @ElementCollection
//    @CollectionTable(name = "EMP_PHONES" ,joinColumns = @JoinColumn(name = "EMP_ID"))
//    @MapKeyEnumerated(EnumType.STRING)
//    @MapKeyColumn(name = "PHONE_TYPE")
//    @Column(name = "PHONE_NUM")
//    public Map<PhoneType, String> getPhones()
//    {
//        return phones;
//    }
//
//    public void setPhones(Map<PhoneType, String> phones)
//    {
//        this.phones = phones;
//    }

}
