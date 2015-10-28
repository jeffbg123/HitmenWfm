package com.hitmenwfm.restapi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/")
public class HitmenWfmRestService {
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "HitmenWfm Successfully started....";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}

	//-----------------------------------------------
	//USER ENDPOINTS
	//-----------------------------------------------
	
	//POST /user	user credentials and other required information	user registration
	@POST
	@Path("/postuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUser(InputStream incomingData) {
		return null;
	}
	
	//POST /user/forgot	user email	reset and send email
	@POST
	@Path("/postuser/forget")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUserForget(InputStream incomingData) {
		return null;
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
	
	
}
