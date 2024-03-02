package kafkaTester;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;

/**
 * Kafka 是一个分布式的流式数据平台，用于构建实时数据管道和流处理应用程序。
 * 它是一个高性能、持久化的消息队列系统，设计用于处理大规模的实时数据流。
 * Kafka 的特点包括高吞吐量、持久性、可水平扩展性、容错性和低延迟等。
 * 它支持发布订阅模式，数据被分区和复制到多个 Kafka 服务器上，以提供高可用性和可靠性。
 * 主要用途包括日志和事件数据收集、消息传递、流式处理、实时数据分析等。
 * Kafka 在大数据领域和实时数据处理领域广泛应用，成为构建数据流处理架构的重要组件之一。
 */
public class KafkaProducerExample {
    public static void main(String[] args) {
        String topicName = "test-topic";
        String tail="";
        if(args.length>0)
        	tail=args[0];
        String message = "Hello, Kafka! this is producer change at 20240228 ~~~ ///  "+tail;

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, message);
        producer.send(record);
        //producer.
        producer.close();
    }
}
