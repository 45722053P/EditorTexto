/*package sample;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Created by 45722053p on 30/10/15.
 */
/*public class escojerArchivo extends Application implements
        EventHandler<ActionEvent> {

    private TextArea textArea;
    private Stage stage;
    private Button openButton;
    private Button saveButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;
        stage.setTitle("Ejemplo de Archivos");
        textArea = new TextArea();

        openButton = new Button("Abrir");
        openButton.setOnAction(this);
        openButton.setTranslateX(80.0);

        saveButton = new Button("Guardar");
        saveButton.setOnAction(this);

        HBox top = new HBox(150);
        top.getChildren().addAll(openButton, saveButton);

        Group root = new Group();
        Scene scene = new Scene(root, 465, 280, Color.WHITE);

        BorderPane border = new BorderPane();
        border.setCenter(textArea);
        border.setTop(top);
        root.getChildren().add(border);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        Button b = (Button) event.getSource();

        if (b.getText().equals("Abrir")) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if(file!=null){
                FileReader fr = null;
                BufferedReader br = null;
                String texto = "";
                try {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    String st = br.readLine();
                    while (st != null) {
                        texto = texto + st + "\n";
                        st = br.readLine();
                    }
                } catch (Exception e) {
                    textArea.appendText(e.toString());
                } finally {
                    try {
                        fr.close();
                    } catch (Exception e2) {
                        textArea.appendText(e2.toString());
                    }
                }
                textArea.appendText(texto);
            }


        } else if (b.getText().equals("Guardar")) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            if(file!=null){
                FileWriter fw = null;
                BufferedWriter bw = null;
                try {
                    // EL segundo parametro es un boolean
                    // En true escribe al final
                    // En false escribe al inicio
                    fw = new FileWriter(file, false);
                    bw = new BufferedWriter(fw);

                    String texto = textArea.getText();
                    bw.write(texto, 0, texto.length());
                } catch (Exception e) {
                    textArea.appendText(e.toString());
                } finally {
                    try {
                        bw.close();
                    } catch (Exception e2) {
                        textArea.appendText(e2.toString());
                    }
                }
            }
        }

    }
}
*/