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


public class SkillPoints {
    public static void display() {

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

        Tab StatTab = new Tab("Stats");

        GridPane StatPane = new GridPane();
        StatPane.setPadding(new Insets(10));
        StatPane.setHgap(5);
        StatPane.setVgap(5);
        ColumnConstraints Kolumna1 = new ColumnConstraints(75);
        ColumnConstraints Kolumna2 = new ColumnConstraints(200);

        Label Please = new Label("Please set your starting stats:");
        SimpleIntegerProperty value = new SimpleIntegerProperty();
        value.set(27);
        Label Punkty = new Label("Points to spend: "+value);

        StatPane.getColumnConstraints().addAll(Kolumna1, Kolumna2);

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

        StrenghtSpinn.valueProperty().addListener((observable, oldValue, newValue) ->{
            if(oldValue<newValue&&newValue<=13){
                System.out.println("Zmniejsz Punkty o 1");
            }
            if(oldValue>newValue){
                System.out.println("Zwieksz Punkty o 1");
            }
            if(newValue<8){
                System.out.println("Uwaga, jestes gorszy od ludzia");
            }
            if(newValue>15){
                System.out.println("Uwaga, jestes lepszy od ludzia");
            }
            if(newValue>13){
                System.out.println("Zmniejsz pkt o 2");
            }
            if(newValue<=13&&oldValue>13){
                System.out.println("Zwiększ o 2 pkt");
            }
        });

        StatTab.setContent(StatPane);

    }


}
