/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaChatController implements Initializable {


    @FXML
    private Button botonRegresar;
    @FXML
    private Polygon botonEnviar;
    @FXML
    private TextField campoEscribirMensaje;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void aceptar(ActionEvent event) {
    }

    @FXML
    private void enviar(MouseEvent event) {
    }

}
