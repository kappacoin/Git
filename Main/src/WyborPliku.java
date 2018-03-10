import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.awt.*;
import java.io.*;

public class WyborPliku {

    public static void Wczytaj(){
        FileChooser ChooseFileToLoad = new FileChooser();
        File KartaPostaci = ChooseFileToLoad.showOpenDialog(null);
        if (KartaPostaci != null) {
            try {
                Desktop.getDesktop().open(KartaPostaci);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Zapisz(){
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(null);
        FileChooser SaveFile = new FileChooser();
        SaveFile.setTitle("Save Image");
        if (selectedDirectory != null) {
            selectedDirectory.getAbsolutePath();
            System.out.println( selectedDirectory.getAbsolutePath());
            try{
                BufferedWriter Zapis = new BufferedWriter(new FileWriter(selectedDirectory.getAbsolutePath().toString()+"/KartaPostaci.txt"));
                Zapis.flush();

                Zapis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
