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

/**
 * Redis 是一个开源的内存数据库，也被称为数据结构服务器，
 * 它支持多种数据结构，如字符串、哈希、列表、集合、有序集合等。
 * Redis 的特点包括高性能、持久化、复制、发布订阅、事务等功能。
 * 主要用途包括缓存、会话存储、消息队列、实时数据处理等。
 * 由于其快速的内存访问和丰富的数据结构，
 * Redis 在需要快速响应和高并发读写的场景中非常受欢迎。
 * 
 * 总的来说，Redis 和 Kafka 都是非常强大和流行的开源软件，它们在不同的领域和场景中有着广泛的应用。
 * Redis 适用于缓存、会话存储和消息队列等场景，
 * 而 Kafka 则适用于构建实时数据管道和流式处理应用程序。
 */
// CAN WORK NOW 20240228
public class RedisExample {
    public static void main(String[] args) {
        // 连接 Redis 服务器（默认端口为 6379）
        Jedis jedis = new Jedis();
        //"localhost");//:6379");
        //Jedis jedis = new Jedis("127.0.0.1");
        
        // 向 Redis 中存储一个键值对
        jedis.set("key1", "value1");
        jedis.set("key2", "value2");
        jedis.set("key3", "value is OK HAHAHA");//RUN FIRST :  ./redis-cli.exe
        
        // 从 Redis 中获取一个键对应的值
        String value = jedis.get("key1");
        System.out.println("Value of key1: " + value);
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
