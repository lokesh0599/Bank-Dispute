package DisputeIQ.DisputeIQ.Config;

import DisputeIQ.DisputeIQ.Dto.TransactionEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic disputeTopic(){
        return TopicBuilder.name("dispute-created")
                .partitions(3)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic transactionTopic(){
        return TopicBuilder.name("transaction-created")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public ProducerFactory <String, TransactionEvent> producerFactory(){
        Map<String, Object> config = new HashMap<>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );
        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );
        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JacksonJsonSerializer.class
        );
        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public KafkaTemplate<String, TransactionEvent> KafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}

