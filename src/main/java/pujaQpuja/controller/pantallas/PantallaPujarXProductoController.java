package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pujaQpuja.controller.PantallasMenu;
import pujaQpuja.controller.SingletonController;

public class PantallaPujarXProductoController implements Initializable {

    SingletonController singleton = SingletonController.getControllerAplication();

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
    private TextField campoBusqueda;

    @FXML
    private Rectangle botonBusqueda;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private TextField campoDescripcionProducto;

    @FXML
    private TextField campoPrecioSubasta;

    @FXML
    private TextField campoNumeroPujantes;

    @FXML
    private TextField campoDigitePrecio;

    @FXML
    private Button botonPuja;

    @FXML
    private Button botonRealizarPregunta;

    @FXML
    private Text textoNombreProducto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoDescripcionProducto
                .setText(singleton.getControlador().getTemporalVisualizada().getProducto().getDescripcion());
        textoNombreProducto.setText(singleton.getControlador().getTemporalVisualizada().getProducto().getNombre());
        campoPrecioSubasta
                .setText(Double.toString(singleton.getControlador().getTemporalVisualizada().getPrecioFinal()));
        // campoNumeroPujantes.setText(Double.toString(singleton.getControlador().getTemporalVisualizada().getListaCompradores().size()));
        imagenProducto.setImage(singleton.getControlador().getTemporalVisualizada().getProducto().getFotos().get(0));
    }

    @FXML
    void AbrirPujar(ActionEvent event) throws IOException {

        String precioOfertado = campoDigitePrecio.getText();
        if (precioOfertado != null) {
            Double precio = 0.0;
            try {
                precio = Double.parseDouble(precioOfertado);
            } catch (Exception e) {
                // TODO: handle exception
                // mostrar show alert dialog, campo incorrecto
                System.out.println("");
            }

            if (precio > 0.0) {
                if (precio <= singleton.getControlador().getTemporalVisualizada().getPrecioFinal()) {

                    Parent pantallaIngresarParent = FXMLLoader
                            .load(getClass().getResource("/view/" + "PantallaPujarXProductoError.fxml"));
                    Scene pantallaIngresarScene = new Scene(pantallaIngresarParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(pantallaIngresarScene);
                    window.show();
                } else {
                    // mostrar pantalla confirmacion- en caso de que no servir, hacer alert show
                    // dialogs
                    
                  //  Parent pantallaIngresarParent2 = FXMLLoader
                   //         .load(getClass().getResource("/view/" + "PantallaPujarXProductoConfirmacion.fxml"));
                  //  Scene pantallaIngresarScene2 = new Scene(pantallaIngresarParent2);
                 //   Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //   window2.setScene(pantallaIngresarScene2);
                  //  window2.show();
                  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProductoConfirmacion.fxml"));
                  fxmlLoader.load();
                  PantallaPujarXProductoConfirmacionController ConfirmacionController = fxmlLoader.getController();
                  ConfirmacionController.SetPrecioNuevo(precio);
                  ConfirmacionController.getTextoPrecio().setText(Double.toString( precio));
                  Parent p = fxmlLoader.getRoot();
                  Stage s = new Stage();
                  s.setScene(new Scene(p));
                  s.show(); 

                }
            }
        }
    }

    @FXML
    void AbrirRealizarPregunta(ActionEvent event) {

    }

    @FXML
    void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirAjustes(event);
    }

    @FXML
    void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
    }

    @FXML
    void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
    }

    @FXML
    void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirNotificaciones(event);
    }

    @FXML
    void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    void abririMetodoPago(MouseEvent event) {

    }

    @FXML
    void accionBuscar(MouseEvent event) {

    }

    @FXML
    void irAtras(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader
        .load(getClass().getResource("/view/" + "PantallaSeleccionarCategoria.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    public boolean confirmacion(boolean confirmacion,Double precionuevo)
    {
        //crear la puja y validad y lo demas
        
        singleton.getControlador().getTemporalVisualizada().setPrecioFinal(precionuevo);
        campoPrecioSubasta.setText(Double.toString(singleton.getControlador().getTemporalVisualizada().getPrecioFinal()));
        return true;
    }

}
