package com.mygola.hackathon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/hack")
public class SampleService {

	@GET
	public String testAPI(){
		return "SUCCESS";
	}
	
	@GET
	public String testGoogleAPI(){
		
		return null;
		
	}
	
	public String testmaps() throws Exception{
		
		GeoApiContext context = new GeoApiContext();
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		System.out.println(results[0].formattedAddress);

		return null;
	}

	public static void main(String args[]) throws Exception{
		SampleService ser =  new SampleService();
		ser.testmaps();
		Client c= Client.create();
		WebResource resource = c.resource("http://maps.googleapis.com/maps/api/elevation/json?");
		
		//https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=
		//https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=
		ClientResponse response = resource
				.queryParam("locations", "40.714728,-73.998672|-34.397,150.644")
				//.queryParam("destination", "Ooty")
				//.queryParam("key", "AIzaSyCFXPoYGneMy16Gi1hi6nCXbraafFwaQCM")
				.queryParam("samples", "three")
				.get(ClientResponse.class); 
		
		/*ClientResponse response = resource
				.queryParam("origin", "Bangalore")
				.queryParam("destination", "Ooty")
				.queryParam("key", "AIzaSyCFXPoYGneMy16Gi1hi6nCXbraafFwaQCM")
				.get(ClientResponse.class); 
		*/
		String jsonResponse = response.getEntity(String.class);
		System.out.println("Response "+ jsonResponse);
}

}


