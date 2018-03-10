import Domain.Race.*;
import Domain.Race.Factories.RaceFactory;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class DnDNewCharacter {

    public static void ScenaDnD(){
        Stage Window = new Stage();
        Window.setTitle("Dungeons&Dragons 5ed. Charecter Sheet");

        TabPane PanelZakladek = new TabPane();
        PanelZakladek.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);



        //STATYSTYKI
        Spinner<Integer> StrenghtSpinn = new Spinner(1,30,8);
        Spinner<Integer> DexteritySpinn = new Spinner(1,30,8);
        Spinner<Integer> ConstitutionSpinn = new Spinner(1,30,8);
        Spinner<Integer> IntelligenceSpinn = new Spinner(1,30,8);
        Spinner<Integer> WisdomSpinn = new Spinner(1,30,8);
        Spinner<Integer> CharismaSpinn = new Spinner(1,30,8);
        Spinner<Integer> LvlSpinn = new Spinner(1,20,1);
        Label Lvl = new Label(), Str = new Label(), Dex = new Label(), Constitution = new Label(), Intel = new Label(), Wis = new Label(), Charisma = new Label();

        Str.setText("Strength: ");
        Dex.setText("Dexterity: ");
        Constitution.setText("Constitution: ");
        Intel.setText("Intelligence: ");
        Wis.setText("Wisdom: ");
        Charisma.setText("Charisma: ");
        Lvl.setText("Character LVL");

        Tab StatTab = new Tab("Stats");


        GridPane StatPane = new GridPane();
        StatPane.setPadding(new Insets(10));
        StatPane.setHgap(5);
        StatPane.setVgap(5);
        ColumnConstraints Kolumna1 = new ColumnConstraints(75);
        ColumnConstraints Kolumna2 = new ColumnConstraints(165);
        ColumnConstraints Kolumna3 = new ColumnConstraints();

        Label Please = new Label("Please set your starting stats:");
        final Integer[] Pkt = {27};
        Label Points = new Label("Points to spend: 27");
        Label StrModifier = new Label("Strenght Modifier: -1");
        Label DexModifier = new Label("Dexterity Modifier: -1");
        Label ConstModifier = new Label("Constitution Modifier: -1");
        Label IntModifier = new Label("Intelligence Modifier: -1");
        Label WisModifier = new Label("Wisdom Modifier: -1");
        Label CharModifier = new Label("Charisma Modifier: -1");
        Label Proficiency = new Label("Proficiency Bonus: +2");




        StatPane.getColumnConstraints().addAll(Kolumna1, Kolumna2, Kolumna3);

        StatPane.add(Lvl,0,0);
        StatPane.add(LvlSpinn,1,0);
        StatPane.add(Proficiency,2,0);
        StatPane.add(Please,1,2);
        StatPane.add(Str, 0, 3);
        StatPane.add(StrenghtSpinn,1,3);
        StatPane.add(StrModifier,2,3);
        StatPane.add(Dex, 0, 4);
        StatPane.add(DexteritySpinn,1,4);
        StatPane.add(DexModifier,2,4);
        StatPane.add(Constitution, 0, 5);
        StatPane.add(ConstitutionSpinn,1,5);
        StatPane.add(ConstModifier,2,5);
        StatPane.add(Intel, 0, 6);
        StatPane.add(IntelligenceSpinn,1,6);
        StatPane.add(IntModifier,2,6);
        StatPane.add(Wis, 0, 7);
        StatPane.add(WisdomSpinn,1,7);
        StatPane.add(WisModifier,2,7);
        StatPane.add(Charisma, 0, 8);
        StatPane.add(CharismaSpinn,1,8);
        StatPane.add(CharModifier,2,8);
        StatPane.add(Points,1,10);


        //BARDZO WAZNE LICZNIKI PUNKTOW

        StrenghtSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //TUTAJ SA WYPISYWANE MODYFIKATORY DO SILY
            if(newValue<=1) {
                StrModifier.setText("Strenght Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                StrModifier.setText("Strenght Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                StrModifier.setText("Strenght Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                StrModifier.setText("Strenght Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                StrModifier.setText("Strenght Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                StrModifier.setText("Strenght Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                StrModifier.setText("Strenght Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                StrModifier.setText("Strenght Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                StrModifier.setText("Strenght Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                StrModifier.setText("Strenght Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                StrModifier.setText("Strenght Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                StrModifier.setText("Strenght Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                StrModifier.setText("Strenght Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                StrModifier.setText("Strenght Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                StrModifier.setText("Strenght Modifier: +9");
            }
            if(newValue>=30){
                StrModifier.setText("Strenght Modifier: +10");
            }
        });

        DexteritySpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //MODYFIKATORY
            if(newValue<=1) {
                DexModifier.setText("Dexterity Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                DexModifier.setText("Dexterity Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                DexModifier.setText("Dexterity Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                DexModifier.setText("Dexterity Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                DexModifier.setText("Dexterity Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                DexModifier.setText("Dexterity Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                DexModifier.setText("Dexterity Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                DexModifier.setText("Dexterity Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                DexModifier.setText("Dexterity Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                DexModifier.setText("Dexterity Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                DexModifier.setText("Dexterity Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                DexModifier.setText("Dexterity Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                DexModifier.setText("Dexterity Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                DexModifier.setText("Dexterity Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                DexModifier.setText("Dexterity Modifier: +9");
            }
            if(newValue>=30){
                DexModifier.setText("Dexterity Modifier: +10");
            }
        });

        ConstitutionSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //MODYFIKATORY
            if(newValue<=1) {
                ConstModifier.setText("Constitution Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                ConstModifier.setText("Constitution Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                ConstModifier.setText("Constitution Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                ConstModifier.setText("Constitution Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                ConstModifier.setText("Constitution Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                ConstModifier.setText("Constitution Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                ConstModifier.setText("Constitution Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                ConstModifier.setText("Constitution Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                ConstModifier.setText("Constitution Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                ConstModifier.setText("Constitution Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                ConstModifier.setText("Constitution Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                ConstModifier.setText("Constitution Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                ConstModifier.setText("Constitution Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                ConstModifier.setText("Constitution Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                ConstModifier.setText("Constitution Modifier: +9");
            }
            if(newValue>=30){
                ConstModifier.setText("Constitution Modifier: +10");
            }
        });

        IntelligenceSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //MODYFIKATORY
            if(newValue<=1) {
                IntModifier.setText("Intelligence Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                IntModifier.setText("Intelligence Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                IntModifier.setText("Intelligence Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                IntModifier.setText("Intelligence Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                IntModifier.setText("Intelligence Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                IntModifier.setText("Intelligence Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                IntModifier.setText("Intelligence Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                IntModifier.setText("Intelligence Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                IntModifier.setText("Intelligence Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                IntModifier.setText("Intelligence Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                IntModifier.setText("Intelligence Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                IntModifier.setText("Intelligence Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                IntModifier.setText("Intelligence Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                IntModifier.setText("Intelligence Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                IntModifier.setText("Intelligence Modifier: +9");
            }
            if(newValue>=30){
                IntModifier.setText("Intelligence Modifier: +10");
            }
        });

        WisdomSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //MODYFIKATORY
            if(newValue<=1) {
                WisModifier.setText("Wisdom Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                WisModifier.setText("Wisdom Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                WisModifier.setText("Wisdom Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                WisModifier.setText("Wisdom Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                WisModifier.setText("Wisdom Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                WisModifier.setText("Wisdom Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                WisModifier.setText("Wisdom Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                WisModifier.setText("Wisdom Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                WisModifier.setText("Wisdom Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                WisModifier.setText("Wisdom Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                WisModifier.setText("Wisdom Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                WisModifier.setText("Wisdom Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                WisModifier.setText("Wisdom Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                WisModifier.setText("Wisdom Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                WisModifier.setText("Wisdom Modifier: +9");
            }
            if(newValue>=30){
                WisModifier.setText("Wisdom Modifier: +10");
            }
        });

        CharismaSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13&&newValue>8){
                Pkt[0] -=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=8&&newValue<13){
                Pkt[0] +=1;
                System.out.println("Punkty do wydania "+ Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
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
                Points.setText("Points to spend:  "+ Pkt[0]);
            }
            if(oldValue>newValue&&newValue>=13){
                Pkt[0]+=2;
                System.out.println("Punkty do wydania "+Pkt[0]);
                Points.setText("Points to spend:  "+ Pkt[0]);
            }

            //MODYFIKATORY
            if(newValue<=1) {
                CharModifier.setText("Charisma Modifier: -5");
            }
            if(newValue>=2&&newValue<=3){
                CharModifier.setText("Charisma Modifier: -4");
            }
            if(newValue>=4&&newValue<=5) {
                CharModifier.setText("Charisma Modifier: -3");
            }
            if(newValue>=6&&newValue<=7){
                CharModifier.setText("Charisma Modifier: -2");
            }
            if(newValue>=8&&newValue<=9) {
                CharModifier.setText("Charisma Modifier: -1");
            }
            if(newValue>=10&&newValue<=11){
                CharModifier.setText("Charisma Modifier: 0");
            }
            if(newValue>=12&&newValue<=13) {
                CharModifier.setText("Charisma Modifier: +1");
            }
            if(newValue>=14&&newValue<=15){
                CharModifier.setText("Charisma Modifier: +2");
            }
            if(newValue>=16&&newValue<=17) {
                CharModifier.setText("Charisma Modifier: +3");
            }
            if(newValue>=18&&newValue<=19){
                CharModifier.setText("Charisma Modifier: +4");
            }
            if(newValue>=20&&newValue<=21) {
                CharModifier.setText("Charisma Modifier: +5");
            }
            if(newValue>=22&&newValue<=23){
                CharModifier.setText("Charisma Modifier: +6");
            }
            if(newValue>=24&&newValue<=25) {
                CharModifier.setText("Charisma Modifier: +7");
            }
            if(newValue>=26&&newValue<=27){
                CharModifier.setText("Charisma Modifier: +8");
            }
            if(newValue>=28&&newValue<=29) {
                CharModifier.setText("Charisma Modifier: +9");
            }
            if(newValue>=30){
                CharModifier.setText("Charisma Modifier: +10");
            }
        });

        LvlSpinn.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue>=5&&newValue<=8) {
                Proficiency.setText("Proficiency Bonus: +3");
            }
            if(newValue>=9&&newValue<=12){
                Proficiency.setText("Proficiency Bonus: +4");
            }
            if(newValue>=13&&newValue<=16){
                Proficiency.setText("Proficiency Bonus: +5");
            }
            if(newValue>=17){
                Proficiency.setText("Proficiency Bonus: +6");
            }
        });

        //Koniec BARDZO WAZNEGO LICZNIKA



        //Probny tab na podsumowanie
        StatTab.setContent(StatPane);

        Tab Podsumowanie = new Tab("All in All");
        GridPane PodsumowaniePane = new GridPane();
        PodsumowaniePane.setPadding(new Insets(10));
        PodsumowaniePane.setHgap(5);
        PodsumowaniePane.setVgap(5);
        ColumnConstraints Kol1 = new ColumnConstraints(75);
        ColumnConstraints Kol2 = new ColumnConstraints(165);
        ColumnConstraints Kol3 = new ColumnConstraints();

        Label PodsLvlNum = new Label(), PodsLvl = new Label();
        PodsLvl.setText("Your current LVL: ");
        PodsLvlNum.textProperty().bind(LvlSpinn.valueProperty().asString());
        Label PodsStrNum = new Label(), PodsStr = new Label();
        PodsStr.setText("Your current Strenght: ");
        PodsStrNum.textProperty().bind(StrenghtSpinn.valueProperty().asString());
        PodsumowaniePane.add(PodsLvl,0,0);
        PodsumowaniePane.add(PodsLvlNum,1,0);
        PodsumowaniePane.add(PodsStr,0,1);
        PodsumowaniePane.add(PodsStrNum,1,1);


        Button Zapis = new Button("Zapisz Postać");
        Zapis.setOnAction(event -> WyborPliku.Zapisz());
        PodsumowaniePane.add(Zapis,0,4);
        Podsumowanie.setContent(PodsumowaniePane);


        //RASA

        Tab RaceTab = new Tab("Race");
        ComboBox<String> Races = new ComboBox<>();
        Races.getItems().addAll("Dragonborn", "Dwarf", "Elf", "Gnome", "Halfling", "Half-Elf", "Half-Orc", "Human", "Tiefling");
        Races.setPromptText("Choose Your Race");

        Label Info = new  Label();
        Label InfoPod = new Label();

        VBox RaceLayout = new VBox(20);
        RaceTab.setContent(RaceLayout);

        RaceLayout.getChildren().addAll(Races);
        RaceLayout.setAlignment(Pos.TOP_CENTER);
        RaceLayout.setPadding(new Insets(15));

        Races.setOnAction((ActionEvent event) -> {
            try{
                RaceFactory factory = new RaceFactory();
                Race chosenRace = factory.parse(Races.getValue());
                System.out.println(ChosenRace.getClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });


        /*WyborRasy.setOnAction(event -> {
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

            WyborPodRasy.setOnAction(event1 -> {
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
            });

        });
        */


        //KLASA

        Tab ClassTab = new Tab("Class");

        ComboBox<String> ChosenClass = new ComboBox<>();
        ChosenClass.getItems().addAll("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
                "Paladin", "Ranger", "Rouge", "Sorcerer", "Warlock", "Wizard");
        ChosenClass.setPromptText("Choose Your Class");


        VBox ClassLayout = new VBox(20);
        ClassLayout.getChildren().addAll(ChosenClass);
        ClassLayout.setAlignment(Pos.TOP_CENTER);
        ClassLayout.setPadding(new Insets(15));
        ClassTab.setContent(ClassLayout);




        ChosenClass.setOnAction(event -> {
            String c = ChosenClass.getValue();//get the selected item
            System.out.println("Your class is " + c);
        });



        Tab AlignTab = new Tab("Alignment");


        PanelZakladek.getTabs().addAll(StatTab, RaceTab, ClassTab, AlignTab, Podsumowanie);


        Scene scene = new Scene(PanelZakladek, 600, 450);

        Window.setScene(scene);
        Window.show();
    }

}
