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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.GeneralController;
import pujaQpuja.controller.modelos.ProductoController;
import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Producto;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.utilities.PantallasMenu;

/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaRealizarSubastaController implements Initializable {

    GeneralController generalController;
    ProductoController productoController;
    PujaController pujaController;

    @FXML
    private Rectangle botonAtras;
    @FXML
    private Rectangle botonPerfil;
    @FXML
    private Rectangle botonRectanguloAjustes;
    @FXML
    private Rectangle botonRectanguloCategorias;
    @FXML
    private Rectangle botonRectanguloRealizarSubasta;
    @FXML
    private Rectangle botonRectanguloHistorialVentas;
    @FXML
    private Rectangle botonRectanguloHistorialCompras;
    @FXML
    private Rectangle botonRectanguloNotificaciones;
    @FXML
    private Rectangle botonRectanguloMetodoPago;
    @FXML
    private TextField campoNombreProducto;
    @FXML
    private ChoiceBox<Categoria> desplegableCategoria;
    @FXML
    private TextArea campoDescripcionProducto;
    @FXML
    private TextField campoPrecioInicial;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonAdjuntarFoto;
    @FXML
    private Button botonPublicar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generalController = GeneralController.getControllerAplication();
        desplegableCategoria.getItems().setAll(Categoria.values());
        productoController = new ProductoController();
        pujaController = new PujaController();
    }

    @FXML
    private void irAtras(MouseEvent event) {
    }

    @FXML
    private void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirAjustes(event);
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirNotificaciones(event);
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
        PantallasMenu.abririMetodoPago(event);
    }

    @FXML
    private void accionAdjuntarFoto(ActionEvent event) {
    }

    @FXML
    private void accionPublicar(ActionEvent event) throws IOException {

        Producto productoASubastar = new Producto();

        // FALTA AGREGAR ESE PRODUCTO A LA LISTA DE PUJAS

        productoASubastar.setNombre(campoNombreProducto.getText());
        if(!campoPrecioInicial.getText().isEmpty())
            productoASubastar.setPrecioInicial(Float.parseFloat(campoPrecioInicial.getText()));
        productoASubastar.setDescripcion(campoDescripcionProducto.getText());

        Categoria categoria = Categoria.CALZADO;
        if (Categoria.CALZADO == desplegableCategoria.getValue()) {
            categoria = Categoria.CALZADO;
        }
        if (Categoria.DEPORTE == desplegableCategoria.getValue()) {
            categoria = Categoria.DEPORTE;
        }

        if (Categoria.ELECTRODOMESTICOS == desplegableCategoria.getValue()) {
            categoria = Categoria.ELECTRODOMESTICOS;
        }

        if (Categoria.PANTALONES == desplegableCategoria.getValue()) {
            categoria = Categoria.PANTALONES;
        }

        if (Categoria.ROPA == desplegableCategoria.getValue()) {
            categoria = Categoria.ROPA;
        }

        if (Categoria.TECNOLOGIA == desplegableCategoria.getValue()) {
            categoria = Categoria.TECNOLOGIA;
        }
        productoASubastar.setCategoria(categoria);
        
        Image foto = new Image("file:" + "src/main/resources/images/logo.png", 118, 118, false, false);
        productoASubastar.setFoto(foto);
        
        productoController.crear(productoASubastar); 
        pujaController.crear(productoASubastar);
         /*       
        Puja nPuja = new Puja();
        nPuja.setEstado(EstadoPuja.ACTIVO);
        nPuja.setProducto(productoASubastar);
        nPuja.setPrecioFinal(productoASubastar.getPrecioInicial());
        int cont = generalController.getContID();
        System.out.println("Cont antes de incrementarID: " + cont);
        generalController.incrementarId();
        cont = generalController.getContID();
        System.out.println("Cont despues de incrementarID: " + cont);
        nPuja.setId(cont);
        System.out.println(nPuja.toString());
        generalController.agregarPujaActiva(nPuja);*/
         
        if (productoASubastar.getPrecioInicial() >= 0 && !productoASubastar.getNombre().isBlank()
                && !productoASubastar.getDescripcion().isBlank() && productoASubastar.getCategoria() != null
                && productoASubastar.getFoto() != null) {

            Parent pantallaErrorParent = FXMLLoader
                    .load(getClass().getResource("/view/" + "PantallaExitoRealizarSubasta.fxml"));
            Scene errorRegistroScene = new Scene(pantallaErrorParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(errorRegistroScene);
            window.show();
        } else {
            Parent pantallaErrorParent = FXMLLoader
                    .load(getClass().getResource("/view/" + "PantallaErrorPublicacionSubasta.fxml"));
            Scene errorRegistroScene = new Scene(pantallaErrorParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(errorRegistroScene);
            window.show();
        }
    }

}
