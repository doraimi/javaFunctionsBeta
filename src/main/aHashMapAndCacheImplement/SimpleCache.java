package main.aHashMapAndCacheImplement;


import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
    private Map<String, Object> cacheMap;
    
    public SimpleCache() {
        cacheMap = new HashMap<>();
    }
    
    // 将数据放入缓存
    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }
    
    // 从缓存中获取数据
    public Object get(String key) {
        return cacheMap.get(key);
    }
    
    // 从缓存中移除数据
    public void remove(String key) {
        cacheMap.remove(key);
    }
    
    // 清空缓存
    public void clear() {
        cacheMap.clear();
    }
    
    // 获取缓存大小
    public int size() {
        return cacheMap.size();
    }
    
    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache();
        
        // 将数据放入缓存
        cache.put("name", "Alice");
        cache.put("age", 30);
        cache.put("city", "New York");
        
        // 从缓存中获取数据
        System.out.println("Name: " + cache.get("name"));  // 输出：Name: Alice
        System.out.println("Age: " + cache.get("age"));    // 输出：Age: 30
        System.out.println("City: " + cache.get("city"));  // 输出：City: New York
        
        // 移除缓存中的数据
        cache.remove("age");
        System.out.println("Age: " + cache.get("age"));    // 输出：Age: null
        
        // 清空缓存
        cache.clear();
        System.out.println("Cache size: " + cache.size());  // 输出：Cache size: 0
    }
}
