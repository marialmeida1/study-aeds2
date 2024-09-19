import java.util.Scanner;

class questao_01 {

  public static char[] expression(String values[]) {

    int length = values.length;
    char resp[] = new char[length];

    for (int i = 0; i < values.length; i++) {
      String value = values[i];

      if( (value.length()%2) != 0 ) {
        resp[i] = 'N';
      } else {
        boolean respBool = validation(value);
        if(respBool) {
          resp[i] = 'S';
        } else {
          resp[i] = 'N';
        }
      }
    }


    return resp;
  }

  
  public static boolean validation(String str) {

    int cont[] = new int[6];
    boolean resp = true;

    for (int i = 0; i < str.length(); i++) {

      switch (str.charAt(i)) {
        case '{':
          cont[0] += 1;
          break;
        case '[':
          cont[1] += 1;
          break;
        case '(':
          cont[2] += 1;
          break;
        case '}':

          cont[3] += 1;

          if(cont[0] == 0) {
            resp = false;
          }

          break;
        case ']':

          cont[4] += 1;

          if(cont[1] == 0) {
            resp = false;
          }

          break;
        case ')':

          cont[5] += 1;

          if(cont[2] == 0) {
            resp = false;
          }

          break;
        default:
          break;
      }

    }

   if(cont[0] != cont[3]){
      resp = false;
    } else if(cont[1] != cont[4]){
      resp = false;
    } else if(cont[2] != cont[5]){
      resp = false;
    }

    return resp;
  }
 
   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
  

      // Pegou a instancia
      int n = 0;
      do {

        if(input.hasNextInt()){
          n = input.nextInt();
        }

      } while( n < 0 || n > 20);


      // Array de valores
      String values[] = new String[n];

      // Recebe os parametros
      for(int i = 0; i < n; i++ ){
        values[i] = input.next();
      }

      char resp[] = expression(values);

      // Imprime valores
      for(int i = 0; i < n; i++ ){
        System.out.println(resp[i]);
      }

   }

}