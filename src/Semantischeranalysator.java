import java.util.ArrayList;
import java.util.List;

public class Semantischeranalysator {
    
    public List<String> symboltabelle;
    public Semantischeranalysator() {
        symboltabelle = new ArrayList<>();
    }

    public void analise(String linie, List<String> Wortbuch) {
        linie = linie.replace(";", "");
        String[] token = linie.split(" ");
        if (token[0].equals("ganz")) {
            // adicionar na tabela de simbolos      bereitsinderSymboltabelle=já está na tabela de símbolos
            if (bereitsinderSymboltabelle(token[1].toString())) {
                System.out.println("Variable bereits deklariert(Variavel ja declarada):"+token[1]+"!!!\n");
                return;
            }
            symboltabelle.add(token[1]);
            return;
        }

        // percorre todas as palavras da linha
        for(int i=0; i<token.length; i++) {
            // verificar se é uma variavel          esistvariabel=é variavel
            if (esistvariabel(token[i].toString(), Wortbuch)) {
                if (bereitsinderSymboltabelle(token[i].toString())) {
                    return;
                } 
                else {
                    System.out.println("Variable nicht deklariert(variavel nao declarada):"+token[i]+"!!!\n");
                }
            }
        }
    }


    public Boolean esistvariabel(String wort, List<String> Wortbuch) {

        if (wort.matches("([A-z][A-z0-9]{0,40})")) {
            for (int i=0; i<Wortbuch.size(); i++) {
                if(Wortbuch.get(i).toString().equals(wort)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Boolean bereitsinderSymboltabelle(String wort) {

    for (int i=0; i<symboltabelle.size(); i++) {
        if (symboltabelle.get(i).toString().equals(wort)) {
            return true;
            }
        }
        return false;
    }

}