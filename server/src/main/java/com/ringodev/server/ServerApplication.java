package com.ringodev.server;

import com.ringodev.server.data.tournaments.Event;
import com.ringodev.server.data.tournaments.TournamentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class ServerApplication {
    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate, TournamentRepository repository) throws Exception {
//        return args -> {
//            //"M.DOUBLES","W.DOUBLES"
//            String[] str = {"M.SINGLES","W.SINGLES"};
//            for (String s : str) {
//                Event[] event = restTemplate.getForObject(
//                        "https://results.ittf.com/ittf-web-results/html/TTE5146/brackets/" + s + "-----------.json", Event[].class);
//
//                assert event != null;
//                log.info(event[0].toString());
//            }
//        };
//    }

}
