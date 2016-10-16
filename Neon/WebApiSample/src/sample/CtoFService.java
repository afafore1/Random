package sample;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ctofservice")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF(){
		Double f;
		Double c = 36.8;
		f = ((c * 9)/5) + 32;
		
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n"+f;
		return "<ctofservice>"+"<celsius>"+c+"</celsius>"+"<ctofoutput>"+result+"</ctofoutput>"+"</ctofservice>";
	}
	
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertTtoFfromInput(@PathParam("c") Double c)
	{
		Double f;
		Double cel = c;
		f = ((c * 9)/5) + 32;
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n"+f;
		return "<ctofservice>" + "<celsius>" + cel + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
}
