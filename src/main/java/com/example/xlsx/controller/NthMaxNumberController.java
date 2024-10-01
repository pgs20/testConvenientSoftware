package com.example.xlsx.controller;

import com.example.xlsx.service.NthMaxNumberService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name="N-th maximum number search controller")
public class NthMaxNumberController {
    private final NthMaxNumberService numberService;

    public NthMaxNumberController(NthMaxNumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/max-number")
    public Integer getNthMaxNumber(@RequestParam @Parameter(description = "Path to file") String filePath,
                                   @RequestParam @Parameter(description = "N-e maximum number") int n) {
        return numberService.findNthMaxNumber(filePath, n);
    }
}
