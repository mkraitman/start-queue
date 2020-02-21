package redis.client.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import redis.client.jedis.connection.JedisConnection;
import redis.client.model.KeyValue;
import redis.client.model.RedisConfig;

@Service
@RestController
@RequestMapping(path = "/")
public class JedisClientController {

	ApplicationContext contexto = new ClassPathXmlApplicationContext("RedisConfig.xml");
	RedisConfig config = (RedisConfig) contexto.getBean("RedisConfig");

	@GetMapping(path = "get/{key}", produces = "application/json")
	public ResponseEntity getValue(@PathVariable String key) {
		String value;

		JedisConnection jedisConnection = new JedisConnection();
		value = jedisConnection.getValue(key);

		return ResponseEntity.ok("Key = " + key + " Value = " + value);
	}

	@PostMapping(path = "set")
	public ResponseEntity setValue(@RequestBody KeyValue keyValue) {
		JedisConnection jedisConnection = new JedisConnection();
		jedisConnection.setKey(keyValue.getKey(), keyValue.getValue());

		return ResponseEntity.ok(keyValue.getKey() + " = " + keyValue.getValue());
	}
//    
//    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Object> addEmployee(
//                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
//                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
//                        @RequestBody Employee employee) 
//                 throws Exception 
//    {       
//        //Generate resource id
//        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
//        employee.setId(id);
//        
//        //add resource
//        employeeDao.addEmployee(employee);
//        
//        //Create resource location
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                                    .path("/{id}")
//                                    .buildAndExpand(employee.getId())
//                                    .toUri();
//        
//        //Send location in response
//        return ResponseEntity.created(location).build();
//    }
}
