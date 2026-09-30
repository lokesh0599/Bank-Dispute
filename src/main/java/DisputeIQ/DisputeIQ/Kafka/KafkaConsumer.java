package DisputeIQ.DisputeIQ.Kafka;

import DisputeIQ.DisputeIQ.Dto.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    @KafkaListener(
            topics = "transection-created",
            groupId = "notification-group"
    )
    public void consume(TransactionEvent event){
        System.out.println("Transection received: " + event.getTxnId());
    }


}
