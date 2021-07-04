package com.example.jazs20158nbp.service;

import com.example.jazs20158nbp.model.NBPResponse;
import com.example.jazs20158nbp.model.Rate;
import com.example.jazs20158nbp.model.Szekle;
import com.example.jazs20158nbp.repository.NBPResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.jazs20158nbp.model.Metal.Zloto;

@Service
public class NBPResponseService {

    private final RestTemplate restTemplate;
    private final NBPResponseRepository nbpResponseRepository;

    public NBPResponseService(RestTemplate restTemplate, NBPResponseRepository nbpResponseRepository) {
        this.restTemplate = restTemplate;
        this.nbpResponseRepository = nbpResponseRepository;
    }

//    public NBPResponse getCourse(LocalDate startDate, LocalDate endDate) {
//        NBPResponse nbpResponse = new NBPResponse(1L, Zloto, startDate, endDate, 2.45, LocalDateTime.now());
//        return nbpResponseRepository.save(nbpResponse);
//    }

    public NBPResponse getCorrectCourse(LocalDate startDate, LocalDate endDate) {
        String url = "http://api.nbp.pl/api/cenyzlota/" + startDate + "/" + endDate + "/";
        Szekle szekle = restTemplate.getForObject(url, Szekle.class);
        double average = calculate(szekle.getRates());
        NBPResponse nbpResponse = new NBPResponse(Zloto, startDate, endDate, average, LocalDateTime.now());
        return nbpResponseRepository.save(nbpResponse);
    }

    public float calculate(List<Rate> rateList) {
        return (float) rateList.stream()
                .mapToDouble(Rate::getCena)
                .average()
                .orElse(0.0d);
    }
}
