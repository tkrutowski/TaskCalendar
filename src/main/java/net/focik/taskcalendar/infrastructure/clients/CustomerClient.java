package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.infrastructure.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
class CustomerClient {

    private RestTemplate restTemplate = new RestTemplate();

    //TODO dodać stałą z propertisów
    private static final String URI = "http://localhost:8081/api/customer/";

    public Optional<CustomerDto> findById(Integer id) {
        CustomerDto customerDto = null;
        try {
            customerDto = restTemplate.getForObject(URI + id, CustomerDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek albo legger error
            return Optional.empty();
        }

        return Optional.ofNullable(customerDto);
    }
}
