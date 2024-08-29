public class algebrarecu_0114 {

    // Método recursivo para criar uma substring a partir dos índices fornecidos
    public static String subString(String str, int start, int end) {
        if (start >= end) {
            return "";
        }
        return str.charAt(start) + subString(str, start + 1, end);
    }

    // Método recursivo para substituir uma parte da string com um novo valor
    public static String replace(String str, int start, int end, String value) {
        if (start >= str.length()) {
            return str;
        }
        if (end >= str.length()) {
            end = str.length();
        }
        return subString(str, 0, start) + value + subString(str, end, str.length());
    }

    // Método recursivo para montar o array de valores (0 ou 1) entre parênteses
    public static char[] montValues(String str, int position) {
        return montValuesHelper(str, position + 1, 0);
    }

    private static char[] montValuesHelper(String str, int index, int count) {
        if (index >= str.length() || str.charAt(index) == ')') {
            return new char[count];
        }
        if (str.charAt(index) == '0' || str.charAt(index) == '1') {
            char[] values = montValuesHelper(str, index + 1, count + 1);
            values[count] = str.charAt(index);
            return values;
        }
        return montValuesHelper(str, index + 1, count);
    }

    // Método para aplicar a negação lógica (NOT)
    public static char not(char[] args) {
        return args[0] == '0' ? '1' : '0';
    }

    // Método para aplicar a conjunção lógica (AND)
    public static char and(char[] args) {
        return andHelper(args, 0);
    }

    private static char andHelper(char[] args, int index) {
        if (index >= args.length) {
            return '1';
        }
        if (args[index] == '0') {
            return '0';
        }
        return andHelper(args, index + 1);
    }

    // Método para aplicar a disjunção lógica (OR)
    public static char or(char[] args) {
        return orHelper(args, 0);
    }

    private static char orHelper(char[] args, int index) {
        if (index >= args.length) {
            return '0';
        }
        if (args[index] == '1') {
            return '1';
        }
        return orHelper(args, index + 1);
    }

    // Método para resolver a expressão lógica
    public static String resolution(String str) {
        return resolutionHelper(str, str.length() - 1);
    }

    private static String resolutionHelper(String str, int i) {
        if (i < 0) {
            return subString(str, 0, 1);
        }
        if (str.charAt(i) == '(') {
            char op = str.charAt(i - 1);
            char[] values = montValues(str, i);

            char result;
            int end = str.indexOf(')', i);

            if (op == 'd') { // Operador AND
                result = and(values);
                str = replace(str, i - 3, end + 1, String.valueOf(result));
                i -= 3;
            } else if (op == 't') { // Operador NOT
                result = not(values);
                str = replace(str, i - 3, end + 1, String.valueOf(result));
                i -= 3;
            } else if (op == 'r') { // Operador OR
                result = or(values);
                str = replace(str, i - 2, end + 1, String.valueOf(result));
                i -= 2;
            }
            return resolutionHelper(str, i);
        }
        return resolutionHelper(str, i - 1);
    }

    public static void main(String[] args) {
        String str;

        // Método para ler linhas e processar as expressões
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
            str = replaceVariables(str, array, 0);

            // Resolve a expressão lógica
            str = resolution(str);
            MyIO.println(str);
        }
    }

    // Método recursivo para substituir variáveis A, B, C pelos valores correspondentes
    private static String replaceVariables(String str, String[] array, int index) {
        if (index >= str.length()) {
            return str;
        }
        if (str.charAt(index) == 'A') {
            str = replace(str, index, index + 1, array[0]);
        } else if (str.charAt(index) == 'B') {
            str = replace(str, index, index + 1, array[1]);
        } else if (str.charAt(index) == 'C') {
            str = replace(str, index, index + 1, array[2]);
        }
        return replaceVariables(str, array, index + 1);
    }
}
