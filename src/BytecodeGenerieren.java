public class BytecodeGenerieren {

    public BytecodeGenerieren() { 
        //construtor
    }

    public String generieren(String linie) {

        String[] token = linie.split(" ");
        
        if (token[0].equals("ganz")){
			return "int " + token[1]+"\n";
        }
        if (token[0].equals("variable")){
            return "var" + token[1]+"\n";
        }
		if (token[0].equals("lesen")) {
			return token[1].replace(";","") + " = input.nextInt();\n";
        }
        if (token[0].equals("anders")) {
            return "else" + token[1]+"\n";
        }
        if (token[0].equals("dann")) {
            return "then" + token[1]+"\n";
        }
        if (token[0].equals("}")) {
            return token[0]+ "\n";
        }
        if (token[0].equals("zuruckkehren;")) {
            return "return;\n";
        }
        if (token[0].equals("drucken")) {
            String[] parts = linie.split("\"");
            if (parts.length >= 1) {
                return "System.out.println(\"" +parts[1]+ "\");\n";
            }
        }        

        if (token.length > 2){
            if (token[0].equals("fur")){
                return "for ("+token[1]+" = "+token[3]+"; "+token[1] +" "+token[4] +" "+token[5]+"; "+token[1]+"++){\n";
            }           
            //for (i=1; i <= 10; i++){
                            
            if (token[0].equals("wenn")) {
                return "if ("+token[1]+" "+token[2]+" "+token[3]+") {\n";
            }
        }
        return linie+"\n";  
    }
}