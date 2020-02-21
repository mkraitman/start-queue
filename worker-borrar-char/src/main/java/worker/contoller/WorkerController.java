package worker.contoller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.client.jedis.connection.JedisConnection;
import redis.client.model.RedisConfig;
import worker.model.test.RemplazarCharResponse;

@Service
@RestController
@RequestMapping(path = "/borrar-char")
public class WorkerController {

	ApplicationContext contexto = new ClassPathXmlApplicationContext("RedisConfig.xml");
	RedisConfig config = (RedisConfig) contexto.getBean("RedisConfig");
	JedisConnection jedisConnection = new JedisConnection();

	@GetMapping(path = "/{key}/{character}", produces = "application/json")
	public ResponseEntity getValue(@PathVariable String character, @PathVariable String key) {
		RemplazarCharResponse response = new RemplazarCharResponse();
		String valor = jedisConnection.getValue(key);
		response.setValorOriginal(valor);
		valor.replaceAll(character, "");
		response.setCharRemplazado(character);
		response.setResultado(valor);

		return ResponseEntity.ok(response);
	}
}