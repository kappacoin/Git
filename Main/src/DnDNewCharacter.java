import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.script.Bindings;


public class DnDNewCharacter {

    public static void display (){
        Stage Window = new Stage();
        Window.setTitle("Dungeons&Dragons Charecter Sheet");

        TabPane PanelZakladek = new TabPane();
        PanelZakladek.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);



        //rasa

        Tab RaceTab = new Tab("Race");
        ComboBox<String> WyborRasy = new ComboBox<>();
        WyborRasy.getItems().addAll("Dragonborn", "Dwarf", "Elf", "Gnome", "Halfling", "Half-Elf", "Half-Orc", "Human", "Tiefling");
        WyborRasy.setPromptText("Choose Your Race");

        Label Info = new  Label();
        Label InfoPod = new Label();

        VBox RaceLayout = new VBox(20);
        RaceTab.setContent(RaceLayout);

        RaceLayout.getChildren().addAll(WyborRasy);
        RaceLayout.setAlignment(Pos.TOP_CENTER);
        RaceLayout.setPadding(new Insets(15));



        //statystyki
        Spinner<Integer> StrenghtSpinn = new Spinner(1,20,8);
        Spinner<Integer> DexteritySpinn = new Spinner(1,20,8);
        Spinner<Integer> ConstitutionSpinn = new Spinner(1,20,8);
        Spinner<Integer> IntelligenceSpinn = new Spinner(1,20,8);
        Spinner<Integer> WisdomSpinn = new Spinner(1,20,8);
        Spinner<Integer> CharismaSpinn = new Spinner(1,20,8);
        ComboBox<Integer> LvlBox = new ComboBox();
        Label Lvl = new Label(), Str = new Label(), Dex = new Label(), Constitution = new Label(), Intel = new Label(), Wis = new Label(), Charisma = new Label();

        Str.setText("Strength: ");
        Dex.setText("Dexterity: ");
        Constitution.setText("Constitution: ");
        Intel.setText("Intelligence: ");
        Wis.setText("Wisdom: ");
        Charisma.setText("Charisma: ");
        Lvl.setText("Character LVL");
        LvlBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        LvlBox.setValue(1);


        WyborRasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = (String) WyborRasy.getValue();//get the selected item
                System.out.println("You're playing as " +s);

                ComboBox<String> WyborPodRasy = new ComboBox<>();
                WyborPodRasy.setPromptText("Choose Your Subrace");


                switch(s) {
                    case "Dragonborn":
                        Info.setText("Smok blablabla \n blaaewfagfaef");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy,Info);
                        break;

                    case "Dwarf":
                        Info.setText("Informacje o Krasnalach blablabla \n blaaewfagfaef");
                        WyborPodRasy.getItems().addAll("Hill Dwarf", "Mountain Dwarf");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, WyborPodRasy, Info);
                        break;

                    case "Elf":
                        Info.setText("Informacje o Elfach blablabla \n blaaewfagfaef");
                        WyborPodRasy.getItems().addAll("High Elf", "Wood Elf", "Drow");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, WyborPodRasy, Info);
                        break;

                    case "Gnome":
                        Info.setText("Informacje o Gnomach blablabla \n blaaewfagfaef");
                        WyborPodRasy.getItems().addAll("Forest Gnome", "Rock Gnome");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, WyborPodRasy, Info);
                        break;

                    case "Halfling":
                        Info.setText("Informacje o Niziołkach blablabla \n blaaewfagfaef");
                        WyborPodRasy.getItems().addAll("Lightfoot", "Stout");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, WyborPodRasy, Info);
                        break;

                    case "Half-Elf":
                        Info.setText("Informacje o Pół-Elfach blablabla \n blaaewfagfaef");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, Info);
                        break;

                    case "Half-Orc":
                        Info.setText("Informacje o Pół-Orkach blablabla \n blaaewfagfaef");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, Info);
                        break;

                    case "Human":
                        Info.setText("Informacje o Ludziach blablabla \n blaaewfagfaef");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, Info);
                        break;

                    case "Thiefling":
                        Info.setText("Informacje o Thieflingach blablabla \n blaaewfagfaef");
                        RaceLayout.getChildren().clear();
                        RaceLayout.getChildren().addAll(WyborRasy, Info);
                        break;

                }

                WyborPodRasy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String x = (String) WyborPodRasy.getValue();//get the selected item
                        System.out.println("Your subrace is " +x);

                        switch (x){
                            case("Hill Dwarf"):
                                InfoPod.setText("Hill Dwarf blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;


                            case ("Mountain Dwarf"):
                                InfoPod.setText("Mountain Dwarf blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Forest Gnome"):
                                InfoPod.setText("Forest Gnome blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Rock Gnome"):
                                InfoPod.setText("Rock Gnome blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Stout"):
                                InfoPod.setText("Stout Halfling blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Lightfoot"):
                                InfoPod.setText("Lightfoot Halfling blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("High Elf"):
                                InfoPod.setText("High Elf blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Wood Elf"):
                                InfoPod.setText("Wood Elf blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;

                            case ("Drow"):
                                InfoPod.setText("Drow blablabla \n blaaewfagfaef");
                                RaceLayout.getChildren().addAll(InfoPod);
                                break;
                        }
                    }
                });

            }
        });



        // Statystyki 2
        Tab StatTab = new Tab("Stats");

        GridPane StatPane = new GridPane();
        StatPane.setPadding(new Insets(10));
        StatPane.setHgap(5);
        StatPane.setVgap(5);
        ColumnConstraints Kolumna1 = new ColumnConstraints(75);
        ColumnConstraints Kolumna2 = new ColumnConstraints(155);
        ColumnConstraints Kolumna3 = new ColumnConstraints(155);

        Label Please = new Label("Please set your starting stats:");
        final Integer[] Pkt = {27};
        Label Punkty = new Label("Points to spend: 27");

        StatPane.getColumnConstraints().addAll(Kolumna1, Kolumna2, Kolumna3);

        StatPane.add(Lvl,0,0);
        StatPane.add(LvlBox,1,0);
        StatPane.add(Please,1,2);
        StatPane.add(Str, 0, 3);
        StatPane.add(StrenghtSpinn,1,3);
        StatPane.add(Dex, 0, 4);
        StatPane.add(DexteritySpinn,1,4);
        StatPane.add(Constitution, 0, 5);
        StatPane.add(ConstitutionSpinn,1,5);
        StatPane.add(Intel, 0, 6);
        StatPane.add(IntelligenceSpinn,1,6);
        StatPane.add(Wis, 0, 7);
        StatPane.add(WisdomSpinn,1,7);
        StatPane.add(Charisma, 0, 8);
        StatPane.add(CharismaSpinn,1,8);
        StatPane.add(Punkty,1,10);


        //BARDZO WAZNE LICZNIKI PUNKTOW

        StrenghtSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        DexteritySpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        ConstitutionSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        IntelligenceSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        WisdomSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        CharismaSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>oldValue&&newValue>13){
                Pkt[0]-=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Punkty.setText("Points to spend:  "+ Pkt[0]);
            }
        });

        //Koniec BARDZO WAZNEGO LICZNIKA

        //Dodaję modyfikatory




        //Koniec modyfikatorow

        StatTab.setContent(StatPane);


        Tab ClassTab = new Tab("Class");

        ComboBox<String> WyborKlasy = new ComboBox<>();
        WyborKlasy.getItems().addAll("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
                "Paladin", "Ranger", "Rouge", "Sorcerer", "Warlock", "Wizard");
        WyborKlasy.setPromptText("Choose Your Class");


        VBox ClassLayout = new VBox(20);
        ClassLayout.getChildren().addAll(WyborKlasy);
        ClassLayout.setAlignment(Pos.TOP_CENTER);
        ClassLayout.setPadding(new Insets(15));
        ClassTab.setContent(ClassLayout);




        WyborKlasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String c = (String) WyborKlasy.getValue();//get the selected item
                System.out.println("Your class is " + c);
            }
        });



        Tab AlignTab = new Tab("Alignment");


        PanelZakladek.getTabs().addAll(StatTab, RaceTab, ClassTab, AlignTab);


        Scene scene = new Scene(PanelZakladek, 600, 450);

        Window.setScene(scene);
        Window.show();
    }

}
