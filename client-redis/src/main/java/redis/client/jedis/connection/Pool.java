package redis.client.jedis.connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.client.model.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author mkraitman
 *
 *         El objetivo es guardar el Pool de conexiones de Jedis y pedirle a él
 *         las conexiones cuando las necesitemos
 */

public class Pool {

	static ApplicationContext contexto = new ClassPathXmlApplicationContext("RedisConfig.xml");
	static RedisConfig config = (RedisConfig) contexto.getBean("RedisConfig");

	private static String host = config.getHost();
	private static int port = config.getPort();

	private static JedisPool pool = new JedisPool(host, port);

	public static Jedis getResource() {
		return pool.getResource();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static JedisPool getPool() {
		return pool;
	}

	public static void setPool(JedisPool pool) {
		Pool.pool = pool;
	}

}
