package com.example.xlsx.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NthMaxNumberServiceTest {

    private NthMaxNumberService service;

    @BeforeEach
    public void setUp() {
        service = new NthMaxNumberService();
    }

    @Test
    public void testFindNthMaxNumber_ValidInput() {
        String filePath = "mockFilePath.xlsx";
        Set<Integer> mockData = Set.of(7, 1, 3, 9, 2, 5, 8);

        service = Mockito.spy(service);
        doReturn(mockData).when(service).readNumbersFromFile(filePath);

        Integer result = service.findNthMaxNumber(filePath, 3);

        assertEquals(Integer.valueOf(7), result);
    }

    @Test
    public void testFindNthMaxNumber_NthGreaterThanUniqueCount() {
        String filePath = "mockFilePath.xlsx";
        Set<Integer> mockData = Set.of(1, 2, 3);

        service = Mockito.spy(service);
        doReturn(mockData).when(service).readNumbersFromFile(filePath);

        Integer result = service.findNthMaxNumber(filePath, 5);

        assertNull(result);
    }

    @Test
    public void testFindNthMaxNumber_NonExistingFile() {
        assertThrows(RuntimeException.class, () -> service.findNthMaxNumber("non_existing_file.xlsx", 1));
    }

    @Test
    public void testFindNthMaxNumber_InvalidN() {
        assertThrows(IllegalArgumentException.class, () -> service.findNthMaxNumber("mockFilePath.xlsx", 0));
        assertThrows(IllegalArgumentException.class, () -> service.findNthMaxNumber("mockFilePath.xlsx", -1));
    }
}