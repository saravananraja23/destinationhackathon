package com.mygola.hackathon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hack")
public class SampleService {

	@GET
	public String testAPI(){
		return "SUCCESS";
	}
	
}
