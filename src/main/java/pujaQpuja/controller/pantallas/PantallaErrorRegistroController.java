/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaErrorRegistroController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private void regresar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaRegistro.fxml"));
           Scene errorRegistroScene = new Scene(pantallaErrorParent);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(errorRegistroScene);
           window.show();
    }

    
    private void cancelar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"Inicio.fxml"));
           Scene errorRegistroScene = new Scene(pantallaErrorParent);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(errorRegistroScene);
           window.show();
    }

}
