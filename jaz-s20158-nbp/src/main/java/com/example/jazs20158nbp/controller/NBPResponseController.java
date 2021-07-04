package com.example.jazs20158nbp.controller;

import com.example.jazs20158nbp.model.NBPResponse;
import com.example.jazs20158nbp.service.NBPResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/gold")
public class NBPResponseController {

    private final NBPResponseService nbpResponseService;

    public NBPResponseController(NBPResponseService nbpResponseService) {
        this.nbpResponseService = nbpResponseService;
    }

    @ApiOperation(value = "Get gold course from specific period of time",
            response = NBPResponse.class,
            notes = "This method will return counted average course of gold from specific period of time")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Incorrect request or response longer than 93 days"),
            @ApiResponse(code = 404, message = "Information not found"),
            @ApiResponse(code = 500, message = "Unexpected error")
    })
    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<NBPResponse> getCourseFromDates(
            @ApiParam(name = "starDate",
                        type = "LocalDate",
                        value = "Date from which moment you would like to know course",
                        example = "2021-01-01",
                        required = true,
                        defaultValue = "2021-01-01")
            @PathVariable LocalDate startDate,
            @ApiParam(name = "endDate",
                        type = "LocalDate",
                        value = "Date to which moment you would like to know course",
                        example = "2021-01-02",
                        required = true,
                        defaultValue = "2021-01-02")
            @PathVariable LocalDate endDate) {
        return ResponseEntity.ok(nbpResponseService.getCorrectCourse(startDate, endDate));
    }
}
