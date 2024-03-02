package main.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.KeeperException;

public class ZooKeeperExample {

    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;
    private static final String NODE_PATH = "/abcTESTtest2024";
    private static final byte[] NODE_DATA = "Hello, doraimi 2024!".getBytes();

    public static void main(String[] args) {
        try {
            // 创建一个 ZooKeeper 实例，连接到指定的 ZooKeeper 服务器
            ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, new Watcher() {
                public void process(WatchedEvent event) {
                    // 处理连接状态变化事件
                    System.out.println("Received event: " + event);
                }
            });

            //List<ACL> acl;
            List<ACL> acl = new ArrayList<>();
            Id id = new Id("world", "anyone");
            acl.add(new ACL(ZooDefs.Perms.ALL, id));
			// 创建一个持久节点，并设置节点数据
            //String createdNodePath = zooKeeper.create(NODE_PATH, NODE_DATA, CreateMode.PERSISTENT);
            String createdNodePath = zooKeeper.create(NODE_PATH, NODE_DATA, acl, CreateMode.PERSISTENT);
            System.out.println("Created node: " + createdNodePath);

            // 读取节点数据
            byte[] nodeData = zooKeeper.getData(NODE_PATH, false, null);
            System.out.println("Node data: " + new String(nodeData));

            // 关闭 ZooKeeper 连接
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
