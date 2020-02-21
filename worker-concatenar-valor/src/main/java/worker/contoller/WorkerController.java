package worker.contoller;

import java.net.URI;

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
import worker.model.test.ConcatResponse;

@Service
@RestController
@RequestMapping(path = "/concatenar-valor")
public class WorkerController {

	ApplicationContext contexto = new ClassPathXmlApplicationContext("RedisConfig.xml");
	RedisConfig config = (RedisConfig) contexto.getBean("RedisConfig");
	JedisConnection jedisConnection = new JedisConnection();

	@GetMapping(path = "/{key}/{agregado}", produces = "application/json")
	public ResponseEntity getValue(@PathVariable String key, @PathVariable String agregado) {
		ConcatResponse response = new ConcatResponse();
		String valor = jedisConnection.getValue(key);
		response.setValorOriginal(valor);
		response.setAgregado(agregado);
		valor = valor + agregado;
		jedisConnection.setKey(key, valor);
		response.setResultado(valor);

		return ResponseEntity.ok(response);
	}
}