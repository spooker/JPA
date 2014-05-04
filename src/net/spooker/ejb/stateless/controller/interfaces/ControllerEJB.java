package net.spooker.ejb.stateless.controller.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 4/24/13
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ControllerEJB
{
//    public void updateEmployeeFirstName(Integer empId, String firstName,Integer prjId);
//
//    public void removeNicknameFromEmployee(Integer empId, String nickname);
//
//    public void getPhones(Integer empId);

    public void getHobbies(Integer empId);

    public void updateAddressBirthdateEmbeddable(Integer empId);

    public void getEmployeesFirstNameLastNameTuple(String empName);



}
