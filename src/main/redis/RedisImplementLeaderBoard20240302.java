package main.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisImplementLeaderBoard20240302 {
	private final static String LEADBOARD_KEY="Leader Board";
	public static void main(String[] args) {
		Jedis jedis=new Jedis();
		jedis.zadd(LEADBOARD_KEY, 85, "yang");
		jedis.zadd(LEADBOARD_KEY, 95, "li");
		jedis.zadd(LEADBOARD_KEY, 50, "Liu");
		jedis.zadd(LEADBOARD_KEY, 87, "he");
		
		jedis.zincrby(LEADBOARD_KEY, 100, "yang");
		
		Set<String> leaderBoard=jedis.zrevrange(LEADBOARD_KEY, 0, -1);
		System.out.println("Leader Board");
		int rank=1;
		for(String player: leaderBoard) {
			Double score=jedis.zscore(LEADBOARD_KEY, player);
			System.out.println(rank +". "+player+ " : "+score.intValue());
			rank++;
		}
		jedis.close();
		
		
	}
}
