public class lab_0101 {
    
    public boolean isMaisculas(char c){
        if (Character.isUpperCase(c)) {
            return true;
        } 

        return false;
    }

    public int contMais(String str){
        int cont = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(isMaisculas(str.charAt(i)) == true){
                cont++;
            }
        }

        return cont;
    }
    
    public static void main(String[] args) {
        lab_0101 lab = new lab_0101();

        String str = MyIO.readString("");
        int number = lab.contMais(str);
        MyIO.println(number);


    }
}
