package com.lacemile.dao.tags.cardtag;

import com.lacemile.model.Card;
import java.util.List;

/**
 * Created by yuume on 16/12/20.
 */
public interface C010Dao {

    Card findById(int id);
    List<Card> findAllC010();

}

//public interface EmployeeDao {

//    Employee findById(int id);
//
//    void saveEmployee(Employee employee);
//
//    void deleteEmployeeBySsn(String ssn);
//
//    List<Employee> findAllEmployees();
//
//    Employee findEmployeeBySsn(String ssn);
//
//}
