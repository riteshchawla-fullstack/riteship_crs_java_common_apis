package com.riteship.common.apis.components;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RiteShipDatabaseOperationsBean
{
    public static Statement statement = null;
    public static Connection connection;
	public static ResultSet rs;
	public static PreparedStatement pstmt;
    /////Function for connect to the MySQL Server Database////////////

/*	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/RiteShip_CRS_Application_DB?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false",
		"root", "RiteShip1421#$");
	statement=connection.createStatement();*/

	private static RiteShipDatabaseOperationsBean databaseOperationsBeanInstance = new RiteShipDatabaseOperationsBean();

	private RiteShipDatabaseOperationsBean() {

	}

	public static RiteShipDatabaseOperationsBean getInstance(String driverClassName, String databaseUrl,
															 String databaseUserName, String databasePassword) {
		if(connection == null && driverClassName != null && databaseUrl != null &&
		                databaseUserName != null && databasePassword != null) {
			connect_mysql(driverClassName, databaseUrl, databaseUserName, databasePassword);
		}
		if(databaseOperationsBeanInstance == null) {
			databaseOperationsBeanInstance = new RiteShipDatabaseOperationsBean();
		}
		return databaseOperationsBeanInstance;
	}

	public static void connect_mysql(String driverClassName, String databaseUrl,
									  String databaseUserName, String databasePassword)
    {
    	try  
    	{
			Class.forName(driverClassName).newInstance();
    		connection = DriverManager.getConnection(databaseUrl,
					databaseUserName, databasePassword);
			statement=connection.createStatement();
   		}
   		catch(Exception e)  
    	{
			System.out.println(" Error : "+ e.toString());
    	}
    }
	////////Function for geting the Option/////////////////////
	public String getOptionList(String tableName,String idColumn,String valueColumn,String Columns,int selID,String conn)
	{
		String SQL = "SELECT "+Columns+" FROM "+tableName+" where "+conn; 
		String Option="<option value=''>Please Select</option>";
		try
		{
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				int selectedID = rs.getInt(idColumn);
				if(selectedID==selID)
					Option+="<option value=\""+selectedID+"\" Selected>"+rs.getString(valueColumn)+"</option>";
				else
					Option+="<option value=\""+selectedID+"\">"+rs.getString(valueColumn)+"</option>";
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
		return Option;
	}
	//////////////////Function for getting Option Details//////////	
    public String getOptionValue(String tableName, String colValue, String colName, int colId)
	{
        HashMap results = new HashMap();
        String SQL = "";
        String value = "";
        int count=0;
		try
		{
            SQL =  "SELECT "+colValue+" FROM "+tableName+" WHERE "+colName+" = "+colId ;
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while(rs.next())
			{
				value = rs.getString(colValue);
            }
         }
		 catch(Exception e)
		 {
            System.out.println("Error is: "+ e);
       	 }
        return value;
    }

	public String saveCollege(HashMap collegeData)
	{
		String SQL = "INSERT INTO `college` (`college_name`, `college_city`, `college_state`, `college_country`, `college_address`, `college_email`, `college_mobile`, `college_description`, `college_website`, `college_image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) collegeData.get("college_name"));
			pstmt.setString(2,(String) collegeData.get("college_city"));
			pstmt.setString(3,(String) collegeData.get("college_state"));
			pstmt.setString(4,(String) collegeData.get("college_country"));
			pstmt.setString(5,(String) collegeData.get("college_address"));
			pstmt.setString(6,(String) collegeData.get("college_email"));
			pstmt.setString(7,(String) collegeData.get("college_mobile"));
			pstmt.setString(8,(String) collegeData.get("college_description"));
			pstmt.setString(9,(String) collegeData.get("college_website"));
			pstmt.setString(10,(String) collegeData.get("college_image"));

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////////////Function for getting Users Details//////////
	public HashMap getCollegeDetails(int college_id)
	{
		HashMap results = new HashMap();
		int count=0;
		try
		{
			String SQL = "SELECT * FROM `college`,`city`,`state` WHERE college_city = city_id AND college_state = state_id AND college_id = "+college_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				results.put("college_name",rs.getString("college_name"));
				results.put("college_city",Integer.parseInt(rs.getString("college_city")));
				results.put("college_state",Integer.parseInt(rs.getString("college_state")));
				results.put("college_country",Integer.parseInt(rs.getString("college_country")));
				results.put("college_mobile",rs.getString("college_mobile"));
				results.put("college_email",rs.getString("college_email"));
				results.put("college_address",rs.getString("college_address"));
				results.put("college_id",rs.getString("college_id"));
				results.put("college_image",rs.getString("college_image"));
				results.put("college_description",rs.getString("college_description"));
				results.put("college_website",rs.getString("college_website"));
				results.put("city_name",rs.getString("city_name"));
				results.put("state_name",rs.getString("state_name"));

				count++;
			}
			if(count==0)
			{
				results.put("college_name","");
				results.put("college_city",0);
				results.put("college_state",0);
				results.put("college_country",0);
				results.put("college_mobile","");
				results.put("college_email","");
				results.put("college_address","");
				results.put("college_id","");
				results.put("college_image","");
				results.put("college_description","");
				results.put("college_website","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return results;
	}
	/// Update the College ////
	public String updateCollege(HashMap collegeData)
	{
		String SQL = "UPDATE `college` SET `college_name` = ?, `college_city` = ?, `college_state` = ?, `college_country` = ?, `college_address` = ?, `college_email` = ?, `college_mobile` = ?, `college_description` = ?, `college_website` = ?, `college_image` = ? WHERE `college_id` = ?;";
		String error = "";

		int record=0;

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) collegeData.get("college_name"));
			pstmt.setString(2,(String) collegeData.get("college_city"));
			pstmt.setString(3,(String) collegeData.get("college_state"));
			pstmt.setString(4,(String) collegeData.get("college_country"));
			pstmt.setString(5,(String) collegeData.get("college_address"));
			pstmt.setString(6,(String) collegeData.get("college_email"));
			pstmt.setString(7,(String) collegeData.get("college_mobile"));
			pstmt.setString(8,(String) collegeData.get("college_description"));
			pstmt.setString(9,(String) collegeData.get("college_website"));
			pstmt.setString(10,(String) collegeData.get("college_image"));
			pstmt.setString(11,(String) collegeData.get("college_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllCollege(int typeID)
	{
		int count=0;
		String SQL = "";
		SQL = "SELECT * FROM `college`";
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("college_name",rs.getString("college_name"));
				results.put("college_city",rs.getString("college_city"));
				results.put("college_state",rs.getString("college_state"));
				results.put("college_country",rs.getString("college_country"));
				results.put("college_mobile",rs.getString("college_mobile"));
				results.put("college_email",rs.getString("college_email"));
				results.put("college_address",rs.getString("college_address"));
				results.put("college_id",rs.getString("college_id"));
				results.put("college_image",rs.getString("college_image"));
				results.put("college_description",rs.getString("college_description"));
				results.put("college_website",rs.getString("college_website"));
				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultArray;
	}

	public String saveCompany(HashMap companyData)
	{
		String SQL = "INSERT INTO `company` (`company_name`, `company_city`, `company_state`, `company_country`, `company_address`, `company_email`, `company_mobile`, `company_description`, `company_website`, `company_image`, `company_password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) companyData.get("company_name"));
			pstmt.setString(2,(String) companyData.get("company_city"));
			pstmt.setString(3,(String) companyData.get("company_state"));
			pstmt.setString(4,(String) companyData.get("company_country"));
			pstmt.setString(5,(String) companyData.get("company_address"));
			pstmt.setString(6,(String) companyData.get("company_email"));
			pstmt.setString(7,(String) companyData.get("company_mobile"));
			pstmt.setString(8,(String) companyData.get("company_description"));
			pstmt.setString(9,(String) companyData.get("company_website"));
			pstmt.setString(10,(String) companyData.get("company_image"));
			pstmt.setString(11,(String) companyData.get("company_password"));

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////////////Function for getting Users Details//////////
	public HashMap getCompanyDetails(int company_id)
	{
		HashMap results = new HashMap();
		int count=0;
		try
		{
			String SQL = "SELECT * FROM `company` WHERE company_id = "+company_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",Integer.parseInt(rs.getString("company_city")));
				results.put("company_state",Integer.parseInt(rs.getString("company_state")));
				results.put("company_country",Integer.parseInt(rs.getString("company_country")));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				results.put("company_password",rs.getString("company_password"));

				count++;
			}
			if(count==0)
			{
				results.put("company_password","");
				results.put("company_name","");
				results.put("company_city",0);
				results.put("company_state",0);
				results.put("company_country",0);
				results.put("company_mobile","");
				results.put("company_email","");
				results.put("company_address","");
				results.put("company_id","");
				results.put("company_image","");
				results.put("company_description","");
				results.put("company_website","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return results;
	}
	/// Update the Company ////
	public String updateCompany(HashMap companyData)
	{
		String SQL = "UPDATE `company` SET `company_name` = ?, `company_city` = ?, `company_state` = ?, `company_country` = ?, `company_address` = ?, `company_email` = ?, `company_mobile` = ?, `company_description` = ?, `company_website` = ?, `company_image` = ?, `company_password` = ? WHERE `company_id` = ?;";
		String error = "";

		int record=0;

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) companyData.get("company_name"));
			pstmt.setString(2,(String) companyData.get("company_city"));
			pstmt.setString(3,(String) companyData.get("company_state"));
			pstmt.setString(4,(String) companyData.get("company_country"));
			pstmt.setString(5,(String) companyData.get("company_address"));
			pstmt.setString(6,(String) companyData.get("company_email"));
			pstmt.setString(7,(String) companyData.get("company_mobile"));
			pstmt.setString(8,(String) companyData.get("company_description"));
			pstmt.setString(9,(String) companyData.get("company_website"));
			pstmt.setString(10,(String) companyData.get("company_image"));
			pstmt.setString(11,(String) companyData.get("company_password"));
			pstmt.setString(12,(String) companyData.get("company_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllCompany(int typeID)
	{
		int count=0;
		String SQL = "";
		SQL = "SELECT * FROM `company`";
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",rs.getString("company_city"));
				results.put("company_state",rs.getString("company_state"));
				results.put("company_country",rs.getString("company_country"));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultArray;
	}
	/////Function for Getting the List////////////
	public String getCityOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("city","city_id","city_name","city_id,city_name",selectedID,"1");
	}

	public String saveEmployee(HashMap employeeData)
	{

		String SQL = "INSERT INTO employee (employee_sal, employee_first_name, employee_middle_name, employee_last_name, employee_gender, employee_address, employee_village, employee_state, employee_country, employee_landline, employee_mobile, employee_email, employee_status, employee_deparment, employee_dob, employee_nationalty, employee_manager_id, employee_role) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?);";
		int record=0,last_inserted_id=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,(String) employeeData.get("employee_sal"));
			pstmt.setString(2,(String) employeeData.get("employee_first_name"));
			pstmt.setString(3,(String) employeeData.get("employee_middle_name"));
			pstmt.setString(4,(String) employeeData.get("employee_last_name"));
			pstmt.setString(5,(String) employeeData.get("employee_gender"));
			pstmt.setString(6,(String) employeeData.get("employee_address"));
			pstmt.setString(7,(String) employeeData.get("employee_village"));
			pstmt.setString(8,(String) employeeData.get("employee_state"));
			pstmt.setString(9,(String) employeeData.get("employee_country"));
			pstmt.setString(10,(String) employeeData.get("employee_landline"));
			pstmt.setString(11,(String) employeeData.get("employee_mobile"));
			pstmt.setString(12,(String) employeeData.get("employee_email"));
			pstmt.setString(13,(String) employeeData.get("employee_status"));
			pstmt.setString(14,(String) employeeData.get("employee_deparment"));
			pstmt.setString(15,(String) employeeData.get("employee_dob"));
			pstmt.setString(16,(String) employeeData.get("employee_nationalty"));
			pstmt.setString(17,(String) employeeData.get("employee_manager_id"));
			pstmt.setString(18,(String) employeeData.get("employee_role"));

			record = pstmt.executeUpdate();
			/// Get the Last Insert ID ///
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				last_inserted_id = rs.getInt(1);
			}

			pstmt.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}

		/// Save Credentials to Login ////
		SQL = "INSERT INTO login (login_emp_id, login_user, login_password, login_email, login_level) VALUES (?, ?, ?, ?, ?);";
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setInt(1,last_inserted_id);
			pstmt.setString(2,(String) employeeData.get("employee_user"));
			pstmt.setString(3,(String) employeeData.get("employee_password"));
			pstmt.setString(4,(String) employeeData.get("employee_email"));
			pstmt.setString(5,(String) employeeData.get("employee_role"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}

		return error;
	}

	//////////////////Function for getting Users Details//////////
	public HashMap getEmployeeDetails(int employee_id)
	{
		HashMap resultsArray = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM employee WHERE employee_id = "+employee_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				resultsArray.put("employee_id",rs.getString("employee_id"));
				resultsArray.put("employee_manager_id",Integer.parseInt(rs.getString("employee_manager_id")));
				resultsArray.put("employee_role",Integer.parseInt(rs.getString("employee_role")));
				resultsArray.put("employee_sal",Integer.parseInt(rs.getString("employee_sal")));
				resultsArray.put("employee_first_name",rs.getString("employee_first_name"));
				resultsArray.put("employee_middle_name",rs.getString("employee_middle_name"));
				resultsArray.put("employee_last_name",rs.getString("employee_last_name"));
				resultsArray.put("employee_gender",rs.getString("employee_gender"));
				resultsArray.put("employee_address",rs.getString("employee_address"));
				resultsArray.put("employee_village",rs.getString("employee_village"));
				resultsArray.put("employee_state",Integer.parseInt(rs.getString("employee_state")));
				resultsArray.put("employee_country",Integer.parseInt(rs.getString("employee_country")));
				resultsArray.put("employee_landline",rs.getString("employee_landline"));
				resultsArray.put("employee_mobile",rs.getString("employee_mobile"));
				resultsArray.put("employee_email",rs.getString("employee_email"));
				resultsArray.put("employee_status",Integer.parseInt(rs.getString("employee_status")));
				resultsArray.put("employee_deparment",Integer.parseInt(rs.getString("employee_deparment")));
				resultsArray.put("employee_dob",rs.getString("employee_dob"));
				resultsArray.put("employee_nationalty",rs.getString("employee_nationalty"));
				count++;
			}
			if(count==0)
			{
				resultsArray.put("employee_id","");
				resultsArray.put("employee_manager_id",0);
				resultsArray.put("employee_role",0);
				resultsArray.put("employee_user","");
				resultsArray.put("employee_sal",0);
				resultsArray.put("employee_first_name","");
				resultsArray.put("employee_middle_name","");
				resultsArray.put("employee_last_name","");
				resultsArray.put("employee_gender","");
				resultsArray.put("employee_address","");
				resultsArray.put("employee_village","");
				resultsArray.put("employee_state",0);
				resultsArray.put("employee_country",0);
				resultsArray.put("employee_landline","");
				resultsArray.put("employee_mobile","");
				resultsArray.put("employee_email","");
				resultsArray.put("employee_status",0);
				resultsArray.put("employee_deparment",0);
				resultsArray.put("employee_dob","");
				resultsArray.put("employee_nationalty","");

			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultsArray;
	}

	public String updateEmployee(HashMap employeeData)
	{
		String SQL = "UPDATE employee SET employee_sal = ?, employee_first_name = ?, employee_middle_name = ?, employee_last_name = ?, employee_gender = ?, employee_address = ?, employee_village = ?, employee_state = ?, employee_country = ?, employee_landline = ?, employee_mobile = ?, employee_email = ?, employee_status = ?, employee_deparment = ?, employee_dob = ?, employee_nationalty = ?, employee_manager_id = ?, employee_role = ? WHERE employee_id = ?";
		String error = "";

		int record=0;
		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) employeeData.get("employee_sal"));
			pstmt.setString(2,(String) employeeData.get("employee_first_name"));
			pstmt.setString(3,(String) employeeData.get("employee_middle_name"));
			pstmt.setString(4,(String) employeeData.get("employee_last_name"));
			pstmt.setString(5,(String) employeeData.get("employee_gender"));
			pstmt.setString(6,(String) employeeData.get("employee_address"));
			pstmt.setString(7,(String) employeeData.get("employee_village"));
			pstmt.setString(8,(String) employeeData.get("employee_state"));
			pstmt.setString(9,(String) employeeData.get("employee_country"));
			pstmt.setString(10,(String) employeeData.get("employee_landline"));
			pstmt.setString(11,(String) employeeData.get("employee_mobile"));
			pstmt.setString(12,(String) employeeData.get("employee_email"));
			pstmt.setString(13,(String) employeeData.get("employee_status"));
			pstmt.setString(14,(String) employeeData.get("employee_deparment"));
			pstmt.setString(15,(String) employeeData.get("employee_dob"));
			pstmt.setString(16,(String) employeeData.get("employee_nationalty"));
			pstmt.setString(17,(String) employeeData.get("employee_manager_id"));
			pstmt.setString(18,(String) employeeData.get("employee_role"));
			pstmt.setString(19,(String) employeeData.get("employee_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	public boolean deleteEmployee(int employee_id)
	{
		return true;
	}


	/////Function for Getting the List////////////
	public String getEmployeeOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("employee","employee_id","employee_id","employee_id,employee_id",selectedID,"1");
	}
	/////Function for Getting the List////////////
	public String getRoleOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("roles","role_id","role_title","role_id,role_title",selectedID,"1");
	}
	/////Function for Getting the List////////////
	public String getCountryOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("country","country_id","country_name","country_id,country_name",selectedID,"1");
	}

	/////Function for Getting the List////////////
	public String getSalutionOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("salutions","sl_id","sl_name","sl_id,sl_name",selectedID,"1");
	}

	/////Function for Getting the List////////////
	public String getStatusOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("status","status_id","status_name","status_id,status_name",selectedID,"1");
	}

	/////Function for Getting the List////////////
	public String getDepartmentOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("department","dept_id","dept_name","dept_id,dept_name",selectedID,"1");
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllEmployee(String managerID)
	{
		int count=0;
		String error = "";
		String SQL = "SELECT * FROM employee";

		ArrayList resultArray = new ArrayList();
		try
		{
			if(!managerID.equals("0"))
			{
				SQL = "SELECT * FROM employee WHERE employee_manager_id = "+managerID;
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("employee_id",rs.getString("employee_id"));
				results.put("employee_role",rs.getString("employee_role"));
				results.put("employee_sal",rs.getString("employee_sal"));
				results.put("employee_first_name",rs.getString("employee_first_name"));
				results.put("employee_middle_name",rs.getString("employee_middle_name"));
				results.put("employee_last_name",rs.getString("employee_last_name"));
				results.put("employee_gender",rs.getString("employee_gender"));
				results.put("employee_address",rs.getString("employee_address"));
				results.put("employee_village",rs.getString("employee_village"));
				results.put("employee_state",rs.getString("employee_state"));
				results.put("employee_country",rs.getString("employee_country"));
				results.put("employee_landline",rs.getString("employee_landline"));
				results.put("employee_mobile",rs.getString("employee_mobile"));
				results.put("employee_email",rs.getString("employee_email"));
				results.put("employee_status",Integer.parseInt(rs.getString("employee_status")));
				results.put("employee_deparment",Integer.parseInt(rs.getString("employee_deparment")));
				results.put("employee_dob",rs.getString("employee_dob"));
				results.put("employee_nationalty",rs.getString("employee_nationalty"));
				results.put("employee_manager_id",Integer.parseInt(rs.getString("employee_manager_id")));
				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return resultArray;
	}

	public String getDepartment(int dept_id)
	{
		HashMap results = new HashMap();
		String SQL = "";
		String value = "";
		int count=0;
		try
		{
			SQL =  "SELECT dept_name FROM department WHERE dept_id = "+dept_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				value = rs.getString("dept_name");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return value;
	}

	public String getStatus(int status_id)
	{
		HashMap results = new HashMap();
		String SQL = "";
		String value = "";
		int count=0;
		try
		{
			SQL =  "SELECT status_name FROM status WHERE status_id = "+status_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				value = rs.getString("status_name");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return value;
	}

	public String saveFaq(HashMap faqData)
	{
		String SQL = "INSERT INTO faq (faq_question, faq_answer) VALUES (?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) faqData.get("faq_question"));
			pstmt.setString(2,(String) faqData.get("faq_answer"));

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////////////Function for getting Users Details//////////
	public HashMap getFaqDetails(int faq_id)
	{
		HashMap results = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM faq WHERE faq_id = "+faq_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				results.put("faq_id",rs.getString("faq_id"));
				results.put("faq_question",rs.getString("faq_question"));
				results.put("faq_answer",rs.getString("faq_answer"));
				count++;
			}
			if(count==0)
			{
				results.put("faq_id","");
				results.put("faq_question","");
				results.put("faq_answer","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return results;
	}

	public String updateFaq(HashMap faqData)
	{
		String SQL = "UPDATE faq SET faq_question = ?,faq_answer = ? WHERE faq_id = ?";
		String error = "";

		int record=0;

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) faqData.get("faq_question"));
			pstmt.setString(2,(String) faqData.get("faq_answer"));
			pstmt.setString(3,(String) faqData.get("faq_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllFaq()
	{
		String SQL = "SELECT * FROM faq";
		int count=0;
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("faq_id",rs.getString("faq_id"));
				results.put("faq_question",rs.getString("faq_question"));
				results.put("faq_answer",rs.getString("faq_answer"));

				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultArray;
	}

	public String saveJob(HashMap jobData)
	{
		String SQL = "INSERT INTO `job` (`job_company_id`, `job_title`, `job_skills`, `job_post_date`, `job_city`, `job_description`, `job_jt_id`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) jobData.get("job_company_id"));
			pstmt.setString(2,(String) jobData.get("job_title"));
			pstmt.setString(3,(String) jobData.get("job_skills"));
			pstmt.setString(4,(String) jobData.get("job_post_date"));
			pstmt.setString(5,(String) jobData.get("job_city"));
			pstmt.setString(6,(String) jobData.get("job_description"));
			pstmt.setString(7,(String) jobData.get("job_jt_id"));

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////Save User Details /////
	public String apply(String jobID, String studentID)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		java.util.Date date = new Date();
		String todayDate = dateFormat.format(date);
		String  SQL = "INSERT INTO `apply` (`apply_job_id`, `apply_user_id`, `apply_date`) VALUES (?, ?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,jobID);
			pstmt.setString(2,studentID);
			pstmt.setString(3,todayDate);

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////Check for the application /////
	public boolean checkApplication(String jobID, String userID)
	{
		String SQL = "SELECT* from apply WHERE  apply_job_id = '" + jobID + "' AND  apply_user_id = '" + userID + "'";
		int record=0;
		String error = "";
		int count=0;
		boolean applied = false;
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				count = 1;
			}
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		if(count == 0)
			return false;
		return true;
	}
	//////////////////Function for getting Users Details//////////
	public HashMap getJobDetails(int job_id)
	{
		HashMap results = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM job, company, job_type, city WHERE city_id = job_city AND job_company_id = company_id AND job_jt_id = jt_id AND job_id = "+job_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				results.put("job_id",rs.getString("job_id"));
				results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
				results.put("job_title",rs.getString("job_title"));
				results.put("job_skills",rs.getString("job_skills"));
				results.put("job_post_date",rs.getString("job_post_date"));
				results.put("job_city",Integer.parseInt(rs.getString("job_city")));
				results.put("job_description",rs.getString("job_description"));
				results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",Integer.parseInt(rs.getString("company_city")));
				results.put("company_state",Integer.parseInt(rs.getString("company_state")));
				results.put("company_country",Integer.parseInt(rs.getString("company_country")));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				results.put("jt_title",rs.getString("jt_title"));
				results.put("city_name",rs.getString("city_name"));
				count++;
			}
			if(count==0)
			{
				results.put("job_id","");
				results.put("job_company_id",0);
				results.put("job_title","");
				results.put("job_skills","");
				results.put("job_post_date","");
				results.put("job_city",0);
				results.put("job_description","");
				results.put("job_jt_id",0);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return results;
	}

	public String updateJob(HashMap jobData)
	{
		String SQL = "UPDATE `job` SET `job_company_id` = ?, `job_title` = ?, `job_skills` = ?, `job_post_date` = ?, `job_city` = ?, `job_description` = ?, `job_jt_id` = ? WHERE `job_id` = ?;";
		String error = "";

		int record=0;

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) jobData.get("job_company_id"));
			pstmt.setString(2,(String) jobData.get("job_title"));
			pstmt.setString(3,(String) jobData.get("job_skills"));
			pstmt.setString(4,(String) jobData.get("job_post_date"));
			pstmt.setString(5,(String) jobData.get("job_city"));
			pstmt.setString(6,(String) jobData.get("job_description"));
			pstmt.setString(7,(String) jobData.get("job_jt_id"));
			pstmt.setString(8,(String) jobData.get("job_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllJob(int companyID)
	{
		String SQL;
		if(companyID == 0)
			SQL = "SELECT * FROM job, company, job_type WHERE job_company_id = company_id AND job_jt_id = jt_id";
		else
			SQL = "SELECT * FROM job, company, job_type WHERE job_company_id = company_id AND job_jt_id = jt_id AND company_id = "+companyID;
		int count=0;
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("job_id",rs.getString("job_id"));
				results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
				results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
				results.put("job_title",rs.getString("job_title"));
				results.put("job_skills",rs.getString("job_skills"));
				results.put("job_post_date",rs.getString("job_post_date"));
				results.put("job_city",Integer.parseInt(rs.getString("job_city")));
				results.put("job_description",rs.getString("job_description"));
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",Integer.parseInt(rs.getString("company_city")));
				results.put("company_state",Integer.parseInt(rs.getString("company_state")));
				results.put("company_country",Integer.parseInt(rs.getString("company_country")));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				results.put("jt_title",rs.getString("jt_title"));

				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultArray;
	}
	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllApplication(int apply_user_id)
	{
		String SQL;
		String error="";
		if(apply_user_id == 0)
			SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id";
		else
			SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id AND apply_user_id = "+apply_user_id;
		int count=0;
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("job_id",rs.getString("job_id"));
				results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
				results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
				results.put("job_title",rs.getString("job_title"));
				results.put("job_skills",rs.getString("job_skills"));
				results.put("job_post_date",rs.getString("job_post_date"));
				results.put("job_city",Integer.parseInt(rs.getString("job_city")));
				results.put("job_description",rs.getString("job_description"));
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",Integer.parseInt(rs.getString("company_city")));
				results.put("company_state",Integer.parseInt(rs.getString("company_state")));
				results.put("company_country",Integer.parseInt(rs.getString("company_country")));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				results.put("jt_title",rs.getString("jt_title"));
				results.put("student_name",rs.getString("student_name"));
				results.put("student_mobile",rs.getString("student_mobile"));
				results.put("student_email",rs.getString("student_email"));
				results.put("student_password",rs.getString("student_password"));
				results.put("student_address",rs.getString("student_address"));
				results.put("student_city",rs.getString("student_city"));
				results.put("student_state",Integer.parseInt(rs.getString("student_state")));
				results.put("student_pincode",rs.getString("student_pincode"));
				results.put("student_id",rs.getString("student_id"));
				results.put("apply_date",rs.getString("apply_date"));

				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return resultArray;
	}
	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getJobApplication(int company_id)
	{
		String SQL;
		String error="";
		SQL = "SELECT * FROM job, company, job_type,apply,student WHERE apply_user_id = student_id AND apply_job_id = job_id AND job_company_id = company_id AND job_jt_id = jt_id AND job_company_id = "+company_id;
		int count=0;
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("job_id",rs.getString("job_id"));
				results.put("job_company_id",Integer.parseInt(rs.getString("job_company_id")));
				results.put("job_jt_id",Integer.parseInt(rs.getString("job_jt_id")));
				results.put("job_title",rs.getString("job_title"));
				results.put("job_skills",rs.getString("job_skills"));
				results.put("job_post_date",rs.getString("job_post_date"));
				results.put("job_city",Integer.parseInt(rs.getString("job_city")));
				results.put("job_description",rs.getString("job_description"));
				results.put("company_name",rs.getString("company_name"));
				results.put("company_city",Integer.parseInt(rs.getString("company_city")));
				results.put("company_state",Integer.parseInt(rs.getString("company_state")));
				results.put("company_country",Integer.parseInt(rs.getString("company_country")));
				results.put("company_mobile",rs.getString("company_mobile"));
				results.put("company_email",rs.getString("company_email"));
				results.put("company_address",rs.getString("company_address"));
				results.put("company_id",rs.getString("company_id"));
				results.put("company_image",rs.getString("company_image"));
				results.put("company_description",rs.getString("company_description"));
				results.put("company_website",rs.getString("company_website"));
				results.put("jt_title",rs.getString("jt_title"));
				results.put("student_name",rs.getString("student_name"));
				results.put("student_mobile",rs.getString("student_mobile"));
				results.put("student_email",rs.getString("student_email"));
				results.put("student_password",rs.getString("student_password"));
				results.put("student_address",rs.getString("student_address"));
				results.put("student_city",rs.getString("student_city"));
				results.put("student_state",Integer.parseInt(rs.getString("student_state")));
				results.put("student_pincode",rs.getString("student_pincode"));
				results.put("student_id",rs.getString("student_id"));
				results.put("apply_date",rs.getString("apply_date"));

				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return resultArray;
	}

	/////Function for Getting the List////////////
	public String getJobTypeOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("job_type","jt_id","jt_title","jt_id,jt_title",selectedID,"1");
	}

	public boolean changePassword(String old_password,String new_password, int login_id)
	{
		String SQL;
		int count = 0;
		try
		{
			SQL = "SELECT * FROM login WHERE login_password = '"+old_password+"' AND login_id = "+login_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())	count++;
			if(count==1)
			{
				SQL = "UPDATE login SET login_password=? WHERE login_id=?";
				int record=0;
				pstmt = connection.prepareStatement(SQL);
				pstmt.setString(1,new_password);
				pstmt.setInt(2,login_id);
				record = pstmt.executeUpdate();
				pstmt.close();
				connection.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(" Error : "+ e.toString());
		}
		if(count==0)
			return false;
		return true;
	}

	//////////////////Function for getting Login Details//////////
	public HashMap getLoginDetails(String login_user,String login_password)
	{
		HashMap resultsArray = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM login WHERE login_user = '"+login_user+"' AND login_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				resultsArray.put("login_id",rs.getString("login_id"));
				resultsArray.put("login_emp_id",rs.getString("login_emp_id"));
				resultsArray.put("login_user",rs.getString("login_user"));
				resultsArray.put("login_level",rs.getString("login_level"));
				count++;
			}
			if(count==0)
			{
				resultsArray.put("login_id","");
				resultsArray.put("login_emp_id","");
				resultsArray.put("login_user","");
				resultsArray.put("login_level","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultsArray;
	}


	public String saveStudent(HashMap studentData)
	{
		String SQL = "INSERT INTO `student` (`student_name`, `student_mobile`, `student_email`, `student_password`, `student_address`, `student_city`, `student_state`, `student_pincode`, `student_high_college`, `student_high_start`, `student_high_pass`, `student_high_subject`, `student_high_persantage`, `student_inter_college`, `student_inter_start`, `student_inter_pass`, `student_inter_subject`, `student_inter_persantage`, `student_graduate_college`, `student_graduate_start`, `student_graduate_pass`, `student_graduate_subject`, `student_graduate_persantage`, `student_pg_college`, `student_pg_start`, `student_pg_pass`, `student_pg_subject`, `student_pg_persantage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int record=0;
		String error = "";

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) studentData.get("student_name"));
			pstmt.setString(2,(String) studentData.get("student_mobile"));
			pstmt.setString(3,(String) studentData.get("student_email"));
			pstmt.setString(4,(String) studentData.get("student_password"));
			pstmt.setString(5,(String) studentData.get("student_address"));
			pstmt.setString(6,(String) studentData.get("student_city"));
			pstmt.setString(7,(String) studentData.get("student_state"));
			pstmt.setString(8,(String) studentData.get("student_pincode"));
			pstmt.setString(9,(String) studentData.get("student_high_college"));
			pstmt.setString(10,(String) studentData.get("student_high_start"));
			pstmt.setString(11,(String) studentData.get("student_high_pass"));
			pstmt.setString(12,(String) studentData.get("student_high_subject"));
			pstmt.setString(13,(String) studentData.get("student_high_persantage"));
			pstmt.setString(14,(String) studentData.get("student_inter_college"));
			pstmt.setString(15,(String) studentData.get("student_inter_start"));
			pstmt.setString(16,(String) studentData.get("student_inter_pass"));
			pstmt.setString(17,(String) studentData.get("student_inter_subject"));
			pstmt.setString(18,(String) studentData.get("student_inter_persantage"));
			pstmt.setString(19,(String) studentData.get("student_graduate_college"));
			pstmt.setString(20,(String) studentData.get("student_graduate_start"));
			pstmt.setString(21,(String) studentData.get("student_graduate_pass"));
			pstmt.setString(22,(String) studentData.get("student_graduate_subject"));
			pstmt.setString(23,(String) studentData.get("student_graduate_persantage"));
			pstmt.setString(24,(String) studentData.get("student_pg_college"));
			pstmt.setString(25,(String) studentData.get("student_pg_start"));
			pstmt.setString(26,(String) studentData.get("student_pg_pass"));
			pstmt.setString(27,(String) studentData.get("student_pg_subject"));
			pstmt.setString(28,(String) studentData.get("student_pg_persantage"));

			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}
	//////////////////Function for getting Users Details//////////
	public HashMap getStudentDetails(int student_id)
	{
		HashMap results = new HashMap();
		int count=0;
		try
		{
			String SQL = "SELECT * FROM `student` WHERE student_id = "+student_id ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				results.put("student_name",rs.getString("student_name"));
				results.put("student_mobile",rs.getString("student_mobile"));
				results.put("student_email",rs.getString("student_email"));
				results.put("student_password",rs.getString("student_password"));
				results.put("student_address",rs.getString("student_address"));
				results.put("student_city",rs.getString("student_city"));
				results.put("student_state",Integer.parseInt(rs.getString("student_state")));
				results.put("student_pincode",rs.getString("student_pincode"));
				results.put("student_id",rs.getString("student_id"));
				results.put("student_high_college",rs.getString("student_high_college"));
				results.put("student_high_start",rs.getString("student_high_start"));
				results.put("student_high_pass",rs.getString("student_high_pass"));
				results.put("student_high_subject",rs.getString("student_high_subject"));
				results.put("student_high_persantage",rs.getString("student_high_persantage"));
				results.put("student_inter_college",rs.getString("student_inter_college"));
				results.put("student_inter_start",rs.getString("student_inter_start"));
				results.put("student_inter_pass",rs.getString("student_inter_pass"));
				results.put("student_inter_subject",rs.getString("student_inter_subject"));
				results.put("student_inter_persantage",rs.getString("student_inter_persantage"));
				results.put("student_graduate_college",rs.getString("student_graduate_college"));
				results.put("student_graduate_start",rs.getString("student_graduate_start"));
				results.put("student_graduate_pass",rs.getString("student_graduate_pass"));
				results.put("student_graduate_subject",rs.getString("student_graduate_subject"));
				results.put("student_graduate_persantage",rs.getString("student_graduate_persantage"));
				results.put("student_pg_college",rs.getString("student_pg_college"));
				results.put("student_pg_start",rs.getString("student_pg_start"));
				results.put("student_pg_pass",rs.getString("student_pg_pass"));
				results.put("student_pg_subject",rs.getString("student_pg_subject"));
				results.put("student_pg_persantage",rs.getString("student_pg_persantage"));
				count++;
			}
			if(count==0)
			{
				results.put("student_name","");
				results.put("student_mobile","");
				results.put("student_email","");
				results.put("student_password","");
				results.put("student_address","");
				results.put("student_city","");
				results.put("student_state",0);
				results.put("student_pincode","");
				results.put("student_id","");
				results.put("student_high_college","");
				results.put("student_high_start","");
				results.put("student_high_pass","");
				results.put("student_high_subject","");
				results.put("student_high_persantage","");
				results.put("student_inter_college","");
				results.put("student_inter_start","");
				results.put("student_inter_pass","");
				results.put("student_inter_subject","");
				results.put("student_inter_persantage","");
				results.put("student_graduate_college","");
				results.put("student_graduate_start","");
				results.put("student_graduate_pass","");
				results.put("student_graduate_subject","");
				results.put("student_graduate_persantage","");
				results.put("student_pg_college","");
				results.put("student_pg_start","");
				results.put("student_pg_pass","");
				results.put("student_pg_subject","");
				results.put("student_pg_persantage","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return results;
	}
	/// Update the Student ////
	public String updateStudent(HashMap studentData)
	{
		String SQL = "UPDATE `student` SET `student_name` = ?, `student_mobile` = ?, `student_email` = ?, `student_password` = ?, `student_address` = ?, `student_city` = ?, `student_state` = ?, `student_pincode` = ?, `student_high_college` = ?, `student_high_start` = ?, `student_high_pass` = ?, `student_high_subject` = ?, `student_high_persantage` = ?, `student_inter_college` = ?, `student_inter_start` = ?, `student_inter_pass` = ?, `student_inter_subject` = ?, `student_inter_persantage` = ?, `student_graduate_college` = ?, `student_graduate_start` = ?, `student_graduate_pass` = ?, `student_graduate_subject` = ?, `student_graduate_persantage` = ?, `student_pg_college` = ?, `student_pg_start` = ?, `student_pg_pass` = ?, `student_pg_subject` = ?, `student_pg_persantage` = ? WHERE `student_id` = ?;";
		String error = "";

		int record=0;

		try
		{
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1,(String) studentData.get("student_name"));
			pstmt.setString(2,(String) studentData.get("student_mobile"));
			pstmt.setString(3,(String) studentData.get("student_email"));
			pstmt.setString(4,(String) studentData.get("student_password"));
			pstmt.setString(5,(String) studentData.get("student_address"));
			pstmt.setString(6,(String) studentData.get("student_city"));
			pstmt.setString(7,(String) studentData.get("student_state"));
			pstmt.setString(8,(String) studentData.get("student_pincode"));
			pstmt.setString(9,(String) studentData.get("student_high_college"));
			pstmt.setString(10,(String) studentData.get("student_high_start"));
			pstmt.setString(11,(String) studentData.get("student_high_pass"));
			pstmt.setString(12,(String) studentData.get("student_high_subject"));
			pstmt.setString(13,(String) studentData.get("student_high_persantage"));
			pstmt.setString(14,(String) studentData.get("student_inter_college"));
			pstmt.setString(15,(String) studentData.get("student_inter_start"));
			pstmt.setString(16,(String) studentData.get("student_inter_pass"));
			pstmt.setString(17,(String) studentData.get("student_inter_subject"));
			pstmt.setString(18,(String) studentData.get("student_inter_persantage"));
			pstmt.setString(19,(String) studentData.get("student_graduate_college"));
			pstmt.setString(20,(String) studentData.get("student_graduate_start"));
			pstmt.setString(21,(String) studentData.get("student_graduate_pass"));
			pstmt.setString(22,(String) studentData.get("student_graduate_subject"));
			pstmt.setString(23,(String) studentData.get("student_graduate_persantage"));
			pstmt.setString(24,(String) studentData.get("student_pg_college"));
			pstmt.setString(25,(String) studentData.get("student_pg_start"));
			pstmt.setString(26,(String) studentData.get("student_pg_pass"));
			pstmt.setString(27,(String) studentData.get("student_pg_subject"));
			pstmt.setString(28,(String) studentData.get("student_pg_persantage"));
			pstmt.setString(29,(String) studentData.get("student_id"));
			record = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}
		catch(Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			e.printStackTrace( printWriter );
			printWriter.flush();
			String stackTrace = writer.toString();
			error+="Error : "+stackTrace;
			System.out.println(" Error : "+ e.toString());
		}
		return error;
	}

	////////////////Function for getting all the Airport Details////////////////////
	public ArrayList getAllStudent()
	{
		String SQL = "SELECT * FROM `student`";
		int count=0;
		ArrayList resultArray = new ArrayList();
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				HashMap results = new HashMap();
				results.put("student_name",rs.getString("student_name"));
				results.put("student_mobile",rs.getString("student_mobile"));
				results.put("student_email",rs.getString("student_email"));
				results.put("student_password",rs.getString("student_password"));
				results.put("student_address",rs.getString("student_address"));
				results.put("student_city",rs.getString("student_city"));
				results.put("student_state",Integer.parseInt(rs.getString("student_state")));
				results.put("student_pincode",rs.getString("student_pincode"));
				results.put("student_id",rs.getString("student_id"));
				results.put("student_high_college",rs.getString("student_high_college"));
				results.put("student_high_start",rs.getString("student_high_start"));
				results.put("student_high_pass",rs.getString("student_high_pass"));
				results.put("student_high_subject",rs.getString("student_high_subject"));
				results.put("student_high_persantage",rs.getString("student_high_persantage"));
				results.put("student_inter_college",rs.getString("student_inter_college"));
				results.put("student_inter_start",rs.getString("student_inter_start"));
				results.put("student_inter_pass",rs.getString("student_inter_pass"));
				results.put("student_inter_subject",rs.getString("student_inter_subject"));
				results.put("student_inter_persantage",rs.getString("student_inter_persantage"));
				results.put("student_graduate_college",rs.getString("student_graduate_college"));
				results.put("student_graduate_start",rs.getString("student_graduate_start"));
				results.put("student_graduate_pass",rs.getString("student_graduate_pass"));
				results.put("student_graduate_subject",rs.getString("student_graduate_subject"));
				results.put("student_graduate_persantage",rs.getString("student_graduate_persantage"));
				results.put("student_pg_college",rs.getString("student_pg_college"));
				results.put("student_pg_start",rs.getString("student_pg_start"));
				results.put("student_pg_pass",rs.getString("student_pg_pass"));
				results.put("student_pg_subject",rs.getString("student_pg_subject"));
				results.put("student_pg_persantage",rs.getString("student_pg_persantage"));
				count++;
				resultArray.add(results);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultArray;
	}
	/////Function for Getting the List////////////
	public String getStateOption(Integer SelID)
	{
		int selectedID = SelID.intValue();
		return getOptionList("state","state_id","state_name","state_id,state_name",selectedID,"1");
	}

	//////////////////Function for checking the existing username//////////
	public int checkUsernameExits(String login_user, int type)
	{
		HashMap resultsArray = new HashMap();
		int exits=0;
		try
		{
			String SQL = "";
			if(type == 1) {
				SQL =  "SELECT * FROM student WHERE student_email = '"+login_user+"'" ;
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				exits++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return exits;
	}
	//////////////////Function for geting the Single Airport Details//////////
	public boolean checkLogin(String login_user,String login_password)
	{
		int count=0;
		try
		{
			String SQL = "SELECT * FROM student WHERE student_email = '"+login_user+"' AND student_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())	count++;
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		if(count==0)
			return false;
		return true;
	}

	public String saveCustomer(HashMap var1) {
		String var2 = "INSERT INTO `customer` (`customer_name`, `customer_mobile`, `customer_email`, `customer_password`, `customer_address`, `customer_city`, `customer_state`, `customer_pincode`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		boolean var3 = false;
		String var4 = "";

		try {
			pstmt = connection.prepareStatement(var2);
			pstmt.setString(1, (String)var1.get("customer_name"));
			pstmt.setString(2, (String)var1.get("customer_mobile"));
			pstmt.setString(3, (String)var1.get("customer_email"));
			pstmt.setString(4, (String)var1.get("customer_password"));
			pstmt.setString(5, (String)var1.get("customer_address"));
			pstmt.setString(6, (String)var1.get("customer_city"));
			pstmt.setString(7, (String)var1.get("customer_state"));
			pstmt.setString(8, (String)var1.get("customer_pincode"));
			int var10 = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (Exception var9) {
			StringWriter var6 = new StringWriter();
			PrintWriter var7 = new PrintWriter(var6);
			var9.printStackTrace(var7);
			var7.flush();
			String var8 = var6.toString();
			var4 = var4 + "Error : " + var8;
			System.out.println(" Error : " + var9.toString());
		}

		return var4;
	}

	public HashMap getCustomerDetails(int var1) {
		HashMap var2 = new HashMap();
		int var3 = 0;

		try {
			String var4 = "SELECT * FROM `customer` WHERE customer_id = " + var1;
			statement = connection.createStatement();

			for(rs = statement.executeQuery(var4); rs.next(); ++var3) {
				var2.put("customer_name", rs.getString("customer_name"));
				var2.put("customer_mobile", rs.getString("customer_mobile"));
				var2.put("customer_email", rs.getString("customer_email"));
				var2.put("customer_password", rs.getString("customer_password"));
				var2.put("customer_address", rs.getString("customer_address"));
				var2.put("customer_city", rs.getString("customer_city"));
				var2.put("customer_state", Integer.parseInt(rs.getString("customer_state")));
				var2.put("customer_pincode", rs.getString("customer_pincode"));
				var2.put("customer_id", rs.getString("customer_id"));
			}

			if (var3 == 0) {
				var2.put("customer_name", "");
				var2.put("customer_mobile", "");
				var2.put("customer_email", "");
				var2.put("customer_password", "");
				var2.put("customer_address", "");
				var2.put("customer_city", "");
				var2.put("customer_state", 0);
				var2.put("customer_pincode", "");
				var2.put("customer_id", "");
			}
		} catch (Exception var5) {
			System.out.println("Error is: " + var5);
		}

		return var2;
	}

	public String updateCustomer(HashMap var1) {
		String var2 = "UPDATE `customer` SET `customer_name` = ?, `customer_mobile` = ?, `customer_email` = ?, `customer_password` = ?, `customer_address` = ?, `customer_city` = ?, `customer_state` = ?, `customer_pincode` = ? WHERE `customer_id` = ?;";
		String var3 = "";
		boolean var4 = false;

		try {
			pstmt = connection.prepareStatement(var2);
			pstmt.setString(1, (String)var1.get("customer_name"));
			pstmt.setString(2, (String)var1.get("customer_mobile"));
			pstmt.setString(3, (String)var1.get("customer_email"));
			pstmt.setString(4, (String)var1.get("customer_password"));
			pstmt.setString(5, (String)var1.get("customer_address"));
			pstmt.setString(6, (String)var1.get("customer_city"));
			pstmt.setString(7, (String)var1.get("customer_state"));
			pstmt.setString(8, (String)var1.get("customer_pincode"));
			pstmt.setString(9, (String)var1.get("customer_id"));
			int var10 = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (Exception var9) {
			StringWriter var6 = new StringWriter();
			PrintWriter var7 = new PrintWriter(var6);
			var9.printStackTrace(var7);
			var7.flush();
			String var8 = var6.toString();
			var3 = var3 + "Error : " + var8;
			System.out.println(" Error : " + var9.toString());
		}

		return var3;
	}

	public ArrayList getAllCustomer() {
		String var1 = "SELECT * FROM `customer`";
		int var2 = 0;
		ArrayList var3 = new ArrayList();

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(var1);

			while(rs.next()) {
				HashMap var4 = new HashMap();
				var4.put("customer_name", rs.getString("customer_name"));
				var4.put("customer_mobile", rs.getString("customer_mobile"));
				var4.put("customer_email", rs.getString("customer_email"));
				var4.put("customer_password", rs.getString("customer_password"));
				var4.put("customer_address", rs.getString("customer_address"));
				var4.put("customer_city", rs.getString("customer_city"));
				var4.put("customer_state", Integer.parseInt(rs.getString("customer_state")));
				var4.put("customer_pincode", rs.getString("customer_pincode"));
				var4.put("customer_id", rs.getString("customer_id"));
				++var2;
				var3.add(var4);
			}
		} catch (Exception var5) {
			System.out.println("Error is: " + var5);
		}

		return var3;
	}

	public HashMap getLoginDetailsCustomer(String var1, String var2) {
		HashMap var3 = new HashMap();
		int var4 = 0;

		try {
			String var5 = "SELECT * FROM customer WHERE customer_email = '" + var1 + "' AND customer_password = '" + var2 + "'";
			statement = connection.createStatement();

			for(rs = statement.executeQuery(var5); rs.next(); ++var4) {
				var3.put("customer_id", rs.getString("customer_id"));
				var3.put("customer_name", rs.getString("customer_name"));
				var3.put("login_level", 4);
			}

			if (var4 == 0) {
				var3.put("customer_id", "");
				var3.put("customer_name", "");
				var3.put("login_level", 0);
			}
		} catch (Exception var6) {
			System.out.println("Error is: " + var6);
		}

		return var3;
	}

	public int checkUsernameExitsCustomer(String var1, int var2) {
		new HashMap();
		int var4 = 0;

		try {
			String var5 = "";
			if (var2 == 1) {
				var5 = "SELECT * FROM customer WHERE customer_email = '" + var1 + "'";
			}

			statement = connection.createStatement();

			for(rs = statement.executeQuery(var5); rs.next(); ++var4) {
			}
		} catch (Exception var6) {
			System.out.println("Error is: " + var6);
		}

		return var4;
	}

	public boolean checkLoginCustomer(String var1, String var2) {
		int var3 = 0;

		try {
			String var4 = "SELECT * FROM customer WHERE customer_email = '" + var1 + "' AND customer_password = '" + var2 + "'";
			statement = connection.createStatement();

			for(rs = statement.executeQuery(var4); rs.next(); ++var3) {
			}
		} catch (Exception var5) {
			System.out.println("Error is: " + var5);
		}

		return var3 != 0;
	}

	//////////////////Function for getting Login Details//////////
	public HashMap getLoginDetailsStudent(String login_user,String login_password)
	{
		HashMap resultsArray = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM student WHERE student_email = '"+login_user+"' AND student_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				resultsArray.put("student_id",rs.getString("student_id"));
				resultsArray.put("student_name",rs.getString("student_name"));
				resultsArray.put("login_level",4);
				count++;
			}
			if(count==0)
			{
				resultsArray.put("student_id","");
				resultsArray.put("student_name","");
				resultsArray.put("login_level",0);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultsArray;
	}
	//////////////////Function for checking the existing username//////////
	public int checkUsernameExitsStudent(String login_user, int type)
	{
		HashMap resultsArray = new HashMap();
		int exits=0;
		try
		{
			String SQL = "";
			if(type == 1) {
				SQL =  "SELECT * FROM student WHERE student_email = '"+login_user+"'" ;
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				exits++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return exits;
	}
	//////////////////Function for geting the Single Airport Details//////////
	public boolean checkLoginStudent(String login_user,String login_password)
	{
		int count=0;
		try
		{
			String SQL = "SELECT * FROM student WHERE student_email = '"+login_user+"' AND student_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())	count++;
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		if(count==0)
			return false;
		return true;
	}

	public boolean checkLoginLogin(String login_user,String login_password)
	{
		int count=0;
		try
		{
			String SQL = "SELECT * FROM login WHERE login_user = '"+login_user+"' AND login_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())	count++;
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		if(count==0)
			return false;
		return true;
	}
	//////////////////Function for getting Login Details//////////
	public HashMap getLoginDetailsLogin(String login_user,String login_password)
	{
		HashMap resultsArray = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM login WHERE login_user = '"+login_user+"' AND login_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				resultsArray.put("login_id",rs.getString("login_id"));
				resultsArray.put("login_emp_id",rs.getString("login_emp_id"));
				resultsArray.put("login_user",rs.getString("login_user"));
				resultsArray.put("login_level",rs.getString("login_level"));
				count++;
			}
			if(count==0)
			{
				resultsArray.put("login_id","");
				resultsArray.put("login_emp_id","");
				resultsArray.put("login_user","");
				resultsArray.put("login_level","");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultsArray;
	}
	//////////////////Function for getting Login Details//////////
	public int checkUsernameExitsLogin(String login_user, int type)
	{
		HashMap resultsArray = new HashMap();
		int exits=0;
		try
		{
			String SQL = "";
			if(type == 1) {
				SQL =  "SELECT * FROM login WHERE login_user = '"+login_user+"'" ;
			}
			if(type == 2) {
				SQL =  "SELECT * FROM login WHERE login_email = '"+login_user+"'" ;
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				exits++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return exits;
	}

	public HashMap getLoginDetailsCompany(String login_user,String login_password)
	{
		HashMap resultsArray = new HashMap();
		int count=0;
		try
		{
			String SQL =  "SELECT * FROM company WHERE company_email = '"+login_user+"' AND company_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				resultsArray.put("company_id",rs.getString("company_id"));
				resultsArray.put("company_name",rs.getString("company_name"));
				resultsArray.put("login_level",4);
				count++;
			}
			if(count==0)
			{
				resultsArray.put("company_id","");
				resultsArray.put("company_name","");
				resultsArray.put("login_level",0);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return resultsArray;
	}
	//////////////////Function for checking the existing username//////////
	public int checkUsernameExitsCompany(String login_user, int type)
	{
		HashMap resultsArray = new HashMap();
		int exits=0;
		try
		{
			String SQL = "";
			if(type == 1) {
				SQL =  "SELECT * FROM company WHERE company_email = '"+login_user+"'" ;
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())
			{
				exits++;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		return exits;
	}
	//////////////////Function for geting the Single Airport Details//////////
	public boolean checkLoginCompany(String login_user,String login_password)
	{
		int count=0;
		try
		{
			String SQL = "SELECT * FROM company WHERE company_email = '"+login_user+"' AND company_password = '"+login_password+"'" ;
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL);
			while(rs.next())	count++;
		}
		catch(Exception e)
		{
			System.out.println("Error is: "+ e);
		}
		if(count==0)
			return false;
		return true;
	}
}
