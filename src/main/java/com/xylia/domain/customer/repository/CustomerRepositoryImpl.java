package com.xylia.domain.customer.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import com.xylia.domain.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomerRepositoryImpl extends ResourceRepositoryBase<Customer, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124);
    private Map<Long, Customer> customers = new HashMap<>();

    protected CustomerRepositoryImpl() {
        super(Customer.class);

        customers.put(ID_GENERATOR.get(), new Customer(ID_GENERATOR.get(), "This is a new customer!"));

    }

    @Override
    public ResourceList<Customer> findAll(QuerySpec querySpec) {
        return querySpec.apply(customers.values());
    }
}
