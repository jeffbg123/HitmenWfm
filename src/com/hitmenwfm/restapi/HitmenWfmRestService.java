package com.hitmenwfm.restapi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.print.attribute.standard.Media;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class HitmenWfmRestService {

	//-----------------------------------------------
	//USER ENDPOINTS
	//-----------------------------------------------
	
	
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) throws Exception {
		SqlHelper sh = new SqlHelper();
		sh.InsertUser(user);
		return user;
	}
	
	/*
	//POST /user	user credentials and other required information	user registration
	@POST
	@Path("/postuser")
	@Produces(MediaType.TEXT_PLAIN)
	public Response postUser(@DefaultValue("NONE") @QueryParam("username") String username,
			@DefaultValue("NONE") @QueryParam("email") String email,
			@DefaultValue("NONE") @QueryParam("password") String password, 
			@DefaultValue("NONE") @QueryParam("firstname") String firstName, 
			@DefaultValue("NONE") @QueryParam("lastname") String lastName,
			@DefaultValue("NONE") @QueryParam("middlename") String middleName, 
			@DefaultValue("NONE") @QueryParam("streetaddressline1") String streetAddressLine1, 
			@DefaultValue("NONE") @QueryParam("streetaddressline2") String streetAddressLine2,
			@DefaultValue("NONE") @QueryParam("streetaddressline3") String streetAddressLine3, 
			@DefaultValue("NONE") @QueryParam("city") String city, 
			@DefaultValue("NONE") @QueryParam("state") String state,
			@DefaultValue("NONE") @QueryParam("zip") String zip, 
			@DefaultValue("NONE") @QueryParam("homephone") String homePhone, 
			@DefaultValue("NONE") @QueryParam("cellPhone") String cellPhone, 
			@DefaultValue("NONE") @QueryParam("birthdate") String birthDate) throws Exception {
		SqlHelper sh = new SqlHelper();
		if(username != null)
			sh.InsertUser( username,  email,  password,  firstName,  lastName,
					 middleName,  streetAddressLine1,  streetAddressLine2,  streetAddressLine3,  city,
					 state,  zip,  homePhone,  cellPhone,  birthDate);
		String output = "POSTUSER: Added user " + username;

		return Response.status(200).entity(output).build();
	}
	
	//POST /user/forgot	user email	reset and send email
	@POST
	@Path("/postuser/forget")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response postUserForget(InputStream incomingData) {
		String output = "POST:Jersey test : ";
        return Response.status(200).entity(output).build();
	}
	
	//POST /user/password	old pw, new pw	reset pw
	@POST
	@Path("/postuser/password")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUserPassword(InputStream incomingData) {
		return null;
	}
	
	//POST /user/login	user credentials	user login, returns user object with all data
	@POST
	@Path("/postuser/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUserLogin(InputStream incomingData) {
		return null;
	}
	
	//GET /user/:userId		user information for user id with settings
	@GET
	@Path("/getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(InputStream incomingData) {
		return null;
	}
	
	//POST /user/settings	set user settings	
	@POST
	@Path("/postuser/settings")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUserSettings(InputStream incomingData) {
		return null;
	}
	
	//-----------------------------------------------
	//TASK ENDPOINTS
	//-----------------------------------------------
	
	//POST /tasks	task information	create task
	@POST
	@Path("/posttasks")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postTasks(InputStream incomingData) {
		return null;
	}
	
	//GET /tasks/:userId/{all/completed/outstanding}	get tasks for person	get task
	@GET
	@Path("/gettasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTasks(InputStream incomingData) {
		return null;
	}
	
	//PUT /task/:taskId	updated task information	update task
	@POST
	@Path("/postupdatedtasks")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUpdatedTasks(InputStream incomingData) {
		return null;
	}
	
	//DELETE /task/:taskId		remove task
	@POST
	@Path("/deletetask")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTask(InputStream incomingData) {
		return null;
	}
	
	//POST /task/:taskId/complete	user completed task	
	@POST
	@Path("/postcompletetask")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCompleteTask(InputStream incomingData) {
		return null;
	}
	

	//-----------------------------------------------
	//TEMPLATE ENDPOINTS
	//-----------------------------------------------
	
	//GET /templates		templates
	@GET
	@Path("/gettemplates")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTemplates(InputStream incomingData) {
		return null;
	}
	
	//GET /templates/:templateId		list of tasks under template
	@GET
	@Path("/gettemplatedid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTemplatedId(InputStream incomingData) {
		return null;
	}
	
	

	//-----------------------------------------------
	//REPORT ENDPOINTS
	//-----------------------------------------------
	
	//GET /report		report data for all
	@GET
	@Path("/getreport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReport(InputStream incomingData) {
		return null;
	}
	
	//GET /report/:userId		report data for user
	@GET
	@Path("/getreportid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportId(InputStream incomingData) {
		return null;
	}
	
	//-------------------------------------------------
	//RANDOM
	//-------------------------------------------------
	@GET
	@Path("/getpatients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatients(InputStream incomingData) {
		String result = getTextFromURL("http://polaris.i3l.gatech.edu:8080/gt-fhir-webapp/base/Patient");
		
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/refreshpatients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshPatients(InputStream incomingData) {
		return null;
	}
	
	public String getTextFromURL(String urltxt) {
		try {
			String toReturn = "";
			URL url = new URL(urltxt);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while((line = in.readLine()) != null) {
				toReturn += line + "\n";
			}
			in.close();
			return toReturn;
		}
		catch(Exception e)
		{
			System.out.println("Exception = " + e.getMessage());
		}
		return "";
	}
	*/
	
}
