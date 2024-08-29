public class lab_0301 {
    

    public static int[] createVector(String str) {
    
        int cont = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')' || str.charAt(i) == '(') {
                cont++;
            }
        }

        int[] direction = new int[cont];

        return direction;
    }

    public static int[] orderVector(String str, int array[]){

        int cont = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')') {
                array[cont] = 1;
                cont++;
            } else if (str.charAt(i) == '(') {
                array[cont] = 0;
                cont++;
            }
        }

        return array;
    }

    public static boolean validation(int array[]) {
        int length = array.length;
        int aux1 = 0;
        boolean result = true;

        if((length%2) != 0){
            return false;
        } else {
            for (int i = 0; i < array.length; i++) {
                
                if (length == 2 && (array[0] == 0 && array[1] == 1)){
                    return true;
                } else {
                    if(i%2 == 0){
                        aux1 = array[i];
                    } else if(i%2 != 0){
                        result = result(aux1, array[i]);
                    }
                }
            }
        }

        return result;
    }

    public static boolean result(int num1, int num2) {
        
        if(num1 == 1 && num2 == 0) {
            return false;
        }

        return true;
    }

    public static void print(boolean resp) {
        if(resp) {
            MyIO.println("correto");
        } else {
            MyIO.println("incorreto");
        }
    }

    public static void main(String[] args) {
        String str = "";

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }
            int[] array = createVector(str);
            array = orderVector(str, array);

            boolean result = validation(array);
            print(result);
        }

    }

}
