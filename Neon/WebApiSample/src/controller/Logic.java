package controller;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/logic")
public class Logic {
	@Path("/array/{arr}/target/{target}")
	@GET
	@Produces("application/json")
	public Response findPair(@PathParam("numbers") List<Integer> arr,@PathParam("target") int target) throws JSONException
	{
		HashMap<Integer, Integer> pairs = new HashMap<>();
		for(int i = 0; i < arr.size(); i++){
			if(pairs.containsKey(arr.get(i))){
				System.out.println(arr.get(i) +" + "+pairs.get(arr.get(i)));
			}else{
				pairs.put(target - arr.get(i), arr.get(i));
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pairs", pairs);
		return Response.status(200).entity(jsonObject.toString()).build();
	}

	@Path("{list}")
	@GET
	@Produces("application/json")
	public Response SecretaryProblem(@PathParam("list") List<Integer> list) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("something", "hellow");
		int p = 37;
		int nextBest = 0;
		int best = 0;
		for(int i = 0; i < p; i++){
			if(list.get(i) > nextBest){
				nextBest = list.get(i);
			}
		}
		for(int i = p; i < list.size(); i++){
			if(list.get(i) > nextBest){
				best = list.get(i);
				break;
			}
		}
		jsonObject.put("valuePicked", best);
		return Response.status(200).entity(jsonObject).build();
	}
	
	@Path("/sayhellomultiple/{n}/{m}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response SayHello(@PathParam("n") String name1, @PathParam("m") String name2) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		String greeting = "Hello ";
		jsonObject.put("Greetings", greeting+name1+" and "+name2);
		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}
	
	
	@Path("/isPalindrome")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response isPalindrome(@QueryParam("number") int number) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		int checknumber = number;
		int reverse = 0;
		boolean isPalindrome = false;
		while(checknumber != 0)
		{
			int mod = checknumber % 10;
			reverse = reverse * 10 + mod;
			checknumber/=10;
		}
		
		if(reverse == number)
		{
			isPalindrome = true;
		}
		jsonObject.put(String.valueOf(number), isPalindrome);
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}

