package com.etapa1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ReportAnalyzer {
    public static int total = 0;
    public static int passed = 0;
    public static int failed = 0;
    public static float passRate = 0;
    public static float failRate = 0;
    public static float timeAvg = 0;
    public static float timeTotal = 0;
    public static int slowest = 0;
    public static int fastest = 0;
    public static List<Integer> filasErrores = new ArrayList<>();

    // analiza el archivo excel y cuenta los estados
    public static void analizarExcel(String ruta) throws FileNotFoundException, IOException {
        total = passed = failed = slowest = fastest = 0;
        passRate = failRate = timeAvg = 0;
        //List<Integer> filasErrores = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(ruta);
                Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet hoja = workbook.getSheetAt(0);
            boolean primera = true;
            for (Row fila : hoja) {
                // saltar la primera fila (encabezados) la 1ra vez que cicla el for
                if (primera) {
                    primera = false;
                    continue;
                }
                // columna 3: estado
                Cell cEstado = fila.getCell(2);
                if (cEstado == null){
                    filasErrores.add(fila.getRowNum() + 1); // +1 para ajustar al número de fila real en Excel
                    continue;
                    }
                String estado = aString(cEstado).trim();
                if (estado.isEmpty())
                    continue;
                total++;
                if (estado.equalsIgnoreCase("PASSED"))
                    passed++;
                else if (estado.equalsIgnoreCase("FAILED"))
                    failed++;
                else {
                    filasErrores.add(fila.getRowNum() + 1); // +1 para ajustar al número de fila real en Excel
                    System.out.println("Estado desconocido en fila " + (fila.getRowNum() + 1) + ": " + estado);
                    continue;
                }

                // columna 4: tiempo
                Cell cTiempo = fila.getCell(3);
                if (cTiempo == null) {
                    filasErrores.add(fila.getRowNum() + 1); // +1 para ajustar al número de fila real en Excel
                    continue;
                }
                String tiempoStr = aString(cTiempo).trim();
                if (tiempoStr.isEmpty()) {
                    filasErrores.add(fila.getRowNum() + 1); // +1 para ajustar al número de fila real en Excel
                    continue;
                }
                int tiempo = (int) Float.parseFloat(tiempoStr);
                timeTotal += tiempo;
                if (slowest == 0 || tiempo > slowest)
                    slowest = tiempo;
                
                if (fastest == 0 || tiempo < fastest)
                    fastest = tiempo;   

            }
            // calcular tasas
            if (total > 0) {
                passRate = (passed * 100.0f) / total;
                failRate = (failed * 100.0f) / total;
            }
            timeAvg = total > 0 ? timeTotal / total : 0;
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // convierte el contenido de una celda a String
    private static String aString(Cell celda) {
        if (celda == null)
            return "";
        return switch (celda.getCellType()) {
            case STRING -> celda.getStringCellValue();
            case NUMERIC -> String.valueOf(celda.getNumericCellValue());
            case BOOLEAN -> String.valueOf(celda.getBooleanCellValue());
            default -> "";
        };
    }
}
