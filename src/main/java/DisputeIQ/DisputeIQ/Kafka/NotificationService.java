package DisputeIQ.DisputeIQ.Kafka;

import DisputeIQ.DisputeIQ.Dto.TransactionEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendTransectionNotification(TransactionEvent event) {

        System.out.println("Transection notification received successfully");

        System.out.println("To: " + event.getEmail());

        System.out.println("Transection ID: " + event.getTxnId());

        System.out.println("Amount: " + event.getAmount());

        System.out.println("Status: " + event.getStatus());

        System.out.println("Your transection was created successfully");
    }
}
