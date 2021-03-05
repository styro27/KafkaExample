package io.fraud.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;

import javax.rmi.CORBA.ValueHandler;

public class KafkaRecord {

    private final ConsumerRecord<String, String> record;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaRecord(ConsumerRecord<String, String> record) {
        this.record = record;
    }

    public boolean hasSourceId(String message) {
        return record.value().contains(message);
    }

    @SneakyThrows
    public <T> T valueAsClass(Class<T> tClass) {
        return objectMapper.readValue(record.value(), tClass);
    }
}
