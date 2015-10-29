package com.hitmenwfm.restapi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlHelper {
	
	public void InsertUser(String username, String email, String password, String firstName, String lastName,
			String middleName, String streetAddress1, String streetAddress2, String streetAddress3, String city,
			String state, String zip, String homePhone, String cellPhone, String bday) throws Exception {
		Connection conn = getMySqlConnection();
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String paramString = String.format("'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'", 
				username, 
				email, 
				password,
				firstName,
				lastName,
				middleName,
				streetAddress1,
				streetAddress2,
				streetAddress3,
				city,
				zip,
				state,
				homePhone,
				cellPhone,
				dateString);
	    String simpleProc = "{ call sp_UI_CreateNewUser(" + paramString + ") }";
	    CallableStatement cs = conn.prepareCall(simpleProc);
	    cs.execute();
	    conn.close();
	}
	
	public static Connection getMySqlConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_a072c6d825fcf83";
		Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		Connection conn = DriverManager.getConnection (url, "b63f5d595665c5", "6531134d");
		return conn;
	  }
}
