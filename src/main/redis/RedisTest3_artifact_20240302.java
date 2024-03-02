package main.redis;

import redis.clients.jedis.Jedis;

//import redis.clients.jedis.Jedis;

public class RedisTest3_artifact_20240302 {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		
		Jedis jedisLocal=new Jedis();
		
		//jedisLocal.
		
		
		byte[] keyBytes=new byte[12];
		byte[] valueBytes=new byte[12];
		keyBytes[0]='a';
		keyBytes[1]=2;
		keyBytes[2]='2';
		
		valueBytes[0]='b';
		valueBytes[1]=3;
		valueBytes[2]='3';
		
		jedisLocal.set(keyBytes, valueBytes);
		
		String keyStr=new String();
		String valueStr=new String();
		keyStr="test-20240302-+-+-key";
		valueStr="test-20240302-+-+-value";
		jedisLocal.set(keyStr, valueStr);
		
		jedisLocal.close();
		
		System.out.println("output one key >>>>> [key] test-20240302-+-+-key"
				+ " , [VALUE] "+jedisLocal.get("test-20240302-+-+-key"));
	}

}
