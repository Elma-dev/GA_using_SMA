package dev.elma;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class GnaGui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root=new AnchorPane();
        HBox hBox=new HBox();
        VBox vBox=new VBox();
        Text labels[]=new Text[3];
        TextField textField[]=new TextField[3];
        Button start=new Button("Start ▶");

        AtomicInteger i= new AtomicInteger();
        Stream.of("Target","Size Population","Number Iterations").forEach(s->{
            labels[i.getAndIncrement()]=new Text(s);
        });

        for (int j=0;j<3;j++){
            textField[j]=new TextField();
        }

        //style configuration
        root.prefHeight(400);root.prefWidth(600);
        hBox.prefHeight(175);hBox.prefWidth(600);
        vBox.prefHeight(175);vBox.prefWidth(281);

        hBox.setSpacing(10);
        vBox.setSpacing(10);

        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);


        //add model to containers
        vBox.getChildren().add(labels[0]);
        vBox.getChildren().add(textField[0]);
        vBox.getChildren().add(labels[1]);
        vBox.getChildren().add(textField[1]);
        vBox.getChildren().add(labels[2]);
        vBox.getChildren().add(textField[2]);
        vBox.getChildren().add(start);

        hBox.getChildren().add(vBox);

        root.getChildren().add(hBox);

        //hBox.setStyle("-fx-background-color: red");
        hBox.setPrefWidth(600);

        //Gna Algo Link
        start.setOnAction(actionEvent -> {
            System.out.println(textField[0].getText());
        });

        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
}
