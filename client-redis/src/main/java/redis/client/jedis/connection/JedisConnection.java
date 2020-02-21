package redis.client.jedis.connection;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author mkraitman
 *
 *         operaciones para consulta de datos de Jedis
 */

public class JedisConnection {

	public String getValue(String key) {
		String value = null;
		try (Jedis jedis = Pool.getResource()) {
			value = jedis.get(key);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void setKey(String key, String value) {

		try (Jedis jedis = Pool.getResource()) {
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
