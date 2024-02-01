package com.example.test_spring;

import com.example.test_spring.fastExcel.FastexcelHelper;
import lombok.extern.slf4j.Slf4j;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.ReadingOptions;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class TestExcel {

    public static final String DELIMITER = ";";

    @Autowired
    private FastexcelHelper fastexcelHelper;

    @Test
    void createTestDto() {
        File file = new File("src/test/resources/1393914953ВыгрузкаОтпусков_2.csv");
        try (ReadableWorkbook wb = new ReadableWorkbook(file, new ReadingOptions(true, false))) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    BigDecimal tabNum = r.getCellAsNumber(0).orElse(null);
                    BigDecimal vacationType = r.getCellAsNumber(1).orElse(null);
                    LocalDateTime dateFrom = r.getCellAsDate(2).orElse(null);
                    LocalDateTime dateTo = r.getCellAsDate(3).orElse(null);
                    log.info(tabNum + " + " + vacationType + " + " + dateFrom + " + " + dateTo);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createExvel() {
        File file = new File("src/test/resources/1393914953ВыгрузкаОтпусков_2.csv");
        //List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                List<String> recordFromLine = getRecordFromLine(scanner.nextLine());
                log.info(recordFromLine.get(0) + " + " + recordFromLine.get(1) + " + " + recordFromLine.get(2) + " + " + recordFromLine.get(3));
                //records.add(recordFromLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    @Test
    public void whenParsingExcelFile_thenCorrect() throws IOException {

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "1393914953ВыгрузкаОтпусков_1.csv";

        Map<Integer, List<String>> data = fastexcelHelper.readExcel(fileLocation);

        assertEquals("Name", data.get(1).get(0));
        assertEquals("Age", data.get(1).get(1));

        assertEquals("John Smith", data.get(3).get(0));
        assertEquals("20", data.get(3).get(1));
    }
}
