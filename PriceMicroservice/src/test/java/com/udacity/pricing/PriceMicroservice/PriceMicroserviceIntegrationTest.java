package com.udacity.pricing.PriceMicroservice;

import com.udacity.pricing.PriceMicroservice.api.PricingController;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceMicroserviceIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PricingController controller;

    @Test
    public void contextLoads() throws Exception {
        org.assertj.core.api.Assertions.assertThat(controller).isNotNull();
    }

    @Test
    public void checkInitialisationOfPriceMap() throws JSONException {
        for (int i = 1; i <= 20; i++) {
            String url = "http://localhost:" + port + "/services/price?vehicleId=" + i;
            ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);

            assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

            String expected = "{vehicleId:" + i + ",currency:USD}";
            JSONAssert.assertEquals(expected, response.getBody(), false);
        }
    }

    @Test
    public void checkAvailabilityOfDirectRestAPI() {
        String url = "http://localhost:" + port + "/prices/";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
