import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage OknoStartowe;
    Scene Start, Opcje;


    public void start(Stage primaryStage) throws Exception
    {

        OknoStartowe = primaryStage;
        OknoStartowe.setTitle("Universal Character Generator");
        Label wybor = new Label("Wybierz system:  ");

        Button DnD = new Button("Dungeons&Dragons");
        DnD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OknoStartowe.setScene(Opcje);
            }
        });

        Button OtherSys = new Button();
        OtherSys.setText("Inny System");


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(wybor, DnD, OtherSys);
        layout1.setAlignment(Pos.CENTER);
        Start = new Scene(layout1, 600, 450);




        Button wstecz = new Button ("Back");
        wstecz.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OknoStartowe.setScene(Start);
            }
        });

        Button nowa = new Button("New Character");
        nowa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DnDNewCharacter.display();
                OknoStartowe.close();
            }
        });


        Button wczytaj = new Button("Load Character");


        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(nowa, wczytaj, wstecz);
        layout2.setAlignment(Pos.CENTER);
        Opcje = new Scene(layout2,600, 450);




        OknoStartowe.setScene(Start);
        OknoStartowe.show();
    }

}
