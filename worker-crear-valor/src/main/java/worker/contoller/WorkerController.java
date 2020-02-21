package worker.contoller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.client.jedis.connection.JedisConnection;
import redis.client.model.RedisConfig;
import worker.model.test.AgregarValorResponse;

@Service
@RestController
@RequestMapping(path = "/crear-valor")
public class WorkerController {

	ApplicationContext contexto = new ClassPathXmlApplicationContext("RedisConfig.xml");
	RedisConfig config = (RedisConfig) contexto.getBean("RedisConfig");
	JedisConnection jedisConnection = new JedisConnection();

	@GetMapping(path = "/{clave}/{valor}", produces = "application/json")
	public ResponseEntity getValue(@PathVariable String clave, @PathVariable String valor) {
		AgregarValorResponse response = new AgregarValorResponse();
		response.setValor(valor);
		response.setClave(clave);
		jedisConnection.setKey(clave, valor);
		return ResponseEntity.ok(response);
	}
}