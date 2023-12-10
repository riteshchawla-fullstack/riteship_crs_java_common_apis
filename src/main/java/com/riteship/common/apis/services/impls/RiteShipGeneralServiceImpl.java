package com.riteship.common.apis.services.impls;

import com.riteship.common.apis.components.RiteShipDatabaseOperationsBean;
import com.riteship.common.apis.services.IRiteShipGeneralService;

import java.util.ArrayList;
import java.util.HashMap;

public class RiteShipGeneralServiceImpl<T, Integer> implements IRiteShipGeneralService<T, Integer> {

    private RiteShipDatabaseOperationsBean riteShipDatabaseOperationsBean;

    public RiteShipDatabaseOperationsBean getRiteShipDatabaseOperationsBean() {
        return riteShipDatabaseOperationsBean;
    }

    public void setRiteShipDatabaseOperationsBean(RiteShipDatabaseOperationsBean riteShipDatabaseOperationsBean) {
        this.riteShipDatabaseOperationsBean = riteShipDatabaseOperationsBean;
    }

    @Override
    public String getOptionList(String tableName, String idColumn, String valueColumn, String Columns, int selID, String conn) {
        return riteShipDatabaseOperationsBean.getOptionList(tableName, idColumn, valueColumn, Columns, selID, conn);
    }

    @Override
    public String getOptionValue(String tableName, String colValue, String colName, int colId) {
        return riteShipDatabaseOperationsBean.getOptionValue(tableName, colValue, colName, colId);
    }

    @Override
    public String saveCollege(HashMap collegeData) {
        return riteShipDatabaseOperationsBean.saveCollege(collegeData);
    }

    @Override
    public HashMap getCollegeDetails(int college_id) {
        return riteShipDatabaseOperationsBean.getCollegeDetails(college_id);
    }

    @Override
    public String updateCollege(HashMap collegeData) {
        return riteShipDatabaseOperationsBean.updateCollege(collegeData);
    }

    @Override
    public ArrayList getAllCollege(int typeID) {
        return riteShipDatabaseOperationsBean.getAllCollege(typeID);
    }

    @Override
    public String saveCompany(HashMap companyData) {
        return riteShipDatabaseOperationsBean.saveCompany(companyData);
    }

    @Override
    public HashMap getCompanyDetails(int company_id) {
        return riteShipDatabaseOperationsBean.getCompanyDetails(company_id);
    }

    @Override
    public String updateCompany(HashMap companyData) {
        return riteShipDatabaseOperationsBean.updateCompany(companyData);
    }

    @Override
    public ArrayList getAllCompany(int typeID) {
        return riteShipDatabaseOperationsBean.getAllCompany(typeID);
    }

    @Override
    public String getCityOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getCityOption(SelID);
    }

    @Override
    public String saveEmployee(HashMap employeeData) {
        return riteShipDatabaseOperationsBean.saveEmployee(employeeData);
    }

    @Override
    public HashMap getEmployeeDetails(int employee_id) {
        return riteShipDatabaseOperationsBean.getEmployeeDetails(employee_id);
    }

    @Override
    public String updateEmployee(HashMap employeeData) {
        return riteShipDatabaseOperationsBean.updateEmployee(employeeData);
    }

    @Override
    public boolean deleteEmployee(int employee_id) {
        return riteShipDatabaseOperationsBean.deleteEmployee(employee_id);
    }

    @Override
    public String getEmployeeOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getEmployeeOption(SelID);
    }

    @Override
    public String getRoleOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getRoleOption(SelID);
    }

    @Override
    public String getCountryOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getCountryOption(SelID);
    }

    @Override
    public String getSalutionOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getSalutionOption(SelID);
    }

    @Override
    public String getStatusOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getStatusOption(SelID);
    }

    @Override
    public String getDepartmentOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getDepartmentOption(SelID);
    }

    @Override
    public ArrayList getAllEmployee(String managerID) {
        return riteShipDatabaseOperationsBean.getAllEmployee(managerID);
    }

    @Override
    public String getDepartment(int dept_id) {
        return riteShipDatabaseOperationsBean.getDepartment(dept_id);
    }

    @Override
    public String getStatus(int status_id) {
        return riteShipDatabaseOperationsBean.getStatus(status_id);
    }

    @Override
    public String saveFaq(HashMap faqData) {
        return riteShipDatabaseOperationsBean.saveFaq(faqData);
    }

    @Override
    public HashMap getFaqDetails(int faq_id) {
        return riteShipDatabaseOperationsBean.getFaqDetails(faq_id);
    }

    @Override
    public String updateFaq(HashMap faqData) {
        return riteShipDatabaseOperationsBean.updateFaq(faqData);
    }

    @Override
    public ArrayList getAllFaq() {
        return riteShipDatabaseOperationsBean.getAllFaq();
    }

    @Override
    public String saveJob(HashMap jobData) {
        return riteShipDatabaseOperationsBean.saveJob(jobData);
    }

    @Override
    public String apply(String jobID, String studentID) {
        return riteShipDatabaseOperationsBean.apply(jobID, studentID);
    }

    @Override
    public boolean checkApplication(String jobID, String userID) {
        return riteShipDatabaseOperationsBean.checkApplication(jobID, userID);
    }

    @Override
    public HashMap getJobDetails(int job_id) {
        return riteShipDatabaseOperationsBean.getJobDetails(job_id);
    }

    @Override
    public String updateJob(HashMap jobData) {
        return riteShipDatabaseOperationsBean.updateJob(jobData);
    }

    @Override
    public ArrayList getAllJob(int companyID) {
        return riteShipDatabaseOperationsBean.getAllJob(companyID);
    }

    @Override
    public ArrayList getAllApplication(int apply_user_id) {
        return riteShipDatabaseOperationsBean.getAllApplication(apply_user_id);
    }

    @Override
    public ArrayList getJobApplication(int company_id) {
        return riteShipDatabaseOperationsBean.getJobApplication(company_id);
    }

    @Override
    public String getJobTypeOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getJobTypeOption(SelID);
    }

    @Override
    public boolean changePassword(String old_password, String new_password, int login_id) {
        return riteShipDatabaseOperationsBean.changePassword(old_password, new_password, login_id);
    }

    @Override
    public HashMap getLoginDetails(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.getLoginDetails(login_user, login_password);
    }

    @Override
    public String saveStudent(HashMap studentData) {
        return riteShipDatabaseOperationsBean.saveStudent(studentData);
    }

    @Override
    public HashMap getStudentDetails(int student_id) {
        return riteShipDatabaseOperationsBean.getStudentDetails(student_id);
    }

    @Override
    public String updateStudent(HashMap studentData) {
        return riteShipDatabaseOperationsBean.updateStudent(studentData);
    }

    @Override
    public ArrayList getAllStudent() {
        return riteShipDatabaseOperationsBean.getAllStudent();
    }

    @Override
    public String getStateOption(java.lang.Integer SelID) {
        return riteShipDatabaseOperationsBean.getStateOption(SelID);
    }

    @Override
    public int checkUsernameExits(String login_user, int type) {
        return riteShipDatabaseOperationsBean.checkUsernameExits(login_user, type);
    }

    @Override
    public boolean checkLogin(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.checkLogin(login_user, login_password);
    }

    @Override
    public String saveCustomer(HashMap var1) {
        return riteShipDatabaseOperationsBean.saveCustomer(var1);
    }

    @Override
    public HashMap getCustomerDetails(int var1) {
        return riteShipDatabaseOperationsBean.getCustomerDetails(var1);
    }

    @Override
    public String updateCustomer(HashMap var1) {
        return riteShipDatabaseOperationsBean.updateCustomer(var1);
    }

    @Override
    public ArrayList getAllCustomer() {
        return riteShipDatabaseOperationsBean.getAllCustomer();
    }

    @Override
    public HashMap getLoginDetailsCustomer(String var1, String var2) {
        return riteShipDatabaseOperationsBean.getLoginDetailsCustomer(var1, var2);
    }

    @Override
    public int checkUsernameExitsCustomer(String var1, int var2) {
        return riteShipDatabaseOperationsBean.checkUsernameExitsCustomer(var1, var2);
    }

    @Override
    public boolean checkLoginCustomer(String var1, String var2) {
        return riteShipDatabaseOperationsBean.checkLoginCustomer(var1, var2);
    }

    @Override
    public HashMap getLoginDetailsStudent(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.getLoginDetailsStudent(login_user, login_password);
    }

    @Override
    public int checkUsernameExitsStudent(String login_user, int type) {
        return riteShipDatabaseOperationsBean.checkUsernameExitsStudent(login_user, type);
    }

    @Override
    public boolean checkLoginStudent(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.checkLoginStudent(login_user, login_password);
    }

    @Override
    public boolean checkLoginLogin(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.checkLoginLogin(login_user, login_password);
    }

    @Override
    public HashMap getLoginDetailsLogin(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.getLoginDetailsLogin(login_user, login_password);
    }

    @Override
    public int checkUsernameExitsLogin(String login_user, int type) {
        return riteShipDatabaseOperationsBean.checkUsernameExitsLogin(login_user, type);
    }

    @Override
    public HashMap getLoginDetailsCompany(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.getLoginDetailsCompany(login_user, login_password);
    }

    @Override
    public int checkUsernameExitsCompany(String login_user, int type) {
        return riteShipDatabaseOperationsBean.checkUsernameExitsCompany(login_user, type);
    }

    @Override
    public boolean checkLoginCompany(String login_user, String login_password) {
        return riteShipDatabaseOperationsBean.checkLoginCompany(login_user, login_password);
    }
}
