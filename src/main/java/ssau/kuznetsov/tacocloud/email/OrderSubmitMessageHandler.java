package ssau.kuznetsov.tacocloud.email;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ssau.kuznetsov.tacocloud.models.Order;

import java.util.Map;

@Component
public class OrderSubmitMessageHandler
        implements GenericHandler<Order> {

    private final RestTemplate rest;
    private final ApiProperties apiProps;

    public OrderSubmitMessageHandler(
            ApiProperties apiProps, RestTemplate rest) {

        this.apiProps = apiProps;
        this.rest = rest;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public Object handle(Order order, Map<String, Object> headers) {
        rest.postForObject(apiProps.getUrl(), order, String.class);
        return null;
    }
}
