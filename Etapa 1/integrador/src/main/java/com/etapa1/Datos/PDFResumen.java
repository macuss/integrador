package com.etapa1.Datos;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class PDFResumen {

    // estilo del documento
    private static Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
    private static Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static Font keyFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static Font valueFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

    // agrega fila a la tabla
    private static void addTableRow(PdfPTable table, String key, String value, Font keyF, Font valueF) {

        PdfPCell keyCell = new PdfPCell(new Phrase(key, keyF));
        keyCell.setBorder(Rectangle.NO_BORDER);
        keyCell.setPadding(4);
        table.addCell(keyCell);

        // Celda para el valor /// 
        PdfPCell valueCell = new PdfPCell(new Phrase(value, valueF));
        valueCell.setBorder(Rectangle.NO_BORDER);
        valueCell.setPadding(4);
        table.addCell(valueCell);
    }

    public static void crear(String ruta, int total, int passed, int failed, float passRate, float failRate,
            float timeAvg, float timeTotal, int slowest, int fastest,
            List<Integer> filasErrores,
            List<Integer> seccionesSeleccionadas) {

        try {
            Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
            doc.open();

            Paragraph title = new Paragraph("Resumen de Reporte de Automatización", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            doc.add(title);

            doc.add(new Paragraph("Fecha de Generación: " + LocalDate.now(), subTitleFont));
            doc.add(new Paragraph("\n"));


            // 1 ESTADÍSTICAS GENERALES

            if (seccionesSeleccionadas.contains(1)) {

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(80);
                table.setWidths(new float[] { 3f, 2f });
                table.setSpacingBefore(10);
                table.setSpacingAfter(10);

                addTableRow(table, "Total de Pruebas Ejecutadas:", String.valueOf(total), keyFont, valueFont);
                addTableRow(table, "Total de PASS:", String.valueOf(passed), keyFont,
                        new Font(valueFont.getFamily(), 10, Font.BOLD, BaseColor.GREEN));
                addTableRow(table, "Total de FAIL:", String.valueOf(failed), keyFont,
                        new Font(valueFont.getFamily(), 10, Font.BOLD, BaseColor.RED));

                addTableRow(table, "Tasa de PASS:", String.format("%.2f%%", passRate), keyFont, valueFont);
                addTableRow(table, "Tasa de FAIL:", String.format("%.2f%%", failRate), keyFont, valueFont);

                doc.add(new Paragraph("Resultados de Ejecución", subTitleFont));
                doc.add(table);
            }


            // 2 MÉTRICAS DE TIEMPO

            if (seccionesSeleccionadas.contains(2)) {

                PdfPTable timeTable = new PdfPTable(2);
                timeTable.setWidthPercentage(80);
                timeTable.setWidths(new float[] { 3f, 2f });
                timeTable.setSpacingBefore(10);
                timeTable.setSpacingAfter(10);

                addTableRow(timeTable, "Tiempo Total de Ejecución:", String.format("%.2f ms", timeTotal), keyFont,
                        valueFont);
                addTableRow(timeTable, "Tiempo Promedio por Prueba:", String.format("%.2f ms", timeAvg), keyFont,
                        valueFont);
                addTableRow(timeTable, "Prueba Más Lenta:", slowest + " ms", keyFont, valueFont);
                addTableRow(timeTable, "Prueba Más Rápida:", fastest + " ms", keyFont, valueFont);

                doc.add(new Paragraph("Análisis de Tiempos", subTitleFont));
                doc.add(timeTable);
            }


            // 3 DETALLE DE ERRORES

            if (seccionesSeleccionadas.contains(3) && !filasErrores.isEmpty()) {

                Paragraph errorSection = new Paragraph("Detalle de Errores", subTitleFont);
                errorSection.setSpacingBefore(15);
                doc.add(errorSection);

                doc.add(new Paragraph("Filas con errores o datos inválidos: " + filasErrores.toString(), valueFont));
            }

            doc.close();
            System.out.println("PDF generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}