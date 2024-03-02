package main.redis.bitMapAndCounter;
import redis.clients.jedis.Jedis;
import java.time.LocalDate;
import java.util.BitSet;
import redis.clients.jedis.Jedis;
import java.time.LocalDate;
import java.util.BitSet;


public class UserActivityBitMapExample {
	    private final static String ONLINE_STATUS_KEY = "user:online";
	    private final static String ACTIVITY_KEY_PREFIX = "user:activity:";
	    private final static int TOTAL_DAYS = 1;//30; // 记录用户活跃度的天数

	    public static void main(String[] args) {
	        // 连接到 Redis 服务
	        Jedis jedis = new Jedis();//"localhost");

	        // 设置用户在线状态
	        setUserOnline(jedis, "user1");
	        setUserOnline(jedis, "user2");
	        setUserOffline(jedis, "user1");

	        // 更新用户活跃度
	        updateUserActivity(jedis, "user1");
	        updateUserActivity(jedis, "user2");

	        // 获取用户活跃度
	        for (int i = 0; i < TOTAL_DAYS; i++) {
	            LocalDate date = LocalDate.now().minusDays(i);
	            int activity1 = getUserActivity(jedis, "user1", date);
	            System.out.println("User1 activity on " + date + ": " + activity1);
	            
	            int activity2 = getUserActivity(jedis, "user2", date);
	            System.out.println("User2 activity on " + date + ": " + activity2);
	        }

	        // 关闭连接
	        jedis.close();
	    }

	    // 设置用户在线状态为在线
	    private static void setUserOnline(Jedis jedis, String userId) {
	        jedis.setbit(ONLINE_STATUS_KEY, getUserId(userId), true);
	    }

	    // 设置用户在线状态为离线
	    private static void setUserOffline(Jedis jedis, String userId) {
	        jedis.setbit(ONLINE_STATUS_KEY, getUserId(userId), false);
	    }

	    // 更新用户活跃度
	    private static void updateUserActivity(Jedis jedis, String userId) {
	        LocalDate currentDate = LocalDate.now();
	        String activityKey = getActivityKey(userId, currentDate);
	        jedis.setbit(activityKey, currentDate.getDayOfMonth() - 1, true);
	    }

	    // 获取用户某一天的活跃度
	    private static int getUserActivity(Jedis jedis, String userId, LocalDate date) {
	        String activityKey = getActivityKey(userId, date);
	        BitSet bitSet = BitSet.valueOf(jedis.get(activityKey.getBytes()));
	        return bitSet.cardinality();
	    }

	    // 获取用户 ID 对应的位图偏移量
	    private static long getUserId(String userId) {
	        return Long.parseLong(userId.substring(4)); // 假设用户 ID 格式为 "userX"
	    }

	    // 获取用户某一天的活动记录的键
	    private static String getActivityKey(String userId, LocalDate date) {
	        return ACTIVITY_KEY_PREFIX + userId + ":" + date.toString();
	    }
	}
