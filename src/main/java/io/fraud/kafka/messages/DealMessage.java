package io.fraud.kafka.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DealMessage {
    @JsonProperty("date")
    private String date;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currency")
    private String currency;
    // etc.
}
