import javafx.application.Application;
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


    public void start(Stage primaryStage)
    {

        OknoStartowe = primaryStage;
        OknoStartowe.setTitle("Universal Character Generator");
        Label wybor = new Label("Wybierz system:  ");

        Button DnD = new Button("Dungeons&Dragons 5ed.");
        DnD.setOnAction(event -> OknoStartowe.setScene(Opcje));

        Button OtherSys = new Button();
        OtherSys.setText("Inny System");


        VBox StartWindowLayout = new VBox(20);
        StartWindowLayout.getChildren().addAll(wybor, DnD, OtherSys);
        StartWindowLayout.setAlignment(Pos.CENTER);
        Start = new Scene(StartWindowLayout, 600, 450);




        Button wstecz = new Button ("Back");
        wstecz.setOnAction(event -> OknoStartowe.setScene(Start));

        Button nowa = new Button("New Character");
        nowa.setOnAction(event -> {
            DnDNewCharacter.ScenaDnD();
            OknoStartowe.close();
        });


        Button Wczytaj = new Button("Load Character");
        Wczytaj.setOnAction(event -> WyborPliku.Wczytaj());

        VBox OptionsLayout = new VBox(20);
        OptionsLayout.getChildren().addAll(nowa, Wczytaj, wstecz);
        OptionsLayout.setAlignment(Pos.CENTER);
        Opcje = new Scene(OptionsLayout,600, 450);


        OknoStartowe.setScene(Start);
        OknoStartowe.show();
    }

}
