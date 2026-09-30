package DisputeIQ.DisputeIQ.Kafka;

import DisputeIQ.DisputeIQ.Dto.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, TransactionEvent > kafkaTemplate;

    public void sendTransection(TransactionEvent event){
        kafkaTemplate.send("DisputeTopic", event);

        LOGGER.info("Sent transaction event to DisputeTopic: {}", event);
    }

}
