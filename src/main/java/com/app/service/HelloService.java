package com.app.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.entity.Person;

@Path("/hello")
public class HelloService {
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonName(){
		DataConnection connection = new DataConnection();
		Connection con = connection.getConnection();
		
		Person person = new Person();
		String viewData = "SELECT * FROM users";
		
		try{
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(viewData);
			
			while(resultSet.next()){
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
				person.setEmail(resultSet.getString("email"));
			}

			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return person;
	}
	
}
