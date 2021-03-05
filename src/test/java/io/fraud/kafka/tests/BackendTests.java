package io.fraud.kafka.tests;

import io.fraud.kafka.KafkaService;
import io.fraud.kafka.KafkaRecord;
import io.fraud.kafka.messages.DealMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BackendTests {
private final KafkaService kafkaservice = new KafkaService("46.101.107.224:9092");
    @Test
    public void testCanWriteMessageToQueingTransaction() {
        kafkaservice.subscribe("test");
        kafkaservice.send("test","Hello");
        KafkaRecord receivedRecords = kafkaservice.waitForMessage("Hello");
        assertThat(receivedRecords).isNotNull();
    }

    @Test
    void testApplicationCanProcessValidMessage() {
        kafkaservice.subscribe("test");
        kafkaservice.send("test","Hello java");
        KafkaRecord receivedRecords = kafkaservice.waitForMessage("Hello java");
        DealMessage dealMessage = receivedRecords.valueAsClass(DealMessage.class);
        assertThat(dealMessage.getAmount()).isEqualTo(900.0);
    }
}
