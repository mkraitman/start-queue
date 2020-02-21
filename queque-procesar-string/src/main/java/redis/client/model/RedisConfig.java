package redis.client.model;

/**
 * 
 * @author mkraitman
 *
 *         Clase basica para configurar la conexion al servidor Redis
 */
public class RedisConfig {

	private String host;
	private int port;

	/**
	 * 
	 * @param host host del servidor de Redis
	 * @param key  puerto del servidor de Redis
	 */
	public RedisConfig(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public RedisConfig() {
		super();
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

}
