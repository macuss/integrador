package com.etapa1.Datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String rutaExcel = "C:\\Users\\u608147\\OneDrive - Telecom Argentina SA\\Desktop\\Ejemplos java\\integrador\\Etapa 1\\reporte_automatizacion.xlsx";
        String rutaPDF = "resumen_resultados.pdf";

        ReportAnalyzer.analizarExcel(rutaExcel);


        // Menu de selección de secciones para el PDF

        Scanner scanner = new Scanner(System.in);
        List<Integer> seleccion = new ArrayList<>();

        System.out.println("=======================================");
        System.out.println("Seleccione qué secciones incluir en el PDF:");
        System.out.println("1 - Estadísticas Generales");
        System.out.println("2 - Métricas de Tiempo");
        System.out.println("3 - Detalle de Errores");
        System.out.println("=======================================");
        System.out.print("Ingrese separados por coma las secciones para crear en el PDF (ej: 1,3): ");

        String input = scanner.nextLine().trim();
        String[] opciones = input.split(",");

        for (String op : opciones) {
            try {
                int valor = Integer.parseInt(op.trim());
                if (valor >= 1 && valor <= 3) {
                    seleccion.add(valor);
                } else {
                    System.out.println("Opción ignorada: " + valor + " (inválida)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: " + op + ". Se ignora.");
            }
        }

        if (seleccion.isEmpty()) {
            System.out.println("No se seleccionó ninguna sección. Se generará PDF vacío.");
        }

        System.out.println("\nGenerando PDF según opciones seleccionadas...\n");


        // Genera PDF, si bien se pasan todos los parámetros, solo se incluyen las secciones seleccionadas

        PDFResumen.crear(
                rutaPDF,
                ReportAnalyzer.total,
                ReportAnalyzer.passed,
                ReportAnalyzer.failed,
                ReportAnalyzer.passRate,
                ReportAnalyzer.failRate,
                ReportAnalyzer.timeAvg,
                ReportAnalyzer.timeTotal,
                ReportAnalyzer.slowest,
                ReportAnalyzer.fastest,
                ReportAnalyzer.filasErrores,
                seleccion
        );

        System.out.println("PDF generado en: " + rutaPDF);
    }
}
