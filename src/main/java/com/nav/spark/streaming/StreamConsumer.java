package com.nav.spark.streaming;

/**
 * Created by Neo on 3/6/2017.
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StreamConsumer {
        public static void main(String[] args) {

                Map<String, Object> kafkaParams = new HashMap<>();
                kafkaParams.put("bootstrap.servers", "localhost:9092");
                kafkaParams.put("key.deserializer", StringDeserializer.class);
                kafkaParams.put("value.deserializer", StringDeserializer.class);
                kafkaParams.put("group.id", "use_a_separate_group_id_for_each_stream");
                kafkaParams.put("auto.offset.reset", "latest");
                kafkaParams.put("enable.auto.commit", false);

                Collection<String> topics = Arrays.asList("test");

                SparkConf conf = new SparkConf().setAppName("streamTest").setMaster("localhost");
                JavaStreamingContext streamingContext = new JavaStreamingContext(conf, new Duration(1000));

                final JavaInputDStream<ConsumerRecord<String, String>> stream =
                        KafkaUtils.createDirectStream(
                                streamingContext,
                                LocationStrategies.PreferConsistent(),
                                ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
                        );

                stream.mapToPair(
                        new PairFunction<ConsumerRecord<String, String>, String, String>() {
                                @Override
                                public Tuple2<String, String> call(ConsumerRecord<String, String> record) {
                                        return new Tuple2<>(record.key(), record.value());
                                }
                        });
        }

}
