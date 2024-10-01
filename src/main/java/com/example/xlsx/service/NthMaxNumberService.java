package com.example.xlsx.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

@Service
public class NthMaxNumberService {
    public Integer findNthMaxNumber(String filePath, int n) {
        Queue<Integer> minHeap = new PriorityQueue<>(n);
        Set<Integer> uniqueNumbers = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                int number = (int) row.getCell(0).getNumericCellValue();
                if (uniqueNumbers.add(number)) {
                    if (minHeap.size() < n) {
                        minHeap.offer(number);
                    } else if (number > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(number);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return minHeap.size() == n ? minHeap.peek() : null;
    }
}
