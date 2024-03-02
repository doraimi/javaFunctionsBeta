package main.redis.bitMapAndCounter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Jedis;

public class BitmapCounterExample {
    private static final byte[] COUNTER_KEY = "counter".getBytes();

    public static void main(String[] args) {
        // 连接到 Redis 服务
        Jedis jedis = new Jedis();//"localhost");

        // 将计数器初始化为 0
        jedis.set(COUNTER_KEY, "0".getBytes());

        // 增加计数器的值
        increaseCounter(jedis);
        increaseCounter(jedis);
        increaseCounter(jedis);

        // 获取计数器的值并打印
        byte[] counterValue = jedis.get(COUNTER_KEY);
        counterValue[0]=(byte) (counterValue[0]+49);
        System.out.println("Counter value: " + new String(counterValue)); // 应该输出：Counter value: 3

        // 关闭连接
        jedis.close();
    }

    private static void increaseCounter(Jedis jedis) {
        // 获取当前计数器值
        byte[] currentValue = jedis.get(COUNTER_KEY);

        // 将当前计数器值解析为整数并增加 1
        //int newValue = Integer.parseInt(new String(currentValue)) + 1;
        byte newValue = currentValue[0]++;

        // 将增加后的计数器值转换为二进制字符串
        String binaryValue = Integer.toBinaryString(newValue);

        // 更新位图中对应的位
        for (int i = 0; i < binaryValue.length(); i++) {
            char bit = binaryValue.charAt(i);
            jedis.setbit(COUNTER_KEY, i, bit == '1');
        }
    }
}
