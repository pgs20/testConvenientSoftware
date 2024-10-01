package com.example.xlsx.controller;
import com.example.xlsx.service.NthMaxNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NthMaxNumberControllerTest {
    @InjectMocks
    private NthMaxNumberController nthMaxNumberController;

    @Mock
    private NthMaxNumberService nthMaxNumberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetNthMaxNumber() {
        String filePath = "dummyPath";
        int n = 2;
        when(nthMaxNumberService.findNthMaxNumber(filePath, n)).thenReturn(200);

        Integer result = nthMaxNumberController.getNthMaxNumber(filePath, n);

        assertEquals(200, result);
    }

    @Test
    public void testGetNthMaxNumberWhenNotFound() {
        String filePath = "dummyPath";
        int n = 5;
        when(nthMaxNumberService.findNthMaxNumber(filePath, n)).thenReturn(null);

        Integer result = nthMaxNumberController.getNthMaxNumber(filePath, n);

        assertNull(result);
    }
}
