package com.lacemile.service.tags.cardtag;

import com.lacemile.dao.tags.cardtag.C010Dao;
import com.lacemile.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuume on 16/12/20.
 */
@Service("CardtagService")
@Transactional
public class C010ServiceImpl implements C010Service {

    @Autowired
    private C010Dao dao;

    public Card findById(int id){
        return dao.findById(id);
    }

    public List<Card> findAllC010(){
        return dao.findAllC010();
    }

//    public List<Employee> findAllEmployees() {
//        return dao.findAllEmployees();
//    }

}

//@Service("employeeService")
//@Transactional
//public class EmployeeServiceImpl implements EmployeeService {
//
//    @Autowired
//    private EmployeeDao dao;
//
//    public Employee findById(int id) {
//        return dao.findById(id);
//    }
//
//    public void saveEmployee(Employee employee) {
//        dao.saveEmployee(employee);
//    }
//
//    /*
//     * Since the method is running with Transaction, No need to call hibernate update explicitly.
//     * Just fetch the entity from db and update it with proper values within transaction.
//     * It will be updated in db once transaction ends.
//     */
//    public void updateEmployee(Employee employee) {
//        Employee entity = dao.findById(employee.getId());
//        if(entity!=null){
//            entity.setName(employee.getName());
//            entity.setJoiningDate(employee.getJoiningDate());
//            entity.setSalary(employee.getSalary());
//            entity.setSsn(employee.getSsn());
//        }
//    }
//
//    public void deleteEmployeeBySsn(String ssn) {
//        dao.deleteEmployeeBySsn(ssn);
//    }
//
//    public List<Employee> findAllEmployees() {
//        return dao.findAllEmployees();
//    }
//
//    public Employee findEmployeeBySsn(String ssn) {
//        return dao.findEmployeeBySsn(ssn);
//    }
//
//    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
//        Employee employee = findEmployeeBySsn(ssn);
//        return ( employee == null || ((id != null) && (employee.getId() == id)));
//    }
//
//}