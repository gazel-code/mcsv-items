package house.microservicio_items;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // CONFIGURANDO ENDPOINT EN PROPERTIES
    @Value("${config.baseurl.endpoint.microservicio-products}")
    private String url;

    @Bean
    @LoadBalanced
    WebClient.Builder webClient(){
//        return WebClient.builder().baseUrl("http://microservicio-products");
        return WebClient.builder().baseUrl(url);
    }
}
