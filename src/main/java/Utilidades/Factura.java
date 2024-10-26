/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author andre
 */
public class Factura {
   

    public static void main(String[] args) {
        Factura factura = new Factura();
        factura.crearPDF("regUser.csv");
    }

    public void crearPDF(String csvPath) {
        String propietario = obtenerPropietario(csvPath);
        String valorAdministracion = "500.000";

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("crearFact.pdf"));
            doc.open();

            Font tipo1 = FontFactory.getFont(BaseFont.TIMES_ROMAN, 12, BaseColor.BLACK);
            Font tipo2 = FontFactory.getFont(BaseFont.TIMES_BOLD, 20, BaseColor.BLUE);

            // Título del documento
            Paragraph titulo = new Paragraph("Factura de Administración", tipo2);
            doc.add(titulo);

            // Nombre del propietario
            Paragraph nombreProp = new Paragraph("Propietario: " + propietario, tipo1);
            doc.add(nombreProp);

            // Valor de administración
            Paragraph valorAdm = new Paragraph("Valor de Administración: $" + valorAdministracion, tipo1);
            doc.add(valorAdm);

            // Más detalles si es necesario
            doc.add(new Paragraph("Fecha: " + java.time.LocalDate.now(), tipo1));
            doc.add(new Paragraph("------------------------------------------------------", tipo1));

            doc.addAuthor("Duvan Ruiz, Rafael Osorio");
            doc.close();
        } catch (DocumentException | IOException e) {
            System.out.println("Error al crear el archivo PDF");
            e.printStackTrace();
        }
    }

    private String obtenerPropietario(String filePath) {
        String propietario = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Leer encabezado
            if (line != null) {
                line = br.readLine(); // Leer primer registro
                if (line != null) {
                    String[] data = line.split(",");
                    if (data.length > 1) {
                        propietario = data[1];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propietario;
    }
}
