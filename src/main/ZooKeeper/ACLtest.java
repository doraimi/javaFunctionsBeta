package main.ZooKeeper;

import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import java.util.ArrayList;
import java.util.List;

public class ACLtest {
    public static void main(String[] args) {
        // 创建 ACL 列表
        List<ACL> acl = new ArrayList<>();

        // 创建 ID 为 "anyone" 的 ACL 条目，并设置权限为 ALL
        Id id = new Id("world", "anyone");
        acl.add(new ACL(ZooDefs.Perms.ALL, id));

        // 打印 ACL 列表
        System.out.println("ACL list: " + acl);
    }
}