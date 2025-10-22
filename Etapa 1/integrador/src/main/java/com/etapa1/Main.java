package com.etapa1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

public static void main(String[] args) throws FileNotFoundException, IOException {
        String rutaExcel = "C:\\Users\\u608147\\OneDrive - Telecom Argentina SA\\Desktop\\Ejemplos java\\integrador\\Etapa 1\\reporte_automatizacion.xlsx";
        String rutaPDF = "resumen_resultados.pdf";
        ReportAnalyzer.analizarExcel(rutaExcel);
        PDFResumen.crear(rutaPDF, ReportAnalyzer.total, ReportAnalyzer.passed, ReportAnalyzer.failed, ReportAnalyzer.passRate,
                ReportAnalyzer.failRate, ReportAnalyzer.timeAvg, ReportAnalyzer.timeTotal,
                ReportAnalyzer.slowest, ReportAnalyzer.fastest, ReportAnalyzer.filasErrores);
    }    
    
}
