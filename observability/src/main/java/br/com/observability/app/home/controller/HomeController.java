package br.com.observability.app.home.controller;

import br.com.observability.app.home.response.HomeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "v1/home",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class HomeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HomeResponse getHomeInfo() {
        //https://www.baeldung.com/java-application-logs-to-elastic-stack
        //https://ridwanfajar.medium.com/send-your-container-logs-to-elk-elasticsearch-logstash-and-kibana-with-gelf-driver-7995714fbbad
        log.info("Getting info");
        return new HomeResponse("Running...");
    }

}
