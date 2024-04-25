import java.util.List;

public class SyntaktischerAnalysator {
    
    public SyntaktischerAnalysator() {
        //construtor
	}

    public void Analise(String linie, List<String> Ausdrucke) {
        Boolean ergebnis=false;
        for (int i =0; i<Ausdrucke.size(); i++) {
            if (linie.trim().matches(Ausdrucke.get(i))) {
                System.out.println(linie+" OK");
                return;
            }
        }
        if (ergebnis) {
            System.out.println(linie+": OK");
        } else {
            System.out.println("Zeilenfehler(erro na linha): "+linie);
        }
        return;
    }
}
