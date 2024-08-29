import java.util.Scanner;

public class algebra_0105 {

    // Método para criar uma substring a partir dos índices fornecidos
    public static String subString(String str, int start, int end) {
        StringBuilder newStr = new StringBuilder();
        // Adiciona caracteres da substring ao StringBuilder
        for (int i = start; i < end; i++) {
            newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }

    // Método para substituir uma parte da string com um novo valor
    public static String replace(String str, int start, int end, String value) {
        // Pega a parte da string antes da substituição
        String newStr1 = subString(str, 0, start);
        // Pega a parte da string depois da substituição
        String newStr2 = subString(str, end, str.length());
        // Retorna a nova string formada pela combinação das partes
        return newStr1 + value + newStr2;
    }

    // Método para montar o array de valores (0 ou 1) entre parênteses
    public static char[] montValues(String str, int position) {
        int cont = 0;
        // Conta quantos valores 0 e 1 existem entre os parênteses
        for (int i = position + 1; i < str.length() && str.charAt(i) != ')'; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                cont++;
            }
        }

        char[] values = new char[cont];
        int j = 0;
        // Adiciona os valores 0 e 1 ao array
        for (int i = position + 1; i < str.length() && str.charAt(i) != ')'; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                values[j++] = str.charAt(i);
            }
        }
        return values;
    }

    // Método para aplicar a negação lógica (NOT)
    public static char not(char[] args) {
        // Retorna o oposto do valor
        return args[0] == '0' ? '1' : '0';
    }

    // Método para aplicar a conjunção lógica (AND)
    public static char and(char[] args) {
        // Se qualquer valor for 0, o resultado é 0
        for (char arg : args) {
            if (arg == '0') {
                return '0';
            }
        }
        return '1';
    }

    // Método para aplicar a disjunção lógica (OR)
    public static char or(char[] args) {
        // Se qualquer valor for 1, o resultado é 1
        for (char arg : args) {
            if (arg == '1') {
                return '1';
            }
        }
        return '0';
    }

    // Método para resolver a expressão lógica
    public static String resolution(String str) {
        char[] values;
        char result;
        int end;

        // Lê a expressão de trás para frente
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                char op = str.charAt(i - 1);
                values = montValues(str, i);

                if (op == 'd') { // Operador AND
                    result = and(values);
                    end = str.indexOf(')', i);
                    str = replace(str, i - 3, end + 1, String.valueOf(result));
                    i -= 3;
                } else if (op == 't') { // Operador NOT
                    result = not(values);
                    end = str.indexOf(')', i);
                    str = replace(str, i - 3, end + 1, String.valueOf(result));
                    i -= 3;
                } else if (op == 'r') { // Operador OR
                    result = or(values);
                    end = str.indexOf(')', i);
                    str = replace(str, i - 2, end + 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        // Retorna o resultado final
        return subString(str, 0, 1);
    }

    public static void main(String[] args) {;
        String str;

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("0")) {
                break;
            }

            String[] array = new String[3];

            if (str.charAt(0) == '2') {
                array[0] = str.charAt(2) + ""; // Valor de A
                array[1] = str.charAt(4) + ""; // Valor de B
                array[2] = "0"; // Valor padrão para C
                str = subString(str, 6, str.length()); // Remove os valores e mantém a expressão
            } else if (str.charAt(0) == '3') {
                array[0] = str.charAt(2) + ""; // Valor de A
                array[1] = str.charAt(4) + ""; // Valor de B
                array[2] = str.charAt(6) + ""; // Valor de C
                str = subString(str, 8, str.length()); // Remove os valores e mantém a expressão
            }

            // Substitui as variáveis A, B, C pelos valores correspondentes
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A') {
                    str = replace(str, i, i + 1, array[0]);
                } else if (str.charAt(i) == 'B') {
                    str = replace(str, i, i + 1, array[1]);
                } else if (str.charAt(i) == 'C') {
                    str = replace(str, i, i + 1, array[2]);
                }
            }

            // Resolve a expressão lógica
            str = resolution(str);
            MyIO.println(str);
        }
    }
}
