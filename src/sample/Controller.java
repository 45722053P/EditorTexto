package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.stage.Window;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.Scanner;


public class Controller extends Component {

    @FXML
    TextArea texto;

    @FXML
    MenuItem salir, abrirArchivo, copiar, cortar, pegar, deshacer, ayuda, fuente, tamaño;

    @FXML
    Button botonCopiar, botonPegar, botonCortar, botonDeshacer;


    public void initialize() {
        //Adjunto las imagenes a los sus botones correspondientes.
        botonCopiar.setGraphic(new ImageView("copiar.png"));
        botonPegar.setGraphic(new ImageView("pegar.png"));
        botonCortar.setGraphic(new ImageView("cortar.png"));
        botonDeshacer.setGraphic(new ImageView("deshacer.png"));

    }

    public void taparBotones(Event event) {
        if (texto.getSelectedText().equals("")) {
            copiar.setDisable(true);
            pegar.setDisable(true);
        } else {
            copiar.setDisable(false);
            pegar.setDisable(false);
        }


    }

    //Menu Archivo.
    public void salir(ActionEvent actionEvent) {

        Platform.exit();
    }

    public void abrirArchivo(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Abrir archivo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt"),
                new FileChooser.ExtensionFilter("*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("*.*"));

        Stage mainStage = new Stage();

        File selectedFile = fileChooser.showOpenDialog(mainStage);
        fileChooser.setTitle(selectedFile.getName());

        try{
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));
            String linea = null;

            while ((linea = br.readLine()) != null) {
                texto.setText(texto.getText() + linea + "\n");
            }
        }
        catch(FileNotFoundException a){}
        catch (IOException b){}
    }

    public void guardarArchivo(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Archivo Guardado");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        Stage mainStage = new Stage();

        File selectedFile = fileChooser.showSaveDialog(mainStage);
        fileChooser.setTitle(selectedFile.getName());

        try{
            selectedFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
            bw.write(texto.getText());
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Menu Editar.
    public void copiarTexto(ActionEvent actionEvent) {

        texto.copy();
    }

    public void cortarTexto(ActionEvent actionEvent) {

        texto.cut();
    }

    public void pegarTexto(ActionEvent actionEvent) {

        texto.paste();
    }

    public void deshacerTexto(ActionEvent actionEvent) {
        texto.undo();

    }

    //Menu Ayuda.
    public void ayudar(ActionEvent actionEvent) {
        Alert ayuda = new Alert(Alert.AlertType.INFORMATION);
        ayuda.setTitle("La ayuda de Kiwi");
        ayuda.setHeaderText("AYUDA!!");
        ayuda.setResizable(true);
        String version = System.getProperty("Ayuda del editor de texto");
        String content = String.format("Primer editor de texto as seleccionado la ayuda jajajajaja no podras hacer nada hasta que lo cierres");
        ayuda.setContentText(content);
        ayuda.showAndWait();

    }

    //Menu Opciones

    //Menu Fuente.
    public void Arial(ActionEvent actionEvent) {

        texto.setFont(new Font("Arial", 15));
    }

    public void AdeleMono(ActionEvent actionEvent) {

        texto.setFont(Font.font("Adele Mono", 20));
    }

    public void Courier(ActionEvent actionEvent) {

        texto.setFont(Font.font("Courier", 30));
    }

    //Menu Tamaño.
    public void cambiarTamaño1(ActionEvent actionEvent) {

        texto.setFont(Font.font(10));
    }

    public void cambiarTamaño2(ActionEvent actionEvent) {

        texto.setFont(Font.font(25));
    }

    public void cambiarTamaño3(ActionEvent actionEvent) {

        texto.setFont(Font.font(35));
    }


    //Toolbar Botones.


    public void btCopiar(ActionEvent actionEvent) {
        copiarTexto(actionEvent);

    }

    public void btPegar(ActionEvent actionEvent) {
        pegarTexto(actionEvent);
    }

    public void btCortar(ActionEvent actionEvent) {
        cortarTexto(actionEvent);
    }

    public void btDeshacer(ActionEvent actionEvent) {
    deshacerTexto(actionEvent);
    }



}
