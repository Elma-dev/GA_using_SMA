package dev.elma;


import javafx.application.Application;
<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
=======
>>>>>>> origin/master
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
<<<<<<< HEAD
import javafx.scene.text.Font;
=======
>>>>>>> origin/master
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

=======
>>>>>>> origin/master
public class GnaGui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root=new AnchorPane();
        HBox hBox=new HBox();
        VBox vBox=new VBox();
        Text labels[]=new Text[3];
        TextField textField[]=new TextField[3];
<<<<<<< HEAD
        Button start=new Button("Start ▶");

        AtomicInteger i= new AtomicInteger();
        Stream.of("Target","Size Population","Number Iterations").forEach(s->{
            labels[i.getAndIncrement()]=new Text(s);
        });

        for (int j=0;j<3;j++){
            textField[j]=new TextField();
        }

        //style configuration
=======
        Button start=new Button("Start");

        //style config
>>>>>>> origin/master
        root.prefHeight(400);root.prefWidth(600);
        hBox.prefHeight(175);hBox.prefWidth(600);
        vBox.prefHeight(175);vBox.prefWidth(281);

        hBox.setSpacing(10);
        vBox.setSpacing(10);

        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);


<<<<<<< HEAD
        //add model to containers
=======

>>>>>>> origin/master
        vBox.getChildren().add(labels[0]);
        vBox.getChildren().add(textField[0]);
        vBox.getChildren().add(labels[1]);
        vBox.getChildren().add(textField[1]);
        vBox.getChildren().add(labels[2]);
        vBox.getChildren().add(textField[2]);
<<<<<<< HEAD
        vBox.getChildren().add(start);
=======
>>>>>>> origin/master

        hBox.getChildren().add(vBox);

        root.getChildren().add(hBox);

<<<<<<< HEAD
        //hBox.setStyle("-fx-background-color: red");
        hBox.setPrefWidth(600);

        //Results Node
        HBox resHbox=new HBox();
        VBox resVbox=new VBox();
        Text results=new Text();
        Text iter=new Text();


        //style
        resHbox.setPrefWidth(600);resHbox.setPrefHeight(192);
        resVbox.setPrefWidth(612);resVbox.setPrefHeight(192);

        resHbox.setAlignment(Pos.CENTER);
        resVbox.setAlignment(Pos.CENTER);

        results.setFont(Font.font(30));

        resHbox.setLayoutX(1);
        resHbox.setLayoutY(209);

        //addToComp

        resVbox.getChildren().add(iter);
        resVbox.getChildren().add(results);
        resHbox.getChildren().add(resVbox);
        root.getChildren().add(resHbox);



        //Gna Algo Link

        start.setOnAction(actionEvent -> {
            String target=textField[0].getText();
            int popSize=Integer.parseInt(textField[1].getText());
            int iterNbr=Integer.parseInt(textField[2].getText());
            System.out.println(target+" "+popSize+" "+iterNbr);
            GNAStr gnaStr=new GNAStr(popSize,target);

            //ObservableList<String> strings= FXCollections.observableList(Arrays.toString(gnaStr.population.get(0).getGenes()))
            Task<String> test=new Task<>(){

                @Override
                protected String call() throws Exception {
                    for(int k=0;k<iterNbr;k++) {
                        iter.setText("i="+k);
                        gnaStr.sortPopulation();
                        gnaStr.getPopulation().forEach(c -> {
                            System.out.println(c);
                        });
                        results.setText(Arrays.toString(gnaStr.population.get(0).getGenes()));
                        if(Arrays.compare(gnaStr.population.get(0).getGenes(),target.toCharArray())==0){
                            break;
                        }
                        gnaStr.crossover();
                        if(Math.random()<0.5)
                            gnaStr.mutation();
                        System.out.println("-----------------------------------------------");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return null;
                }
            };
            new Thread(test).start();

        });




        Scene scene=new Scene(root,600,400);
=======


        Scene scene=new Scene(root,400,400);
>>>>>>> origin/master
        stage.setScene(scene);
        stage.show();
    }
}
