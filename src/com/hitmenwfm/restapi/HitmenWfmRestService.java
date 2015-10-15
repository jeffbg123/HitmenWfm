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
		String result = "HitmenWfm Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/getpatients")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPatients(InputStream incomingData) {
		String result = getTextFromURL("http://polaris.i3l.gatech.edu:8080/gt-fhir-webapp/base/Patient");
		
		return Response.status(200).entity(result).build();
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
