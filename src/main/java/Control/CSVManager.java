/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author andre
 */
import java.io.FileWriter;
import java.io.IOException;
public class CSVManager {
    public void SaveUser(String Id,String Nombre, String Sexo,String Empresa, String Requerimiento,String Estado, String Fecha, String Contrasena){
        try(FileWriter regUser= new FileWriter("src/main/java/Control/regUser.csv", true)){
            regUser.append(Id).append(",").append(Nombre).append(",").append(Sexo).append(",").append(Empresa).append(",").append(Requerimiento).append(",").append(Estado).append(",").append(Fecha).append(",").append(Contrasena).append("\n");
            regUser.flush();
            System.out.println("Resgistro Exitoso");
        }catch(IOException error){
            error.printStackTrace();
        }
    }
        public void SaveEmp(String Id,String Nombre, String Sexo,String Empresa, String Requerimiento,String Area, String Fecha, String Contrasena){
        try(FileWriter regUser= new FileWriter("src/main/java/Control/regEmp.csv", true)){
            regUser.append(Id).append(",").append(Nombre).append(",").append(Sexo).append(",").append(Empresa).append(",").append(Requerimiento).append(",").append(Area).append(",").append(Fecha).append(",").append(Contrasena).append("\n");
            regUser.flush();
            System.out.println("Resgistro Exitoso");
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
