package pl.codepot.prezentatr.service

import com.nurkiewicz.asyncretry.RetryExecutor
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.codepot.prezentatr.dto.IngredientTypes
import pl.codepot.prezentatr.dto.Order

import static com.netflix.hystrix.HystrixCommand.Setter.withGroupKey
import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey

@Component
public class IngredientService {

    private final ServiceRestClient serviceRestClient;
    private final RetryExecutor retryExecutor;

    @Autowired
    public IngredientService(ServiceRestClient serviceRestClient, RetryExecutor retryExecutor) {
        this.serviceRestClient = serviceRestClient;
        this.retryExecutor = retryExecutor;
    }

    Order getIngredients(IngredientTypes ingredientTypes) {
        return serviceRestClient.forService("aggregatr-red")
                .retryUsing(retryExecutor)
                .post()
                .withCircuitBreaker(withGroupKey(asKey("hystrix_group")))
                .onUrl("/ingredients")
                .body("{\"items\":[\"MALT\",\"WATER\",\"HOP\",\"YIEST\"]}")
                .withHeaders().contentType("application/vnd.pl.codepot.aggregatr.v1+json")
                .andExecuteFor()
                .anObject()
                .ofType(Order.class)
    }
}

