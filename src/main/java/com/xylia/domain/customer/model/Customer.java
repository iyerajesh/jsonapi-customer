package com.xylia.domain.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonApiResource(type = "customer")
public class Customer {

    public Customer(Long customerId, String content) {
        this.id = customerId;
        this.content = content;
    }

    @JsonApiId
    private Long id;

    @JsonProperty
    private String content;

}
