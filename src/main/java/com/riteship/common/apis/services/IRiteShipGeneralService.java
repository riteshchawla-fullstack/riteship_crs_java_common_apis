package com.riteship.common.apis.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface IRiteShipGeneralService<T, Integer> {

    public String getOptionList(String tableName,String idColumn,String valueColumn,String Columns,int selID,String conn);

    public String getOptionValue(String tableName, String colValue, String colName, int colId);

    public String saveCollege(HashMap collegeData);

    public HashMap getCollegeDetails(int college_id);

    public String updateCollege(HashMap collegeData);

    public ArrayList getAllCollege(int typeID);

    public String saveCompany(HashMap companyData);

    public HashMap getCompanyDetails(int company_id);

    public String updateCompany(HashMap companyData);

    public ArrayList getAllCompany(int typeID);

    public String getCityOption(java.lang.Integer SelID);

    public String saveEmployee(HashMap employeeData);

    public HashMap getEmployeeDetails(int employee_id);

    public String updateEmployee(HashMap employeeData);

    public boolean deleteEmployee(int employee_id);

    public String getEmployeeOption(java.lang.Integer SelID);

    public String getRoleOption(java.lang.Integer SelID);

    public String getCountryOption(java.lang.Integer SelID);

    public String getSalutionOption(java.lang.Integer SelID);

    public String getStatusOption(java.lang.Integer SelID);

    public String getDepartmentOption(java.lang.Integer SelID);

    public ArrayList getAllEmployee(String managerID);

    public String getDepartment(int dept_id);

    public String getStatus(int status_id);

    public String saveFaq(HashMap faqData);

    public HashMap getFaqDetails(int faq_id);

    public String updateFaq(HashMap faqData);

    public ArrayList getAllFaq();

    public String saveJob(HashMap jobData);

    public String apply(String jobID, String studentID);

    public boolean checkApplication(String jobID, String userID);

    public HashMap getJobDetails(int job_id);

    public String updateJob(HashMap jobData);

    public ArrayList getAllJob(int companyID);

    public ArrayList getAllApplication(int apply_user_id);

    public ArrayList getJobApplication(int company_id);

    public String getJobTypeOption(java.lang.Integer SelID);

    public boolean changePassword(String old_password,String new_password, int login_id);

    public HashMap getLoginDetails(String login_user,String login_password);

    public String saveStudent(HashMap studentData);

    public HashMap getStudentDetails(int student_id);

    public String updateStudent(HashMap studentData);

    public ArrayList getAllStudent();

    public String getStateOption(java.lang.Integer SelID);

    public int checkUsernameExits(String login_user, int type);

    public boolean checkLogin(String login_user,String login_password);

    public String saveCustomer(HashMap var1);

    public HashMap getCustomerDetails(int var1);

    public String updateCustomer(HashMap var1);

    public ArrayList getAllCustomer();

    public HashMap getLoginDetailsCustomer(String var1, String var2);

    public int checkUsernameExitsCustomer(String var1, int var2);

    public boolean checkLoginCustomer(String var1, String var2);

    public HashMap getLoginDetailsStudent(String login_user,String login_password);

    public int checkUsernameExitsStudent(String login_user, int type);

    public boolean checkLoginStudent(String login_user,String login_password);

    public boolean checkLoginLogin(String login_user,String login_password);

    public HashMap getLoginDetailsLogin(String login_user,String login_password);

    public int checkUsernameExitsLogin(String login_user, int type);

    public HashMap getLoginDetailsCompany(String login_user,String login_password);

    public int checkUsernameExitsCompany(String login_user, int type);

    public boolean checkLoginCompany(String login_user,String login_password);

}
