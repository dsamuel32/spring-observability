package br.com.observability.app.home.controller;

import br.com.observability.app.home.response.HomeResponse;
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
public class HomeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HomeResponse getHomeInfo() {
        return new HomeResponse("Running...");
    }

}
