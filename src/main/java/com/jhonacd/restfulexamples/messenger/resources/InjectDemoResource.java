package com.jhonacd.restfulexamples.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("matrixParam") String pMatrixParam,
			@HeaderParam("headerParam") String pHeaderParam, @CookieParam("cookieParam") String pCookieParam) {
		return "matrixParam: " + pMatrixParam + "headerParam: " + pHeaderParam + "cookieParam: " + pCookieParam;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo pUriInfo, @Context HttpHeaders pHttpHeaders) {
		String path = pUriInfo.getAbsolutePath().toString();
		String cookies = pHttpHeaders.getCookies().toString();
		return path  + " . " + cookies + " :)";
	}
}
