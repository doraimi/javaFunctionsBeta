package main.redis.bitMapAndCounter;

import java.util.BitSet;

import org.apache.zookeeper.server.util.BitMap;

import redis.clients.jedis.Jedis;

public class BitSetAndBitMapArtifact20240302 {
	
    private static void flipAllBits(BitSet bitSet) {
        // 对 BitSet 中的每一位进行取反操作
    	int ssize=bitSet.length();
    	System.out.println(ssize);
        for (int i = 0; i < ssize; i++) {
            bitSet.flip(i);
        }
    }
    
    public static void main(String[] args) {
        // 创建一个 BitSet 对象
        BitSet bitSet = new BitSet(8);

        // 设置一些位为 true
        bitSet.set(0);
        System.out.println("STEP1:"+bitSet.cardinality());
        bitSet.set(2);
        System.out.println("STEP1:"+bitSet.cardinality());
        bitSet.set(4);
        System.out.println("STEP1:"+bitSet.cardinality());
        bitSet.set(6);
        System.out.println("STEP1:"+bitSet.cardinality());
        bitSet.set(7);
        System.out.println("STEP1:"+bitSet.cardinality());
        
        BitMap bitMap=new BitMap();
        
        Jedis jedis = new Jedis();
        String key="BitMap_TEST";
		long offset=1;
		boolean value=false;
		jedis.setbit(key, offset, value);
		jedis.setbit(key, 1, true);
		jedis.setbit(key, 2, true);
		jedis.setbit(key, 3, false);
		jedis.setbit(key, 0, true);
		jedis.setbit(key, 7, true);
		jedis.setbit(key, 6, true);
		jedis.getbit(key, 1);
		System.out.println("jedis.getbit(key, 1): "+jedis.getbit(key, 1));
		System.out.println("jedis.get(key): "+jedis.get(key));
		//jedis.setbit(key, offset, value);
        
        //bitMap.add(1);
        
        

        // 统计 BitSet 中置位的数量
        //int count = bitSet.cardinality();
        //System.out.println("Number of set bits: " + count); // 输出：Number of set bits: 5
        System.out.println(bitSet);
     // 对 BitSet 中的每一位进行取反操作
        flipAllBits(bitSet);
        System.out.println(bitSet);
        //for(int i=0;i<8;i++) {
        //	System.out.println(bitSet.get(i));
        //}
    }
}
