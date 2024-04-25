import java.io.IOException;
import java.util.List;

public class Compiler {
    public List<String> Alphabet;
    public List<String> Beispiel;
    public List<String> Wortbuch;
    public List<String> Ausdrucke;

    public Compiler() {
        //construtor
    }

    public List<String> Starten() throws IOException {
        String linie;
        System.out.println("Initiieren des compiler(Iniciando compilador)...\n");

        DateiLesen leser = new DateiLesen();
        Alphabet = leser.lessen("K:\\Compiladores\\Alphabet.txt");
        Beispiel = leser.lessen("K:\\Compiladores\\Beispiel.txt");
        Wortbuch = leser.lessen("K:\\Compiladores\\Wortbuch.txt");
        Ausdrucke = leser.lessen("K:\\Compiladores\\Ausdrucke.txt");

        for(int i=0; i < Beispiel.size();i++) {
            System.out.println(Beispiel.get(i));
        }
        System.out.println("----------");

        //lexico
        System.out.println("Lexikalische Analyse in Aktion(Análise léxica em ação)...\n");        
        Lexikonanalysator lexik = new Lexikonanalysator();
        for (int i=0; i<Beispiel.size(); i++) {
            linie = Beispiel.get(i);
            lexik.Analise(linie, Alphabet);
        }
        System.out.println("Ende der Lexikalische analyse(Fim da análise léxica)\n");        

        //sintatico
        System.out.println("Syntaktische Analyse im einsatz(Análise sintática em ação)...\n");
        SyntaktischerAnalysator syntaktisch = new SyntaktischerAnalysator();
        for (int i=0; i<Beispiel.size(); i++) {
            linie = Beispiel.get(i);
            syntaktisch.Analise(linie, Ausdrucke);
        }
        System.out.println("Ende der syntaktische analyse(Fim da análise sintatica)\n");

        //semantico
        System.out.println("Semantische Analyse im einsatz(Análise semântica em ação)...\n");
        Semantischeranalysator semantisch = new Semantischeranalysator();
        for (int i=0; i<Beispiel.size(); i++) {
            linie = Beispiel.get(i);
            semantisch.analise(linie, Wortbuch);
        }
        System.out.println("Ende der semantischen analyse(Fim da análise semantica).\n");

        //bytecode
        System.out.println("Initiieren des Bytecode-Generators(Iniciando gerador de ByteCode)\n");
        String byteCode = "";
		BytecodeGenerieren generator = new BytecodeGenerieren();		
		byteCode += "import java.util.Scanner;\n\n";
		byteCode += "public class Beispiel {\n\n";
		byteCode += "public static void main (String[] args[]) {\n\n";
		byteCode += "Scanner input = new Scanner(System.in);\n\n";

        for(int i=0; i< Beispiel.size(); i++){
            linie = Beispiel.get(i);
            byteCode +=generator.generieren(linie);
        }
        
        byteCode += "}\n";
        byteCode += "}\n";
        
        System.out.println(byteCode); 
        return Beispiel;
    }
} 
