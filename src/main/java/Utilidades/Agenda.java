
package Utilidades;

import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.*;

/**
 *
 * @author Duvan Ruiz
 */
public class Agenda{
    List<Persona> listaClientes = new ArrayList<>();
    List<Persona> listaRecuperada = new ArrayList<>();
    
    public void adiccionarCliente(Persona objA){
        listaClientes.add(objA); 
        guardarFichero();
    }
    
    public int obtenerIndice(String Id){
        for(Persona cliente : listaRecuperada) {
            if(cliente.getId().equals(Id)){
                return listaRecuperada.indexOf(cliente);
            }
        }
        return -1;
    }
    
    public String listarClientes(){
        String lista ="";
        if(!listaRecuperada.isEmpty()){
            for(Persona cliente : listaRecuperada) {
                lista = lista + cliente.getId()+ "\t" + cliente.getNombre() + "\t" + cliente.getSexo() + 
                    "\t" + cliente.getRequerimiento() + "\t\t" + cliente.getEstado() + "\n";
            }
        }
        return lista;
    }
    
    public Persona buscarPorID(int indice){
        Persona encontrado = listaRecuperada.get(indice);
        return encontrado;
    }
    
    public void actualizarCliente(Persona obj){
        for (Persona cliente : listaRecuperada){
            if(obj.getId().equals(cliente.getId())){
                cliente.setId(obj.getId());
                cliente.setNombre(obj.getNombre());
                cliente.setSexo(obj.getSexo());
                cliente.setEmpresa(obj.getEmpresa());
                cliente.setRequerimiento(obj.getRequerimiento());
                cliente.setEstado(obj.getEstado());
                cliente.setFecha(obj.getFecha());
                cliente.setMultas(obj.getMultas());
                cliente.setMotivoMulta(obj.getMotivoMulta());
                cliente.setTotalPagar(obj.getTotalPagar());
                cliente.setMotivoPago(obj.getMotivoPago());
                cliente.setTransporte(obj.getTransporte());
            }
            actualizarFichero(listaRecuperada);
        }
    }
    
    public void eliminarCliente(int indice){
        listaRecuperada.remove(indice);
        actualizarFichero(listaRecuperada);
    }
    
    public int numClientes(){
        int numClientes = listaRecuperada.size();
        return numClientes;
    }
    
    public float recaudo(){
        float recaudo = 0;
        for (Persona cliente : listaRecuperada){
            recaudo = recaudo + cliente.getTotalPagar();
        }
        return recaudo;
    }
    
    public float gastoTransporte(){
        float gasto = 0;
        for (Persona cliente : listaRecuperada){
            gasto = gasto + cliente.getTransporte();
        }
        return gasto;
    }
    
    public void guardarFichero(){ //Generació del pdf
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("aproambiental.dat") );
            escribiendoFichero.writeObject(listaClientes);
            escribiendoFichero.close();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }
    
    public void leerFichero() throws IOException, ClassNotFoundException{
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream("aproambiental.dat") );
            listaRecuperada = ( ArrayList <Persona> )leyendoFichero.readObject();
            leyendoFichero.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarFichero(List<Persona> lista){
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("aproambiental.dat") );
            escribiendoFichero.writeObject(lista);
            escribiendoFichero.close();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }
    
    public void crearPDF1() {
        try {
            Document doc = new Document();  //Creamos un objeto tipo documento
            
            Font tipo1 = FontFactory.getFont(BaseFont.TIMES_ROMAN, 12, BaseColor.BLACK);
            Font tipo2 = FontFactory.getFont(BaseFont.TIMES_BOLD, 20, BaseColor.BLUE);
            Font tipo3 = FontFactory.getFont(BaseFont.MACROMAN, 12, BaseColor.CYAN);
            PdfWriter.getInstance(doc, new FileOutputStream("Lista_de_Solicitudes.pdf"));  //lo asociamos como archivo y colocarle nombre
            doc.open();
            Paragraph titulo = new Paragraph("Lista de clientes", tipo3);
            doc.add(titulo);
            for (Persona cliente : listaRecuperada){
                Paragraph txNom = new Paragraph("Nombre: " + cliente.getNombre(), tipo1);
                Paragraph txId = new Paragraph("ID: " + cliente.getId(), tipo1);
                Paragraph txSex = new Paragraph("Sexo: "+ cliente.getSexo(), tipo1);
                Paragraph txRe = new Paragraph("Requerimiento: "+ cliente.getRequerimiento(), tipo1);
                Paragraph txEmp = new Paragraph("Empresa: "+ cliente.getEmpresa(), tipo1);
                Paragraph txEst = new Paragraph("Estado: "+ cliente.getEstado(), tipo1);
                Paragraph txFec = new Paragraph("Fecha: "+ cliente.getFecha(), tipo1);
                Paragraph txLinea = new Paragraph("------------------------------------------------------", tipo1);
                
                doc.add(txId);
                doc.add(txNom);
                doc.add(txSex);
                doc.add(txRe);
                doc.add(txEmp);
                doc.add(txEst);
                doc.add(txFec);
                doc.add(txLinea);
            }
            doc.addAuthor("Duvan Ruiz, Rafael Osorio");
            doc.close(); 
        }catch(DocumentException | java.io.FileNotFoundException e){
            System.out.println("Error del archivo");
            e.printStackTrace();
        }
    }

    public void crearPDF2() {
       try {
            Document doc = new Document();  //Creamos un objeto tipo documento
            PdfWriter.getInstance(doc, new FileOutputStream("/Control/Factura.pdf"));

            Font tipo1 = FontFactory.getFont(BaseFont.TIMES_ROMAN, 12, BaseColor.BLACK);
            Font tipo2 = FontFactory.getFont(BaseFont.TIMES_BOLD, 20, BaseColor.BLUE);
            Font tipo3 = FontFactory.getFont(BaseFont.MACROMAN, 12, BaseColor.CYAN);
            PdfWriter.getInstance(doc, new FileOutputStream("Arqueo_de_caja.pdf"));  //lo asociamos como archivo y colocarle nombre
            doc.open();
            Paragraph titulo = new Paragraph("Arqueo de Caja", tipo2);
            doc.add(titulo);
            Paragraph txNumCl = new Paragraph("Numero de clientes atendidos: " + numClientes(), tipo1);
            Paragraph txReca = new Paragraph("Recaudo: " + recaudo(), tipo1);
            Paragraph txGastoTrans = new Paragraph("Gastos en transporte: "+ gastoTransporte(), tipo1);
            Paragraph txLinea = new Paragraph("------------------------------------------------------", tipo1);

            doc.add(txNumCl);
            doc.add(txReca);
            doc.add(txGastoTrans);
            doc.add(txLinea);
            
            doc.addAuthor("Duvan Ruiz, Rafael Osorio");
            doc.close(); 
        }catch(DocumentException | java.io.FileNotFoundException e){
            System.out.println("Error del archivo");
            e.printStackTrace();
        }
    }
}
    
