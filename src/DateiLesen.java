import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DateiLesen {
   
    public DateiLesen(){
        
    }

    public List<String> lessen(String dateiname) throws IOException{
        List<String> daten = new ArrayList<>();
        String linie;
        try {
            FileReader leserin = new FileReader(dateiname);
            BufferedReader buffer = new BufferedReader(leserin);

            while ((linie = buffer.readLine()) != null) {
                daten.add(linie);
            }
            buffer.close();
            leserin.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Fehler beim Öffnen der Datei(erro ao abrir arquivo)"+dateiname);
        }
        return daten;
    }
}
