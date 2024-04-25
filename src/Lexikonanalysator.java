import java.util.List;

public class Lexikonanalysator {
    
    public Lexikonanalysator() {
        //construtor
    }

    public void Analise(String linie, List<String> alphabet) {
        String charakter = alphabet.get(0);

        for(int i=0; i < linie.length();i++ ) {
            char buchstabe = linie.charAt(i);
            Boolean fehler = true;
            for(int j=0; j< charakter.length();j++){
                if (buchstabe == charakter.charAt(j)) {
                    fehler  = false;
                }
            }
            if(fehler) {
                System.out.println("character ungultig(caractere inválido):"+buchstabe+":");
                return;
            }
        }
        System.out.println(linie+"      OK!");
    }
}
