package net.spooker.ejb.stateless.controller;

import net.spooker.ejb.stateless.StatelessEjb;
import net.spooker.ejb.stateless.controller.interfaces.ControllerEJBLocal;
import net.spooker.ejb.stateless.controller.interfaces.ControllerEJBRemote;
import net.spooker.entities.Departments;
import net.spooker.entities.EmpHobbies;
import net.spooker.entities.Employees;
import net.spooker.entities.Projects;
import net.spooker.entities.embeddable.EmpInfo;
import org.apache.log4j.Logger;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 4/24/13
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.ejb.Stateless(name = "ControllerEJBBean")
@Remote(ControllerEJBRemote.class)
@Local(ControllerEJBLocal.class)
public class ControllerEJBBean extends StatelessEjb implements ControllerEJBRemote, ControllerEJBLocal
{
    private final static Logger logger = Logger.getLogger(
            ControllerEJBBean.class.getName());

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    public ControllerEJBBean()
    {
    }


//    public void updateEmployeeFirstName(Integer empId, String firstName,Integer prjId)
//    {
//        logger.info("Start of updateEmployeeFirstName with id = "+empId);
//        Employees employee = em.find(Employees.class, empId);
//
//        employee.getNickNames().add("test");
//
//        em.flush();
//    }
//
//    public void removeNicknameFromEmployee(Integer empId, String nickname)
//    {
//
//        Employees employee = em.find(Employees.class, empId);
//
//        employee.getNickNames().remove(nickname);
//
//        em.flush();
//    }
//
//    public void getPhones(Integer empId)
//    {
//
//        Employees employee = em.find(Employees.class, empId);
//
//        Map<Employees.PhoneType, String> phones =  employee.getPhones();
//
//        logger.info(phones.get(Employees.PhoneType.HOME));
//
//        phones.put(Employees.PhoneType.MOBILE,"44444");
//
//
//    }

    public void getHobbies(Integer empId)
    {

        Employees employee = em.find(Employees.class, empId);

        Map<String, EmpHobbies> empHobbies = employee.getEmpHobbies();


        logger.info(empHobbies);


    }

    public void updateAddressBirthdateEmbeddable(Integer empId)
    {
        Employees emp = em.find(Employees.class, empId);

        EmpInfo empInfo = new EmpInfo();
        empInfo.setAddress("hell");
        empInfo.setBirthDate(new Date());
        emp.setEmpInfo(empInfo);

    }


    public void getEmployeesFirstNameLastNameTuple(String empName)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> c = cb.createTupleQuery();
        Root<Employees> emp = c.from(Employees.class);

        ParameterExpression<String> empFirstNameParam = cb.parameter(String.class,"param");
        c.where(cb.equal(emp.get("firstName"), empFirstNameParam));

        c.multiselect(emp.get("firstName"),emp.get("lastName"));
        TypedQuery<Tuple> q = em.createQuery(c);
        q.setParameter("param",empName);


        logger.info("query = " + q.unwrap(org.hibernate.Query.class).getQueryString());
        List<Tuple> employeesList = q.getResultList();

        for(Tuple tuple :employeesList)
        {
            logger.info(tuple.get(0)+" "+tuple.get(1));
        }



//        String query = "Select e from Employees e join e.departmentsByDepartmentId d where e.firstName = 'spooker1'";
//        List<Employees> emps =  em.createQuery(query,Employees.class).getResultList();
//        logger.info(emps);
    }





}
