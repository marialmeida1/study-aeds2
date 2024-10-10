import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Pokemons {

    // Variáveis globais
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<Pokemons> listPokemons = new ArrayList<Pokemons>();
    public static String PATH = "/tmp/pokemon.csv";
    public static int comparisons = 0;

    // Atributos privados
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    public Pokemons() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<String>();
        this.abilities = new ArrayList<String>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = null;
    }

    public Pokemons(int id, int generation, String name, String description, ArrayList<String> types,
            ArrayList<String> abilities, double weight, double height, int captureRate, boolean isLegendary,
            Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneration() {
        return this.generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getAbilities() {
        return this.abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCaptureRate() {
        return this.captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public boolean getIsLegendary() {
        return this.isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public Date getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public void print() {
        System.out.println(
                "[#" + this.getId() +
                        " -> " + this.getName() +
                        ": " + this.getDescription() +
                        " - " + this.getTypes() +
                        " - " + this.getAbilities() +
                        " - " + this.getWeight() + "kg" +
                        " - " + this.getHeight() + "m" +
                        " - " + this.getCaptureRate() + "%" +
                        " - " + this.getIsLegendary() +
                        " - " + this.getGeneration() + " gen" +
                        "] - " + formatter.format(this.getCaptureDate()));
    }

    // Recebe uma linha e seta valores
    public void read(String line) {

        int start = 0; // Inicio da linha
        int end = 0; // Final da linha

        // ID
        // Pega os valores
        end = line.indexOf(",");
        String id_str = line.substring(start, end);
        int id = Integer.parseInt(id_str);

        // Seta os valores
        this.setId(id);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Generation
        // Pega valores
        end = line.indexOf(",");
        String generationStr = line.substring(start, end);
        int generation = Integer.parseInt(generationStr);

        // Seta valores
        this.setGeneration(generation);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Name
        // Pega valores
        end = line.indexOf(",");
        String name = line.substring(start, end);

        // Seta valores
        this.setName(name);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Description
        // Pega valores
        end = line.indexOf(",");
        String description = line.substring(start, end);

        // Seta valores
        this.setDescription(description);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Type
        ArrayList<String> types = new ArrayList<>(); // Cria uma lista
        // Seta valores
        end = line.indexOf(",");
        String type1 = line.substring(start, end);
        comparisons++; // Paga uma comparação
        if (type1.isEmpty()) {
            types.add("");
        } else {
            types.add("'" + type1 + "'");
        }

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Seta valores
        end = line.indexOf(",");
        String type2 = line.substring(start, end);
        comparisons++; // Paga uma comparação
        if (!type2.isEmpty()) {
            types.add("'" + type2 + "'");
        }

        // Seta valor -> FINAL
        this.setTypes(types);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Abilities
        // Pega valores
        start = line.indexOf("[");
        end = line.indexOf("]");

        // === Redimensiona a linha ===
        String expression = line.substring(start + 1, end);
        line = line.substring(end);

        ArrayList<String> abilities = new ArrayList<>(); // Cria array

        // Pega todos os valores
        while (true) { // COMPARAÇÕES: não temos um valor definido, sendo assim, "n" comparações
                       // realizadas, entretanto, por conhecer a base de dados esse valor não
                       // ultrapassa mais de
                       // 10 comprações
            comparisons++; // Paga várias comparações
            // Localiza a primeira ocorrência
            start = expression.indexOf("'");
            // Se não houver mais sai
            if (start == -1) {
                break;
            }

            // Organiza expressão
            end = expression.indexOf("'", start + 1); // Pega o final dela
            String ability = expression.substring(start + 1, end); // Seta ela começando do inicio da palavra até
            abilities.add("'" + ability + "'");
            expression = expression.substring(end + 1);
        }

        // Seta valores
        this.setAbilities(abilities);

        // Incializa a linha novamente
        end = line.indexOf(",");
        line = line.substring(end + 1);
        start = 0; // Start reiniciado

        // Weight
        // Pega valores
        end = line.indexOf(",");
        String weightStr = line.substring(start, end);
        double weight = 0.0;
        comparisons++; // Paga uma comparação
        if (!weightStr.isEmpty()) {
            weight = Double.parseDouble(weightStr);
        }

        // Seta valores
        this.setWeight(weight);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // Height
        // Pega valores
        end = line.indexOf(",");
        String heightStr = line.substring(start, end);
        double height = 0.0;
        comparisons++; // Paga uma comparação
        if (!heightStr.isEmpty()) {
            height = Double.parseDouble(heightStr);
        }

        // Seta valores
        this.setHeight(height);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // CaptureRate
        // Pega valores
        end = line.indexOf(",");
        String captureRateStr = line.substring(start, end);
        int captureRate = 0;
        comparisons++; // Paga uma comparação
        if (!captureRateStr.isEmpty()) {
            captureRate = Integer.parseInt(captureRateStr);
        }

        // Seta valores
        this.setCaptureRate(captureRate);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // IsLegendary
        // Pega valores
        end = line.indexOf(",");
        String isLegendaryStr = line.substring(start, end);
        boolean isLegendary = false;
        comparisons++; // Paga uma comparação
        if (!isLegendaryStr.isEmpty()) {
            comparisons++; // Paga uma comparação
            if (isLegendaryStr.equals("1")) {
                isLegendary = true;
            } else {
                isLegendary = false;
            }
        }

        // Seta valores
        this.setIsLegendary(isLegendary);

        // === Redimensiona a linha ===
        line = line.substring(end + 1);

        // CaptureDate
        // Pega valores
        String captureDateStr = line;

        // Seta valores
        try {
            Date captureDate = formatter.parse(captureDateStr);
            this.setCaptureDate(captureDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // COMPARAÇÕES TOTAIS: são (n) + 7(constantes)
    }

    public Pokemons clone() {
        return new Pokemons(
                this.id,
                this.generation,
                this.name,
                this.description,
                this.types,
                this.abilities,
                this.weight,
                this.height,
                this.captureRate,
                this.isLegendary,
                this.captureDate);
    }

    /*
     * ======================================================
     * MÉTODOS DE INTERAÇÃO DOS DADOS
     * =========================================================
     */

    // Seta dentro da Lista Total os valores do CSV
    public static void setListPokemons() {
        try {
            // Pega o arquivo lê primeiro como binário
            FileInputStream file = new FileInputStream(PATH);
            // Pega uma linha específica do arquivo -> que estava em binário e agora
            // convertido em caracteres
            BufferedReader line = new BufferedReader(new InputStreamReader(file));

            // Leitura de uma linha'
            String ln = line.readLine();

            // Vai ler até que a leitura da linha não seja NULL
            while ((ln = line.readLine()) != null) { // COMPARAÇÕES: sabemos o tamanho do csv, ou seja, temos um número
                                                     // constante de 801 comparações.
                comparisons++; // Paga várias comparações (801)
                // Inicializa o construtor
                Pokemons pokemon = new Pokemons();
                // Pega a linha recebida e insere dentro do objeto de pokemons com os seus
                // Seguintes atributos
                pokemon.read(ln);
                listPokemons.add(pokemon); // Adiciona na lista de pokemons
            }

            line.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cloneArray(int id, ArrayList<Pokemons> pokemons, ArrayList<Pokemons> newArray) {
        boolean result = false;
        for (int i = 0; i < pokemons.size(); i++) {
            comparisons++; // Paga uma comparação
            if (pokemons.get(i).getId() == id) {
                newArray.add(pokemons.get(i));
                result = true;
            }
        }
        comparisons++; // Paga uma comparação
        if (!result) {
            System.out.println("Pokemon não encontrado");
        }
    }

    public static String findByName(String name, ArrayList<Pokemons> newArray) {
        String results = new String();
        boolean found = false;

        for (int i = 0; i < newArray.size(); i++) {
            comparisons++; // Paga uma comparação
            if (newArray.get(i).getName().equals(name)) {
                found = true;
                break;
            }
        }

        comparisons++; // Paga uma comparação
        if (found) {
            results = "SIM";
        } else {
            results = "NAO";
        }

        return results;
    }

    public static void generatorLog(long startTime, long endTime) {
        String matricula = "863593";
        String nomeArquivo = matricula + "_1.txt";
        long executionTime = endTime - startTime;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write("Matrícula" + "\t" + "Tempo" + "\t" + "BigO" + "\t" + "Valor de Comparações\n");
            writer.write(matricula + "\t" + executionTime + "\t" + "O(n)" + "\t" + comparisons); 
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }

        // Número de matrícula
        // Tempo execução
        // Número comparações
    }

    public static void main(String[] args) {

        // Tempo inicio
        long startTime = System.nanoTime();

        setListPokemons();
        Scanner input = new Scanner(System.in);
        ArrayList<Pokemons> newArray = new ArrayList<Pokemons>();
        ArrayList<String> results = new ArrayList<>();
        String ln = input.nextLine();
        int i = 0;

        // COMPARAÇÕES: são "n" comparações, dependendo da quantidade inserida pelo
        // usuário
        while (i < 2) { // Permite no máximo dois "FIM"
            comparisons++; // Paga uma comparação
            if (ln.equals("FIM")) {
                i++;
                if (i == 2) {
                    break; // Sai do loop se "FIM" foi digitado duas vezes
                }
            } else {
                if (i == 0) {
                    int id = Integer.parseInt(ln);
                    cloneArray(id, listPokemons, newArray); // COMPARAÇÕES: são realizadas "n" comparações dependendo da
                                                            // quantidade inserida pelo usuário no qual define o tamanho
                                                            // de newArray
                } else if (i == 1) {
                    String result = findByName(ln, newArray); // COMPARAÇÕES: são realizadas "n" comparações dependendo
                                                              // da quantidade inserida pelo usuário no qual define o
                                                              // tamanho de newArray
                    results.add(result);
                }
            }

            ln = input.nextLine(); // Lê a próxima linha de entrada
        }

        for (String result : results) { // COMPARAÇÕES: dependente da quantidade inserida pelo usuário, ou seja, "n"
            comparisons++; // Paga várias comparações
            System.out.println(result);
        }

        input.close();

        // COMPARAÇÕES: Sobre as comparações pode se cocluir que obtivemos O(n)

        // Tempo fim
        long endTime = System.nanoTime();
        generatorLog(startTime, endTime);
    }

}