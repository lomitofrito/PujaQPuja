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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaExitoRealizarSubastaController implements Initializable {

    @FXML
    private Text textoNombreProducto;
    @FXML
    private TextArea campoConfirmacion;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonAceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionAceptar(ActionEvent event) {
    }

}
