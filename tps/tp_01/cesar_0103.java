public class cesar_0103 {
    
    void ciframento(String str){

        char caractere;
        int cod;
        int codAux = 0;
        char caractereAux;
        String strAux = "";

        for (int i = 0; i < str.length(); i++) {
            caractere = str.charAt(i);
            cod = (int) caractere;

            if((cod >= 88 && cod <= 90) || (cod >= 120 && cod <= 122)){
                switch (cod) {
                    case 88:
                        codAux = 65;
                        break;
                    case 89:
                        codAux = 66;
                        break;
                    case 90:
                        codAux = 67;
                        break;
                    case 120:
                        codAux = 97;
                        break;
                    case 121:
                        codAux = 98;
                        break;
                    case 122:
                        codAux = 99;
                        break;
                    default:
                        break;
                }
            } else {
                codAux = cod + 3;
            }

            caractereAux = (char) codAux;
            strAux += caractereAux;
        }

        MyIO.println(strAux);

    }

    public static void main(String[] args) {
        cesar_0103 fnc = new cesar_0103();
        String str = "";

        while (true) {
            str = MyIO.readLine("");
            fnc.ciframento(str);
        }
    }
}
