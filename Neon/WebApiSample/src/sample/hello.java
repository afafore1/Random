package sample;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/hello")
public class hello {
	@Path("/sayhello/{n}")
	@GET
	@Produces("application/json")
	public Response SayHello(@PathParam("n") String name) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		String greeting = "Hello ";
		jsonObject.put("Greeting", greeting+name);
		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}
}
