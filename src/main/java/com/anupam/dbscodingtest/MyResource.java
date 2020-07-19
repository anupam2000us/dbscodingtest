package com.anupam.dbscodingtest;



import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Level;

import com.anupam.dbscodingtest.models.*;
import com.anupam.dbscodingtest.services.FileService;
import com.anupam.dbscodingtest.services.IFileService;
import com.anupam.dbscodingtest.utils.DBSLoggerUtil;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/fileservice")
public class MyResource {
	private IFileService fs = new FileService();
	private static DBSLoggerUtil logger = new DBSLoggerUtil(MyResource.class.getName());
	
	@GET
    @Path("/greet")
    public Response getGreeting(@QueryParam("name") String name) {
        return Response.status(200).entity("Welcome " + name).build();
    }
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/files")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFiles(@QueryParam("fn") String name) {
    	logger.log(Level.INFO, "input query param is " + name, "getFiles");
    	
    	try {
    		List<DBSFile> files = fs.getFiles(name);
            GenericEntity<List<DBSFile>> fileData = new GenericEntity<List<DBSFile>>(files) {};
            return Response.status(200).entity(fileData).build(); 
    	} catch(Exception ex) {
    		logger.log(Level.SEVERE, "An error occured in the service." + ex.getMessage(), "getFiles");
    		GenericEntity<String> error = new GenericEntity<String>("Error occured in service") {};
    		return Response.status(500).entity(error).build();
    	}
        
    }
    
    @GET
    @Path("/files/file")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFileDetail(@QueryParam("name") String name) {
    	logger.log(Level.INFO, "input query param is " + name, "getFileDetail");
    	try {
    		DBSFile file = fs.getFileDetail(name);
            GenericEntity<DBSFile> fileData = new GenericEntity<DBSFile>(file) {};
            return Response.status(200).entity(fileData).build(); 
    	} catch(Exception ex) {
    		logger.log(Level.SEVERE, "An error occured in the service." + ex.getMessage(), "getFileDetail");
    		GenericEntity<String> error = new GenericEntity<String>("Error occured in service") {};
    		return Response.status(500).entity(error).build();
    		
    	}
    }
}
