package com.lacemile.service.tags.cardtag;

import com.lacemile.model.Card;
import java.util.List;

/**
 * Created by yuume on 16/12/20.
 */

public interface CardService {

    Card findById(int id);

    List<Card> findAllCard();

}

//import com.lacemile.model.Employee;
//
//import java.util.List;
//
//public interface EmployeeService {
//
//    Employee findById(int id);
//
//    void saveEmployee(Employee employee);
//
//    void updateEmployee(Employee employee);
//
//    void deleteEmployeeBySsn(String ssn);
//
//    List<Employee> findAllEmployees();
//
//    Employee findEmployeeBySsn(String ssn);
//
//    boolean isEmployeeSsnUnique(Integer id, String ssn);
//
//}