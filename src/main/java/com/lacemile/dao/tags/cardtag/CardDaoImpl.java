package com.lacemile.dao.tags.cardtag;

import com.lacemile.dao.AbstractDao;
import com.lacemile.model.Card;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuume on 16/12/20.
 */

@Repository("CardDao")
public class CardDaoImpl extends AbstractDao<Integer, Card> implements CardDao {

    public Card findById(int id){
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Card> findAllCard() {
        Criteria criteria = createEntityCriteria();
        return (List<Card>) criteria.list();
    }

}


//@Repository("employeeDao")
//public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
//
//    public Employee findById(int id) {
//        return getByKey(id);
//    }
//
//    public void saveEmployee(Employee employee) {
//        persist(employee);
//    }
//
//    public void deleteEmployeeBySsn(String ssn) {
//        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
//        query.setString("ssn", ssn);
//        query.executeUpdate();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Employee> findAllEmployees() {
//        Criteria criteria = createEntityCriteria();
//        return (List<Employee>) criteria.list();
//    }
//
//    public Employee findEmployeeBySsn(String ssn) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("ssn", ssn));
//        return (Employee) criteria.uniqueResult();
//    }
//}