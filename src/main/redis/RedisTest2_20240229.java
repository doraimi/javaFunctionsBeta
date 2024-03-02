package redis;

/**
首先，您需要在 Maven 或 Gradle 中添加 Redis 客户端库的依赖，例如 Jedis：
xml
Copy code
<!-- Maven 依赖 -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.7.0</version>
</dependency>


这个示例代码连接到本地运行的 Redis 服务器，默认使用 6379 端口。
然后，它存储一个键值对，获取该键的值并打印，最后删除该键。
您可以根据需要修改代码来执行其他操作，如设置过期时间、使用哈希、列表、集合等数据结构，
以及使用事务、管道等高级功能。

 * 
 * 
 * 
 */
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Connection;
public class RedisTest2_20240229 {
    public static void main(String[] args) {
    	

//    	public class TestRedis {
//   	    public static void main(String[] args) {
    	        //Jedis jedis = new Jedis("redis://default:eRaFA2VSrQmkhMnfuwKmYW3gfWquOFEi@redis-18175.c1.asia-northeast1-1.gce.cloud.redislabs.com:18175");
    	        Jedis jedis = new Jedis();
    	        //Connection connection = jedis.getConnection();
    	 //   }
    //	}
    	
    	
        // 连接 Redis 服务器（默认端口为 6379）
        //Jedis jedis = new Jedis();
        //"localhost");//:6379");
        //Jedis jedis = new Jedis("127.0.0.1");
        
        // 向 Redis 中存储一个键值对
        jedis.set("key1", "value1");
        jedis.set("key2", "value2");
        jedis.setex("key1000secconds", 1000, "1000 seconds");
        jedis.setex("key1000,000seconds", 1000000, "1000,000 seconds");
        
        jedis.setex("key-10-seconds", 10, "10 seconds");
        jedis.setex("key-5-min", 60*5, "60*5 seconds");
        jedis.setex("key-5-hour", 60*60*5, "60*60*5 seconds");
        jedis.setex("key-5-day", 60*60*5*24, "60*60*5*24 seconds");
        jedis.setex("key-5-month", 60*60*5*24*30, "60*60*5*24*30 seconds");
        
        jedis.setex("keyBeta-10-seconds", 10, "10 seconds");
        jedis.setex("keyBeta-5-min", 60*5, "60*5 seconds");
        jedis.setex("keyBeta-5-hour", 60*60*5, "60*60*5 seconds");
        jedis.setex("keyBeta-5-day", 60*60*5*24, "60*60*5*24 seconds");
        jedis.setex("keyBeta-5-month", 60*60*5*24*30, "60*60*5*24*30 seconds");
        
        
        jedis.set("key3", "value is OK HAHAHA");//RUN FIRST :  ./redis-cli.exe
        
        // 从 Redis 中获取一个键对应的值
        String value="";
         Map<String, String> tmp = jedis.hgetAll("aHashTest20240229");
        System.out.println("Value of aHashTest20240229: " + tmp);
        value = jedis.get("key2");
        System.out.println("Value of key2: " + value);
         value = jedis.get("key3");
        System.out.println("Value of key3: " + value);
        
        // 删除一个键值对
        jedis.del("key1");
        
        // 关闭 Redis 连接
        jedis.close();
    }
}
