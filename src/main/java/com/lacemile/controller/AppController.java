package com.lacemile.controller;

import com.lacemile.model.Card;
import com.lacemile.model.Employee;
import com.lacemile.service.EmployeeService;
import com.lacemile.service.tags.cardtag.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    CardService cardService;

    @Autowired
    EmployeeService service;

    @Autowired
    MessageSource messageSource;

//    测试用首页
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String index() {

        return "index";
    }


    /*
     * 这种方法将列出所有测试用的"卡片"。
     */
    @RequestMapping(value = { "/card" }, method = RequestMethod.GET)
    public String listCard(ModelMap model) {

        //注入
        List<Card> cards = cardService.findAllCard();
        model.addAttribute("cards", cards);

        return "cardtest";
    }


    /*
     * This method will list all existing employees.
     * 这种方法将列出所有现有的员工。
     */
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "allemployees";
    }

    /*
     * This method will provide the medium to add a new employee.
     * 这种方法将提供媒体添加一个新的员工。
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     * 此方法将被称为表单提交，处理保存在数据库中的员工的岗位要求。它也验证了用户输入
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation
         * and applying it on field [ssn] of Model class [Employee].
         * 首选的方式来实现独特的领域[ SSN ]应实现自定义”独特的诠释和应用领域[ SSN ]模型类[员工]。
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 下面提到的代码的和平[如果块]是证明你可以填写的验证框架以外的自定义错误，同时仍然使用国际化的消息。
         *
         */
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.saveEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }


    /*
     * This method will provide the medium to update an existing employee.
     * 此方法将提供媒体以更新现有的雇员。
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     * 此方法将被称为表单提交，处理后请求更新数据库中的员工。它也验证了用户输入
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
                                 ModelMap model, @PathVariable String ssn) {

        if (result.hasErrors()) {
            return "registration";
        }

        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "success";
    }


    /*
     * This method will delete an employee by it's SSN value.
     * 此方法将删除一个员工的网络价值。
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }

}