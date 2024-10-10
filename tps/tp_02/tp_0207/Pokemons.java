import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Pokemons {

    // Variáveis globais
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<Pokemons> listPokemons = new ArrayList<Pokemons>();
    public static ArrayList<Pokemons> arrayPokemos = new ArrayList<Pokemons>();
    public static String PATH = "/tmp/pokemon.csv";
    public static int comparisons = 0;
    public static int movements = 0;

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
        while (true) {
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
        if (!isLegendaryStr.isEmpty()) {
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
            while ((ln = line.readLine()) != null) {

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

    public static Pokemons findID(int id, ArrayList<Pokemons> pokemons) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getId() == id) {
                return pokemons.get(i);
            }
        }
        return null;
    }

    public static void generateArray(Pokemons pokemon) {
        arrayPokemos.add(pokemon);
    }

    public static void sort() {
        for (int i = 1; i < arrayPokemos.size(); i++) {
            comparisons++;
            long date_tmp = arrayPokemos.get(i).getCaptureDate().getTime() / 1000;
            Pokemons tempPokemon = arrayPokemos.get(i);
            int j = i - 1;

            while (j >= 0 && (arrayPokemos.get(j).getCaptureDate().getTime() / 1000) > date_tmp) {
                comparisons++;
                movements++;
                arrayPokemos.set(j + 1, arrayPokemos.get(j));
                j--;
            }
            movements++;
            arrayPokemos.set(j + 1, tempPokemon);
        }
    }

    public static void printArray() {
        for (int i = 0; i < arrayPokemos.size(); i++) {
            comparisons++; // COMPARAÇÕES: são realizadas "n" comparações
            arrayPokemos.get(i).print();
        }
    }

    public static void generatorLog(long startTime, long endTime) {
        String matricula = "863593_insercao";
        String nomeArquivo = matricula + "_1.txt";
        long executionTime = endTime - startTime;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write("Matrícula" + "\t" + "Tempo" + "\t" + "BigO" + "\t" + "Valor de Movimentações" + "\t"
                    + "Valor de Comparações\n");
            writer.write(matricula + "\t" + executionTime + "\t" + "O(n²)" + "\t" + movements + "\t" + comparisons);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }

        // Número de matrícula
        // Tempo execução
        // Número comparações
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        setListPokemons();
        Scanner input = new Scanner(System.in);
        Pokemons pokemon = new Pokemons();
        String ln = input.nextLine();

        while (!ln.equals("FIM")) {
            int id = Integer.parseInt(ln);
            pokemon = findID(id, listPokemons);

            if (pokemon != null) {
                generateArray(pokemon);
            } else {
                System.out.println("Pokemon não encontrado!");
            }

            ln = input.nextLine();
        }

        input.close();

        sort();
        printArray();
        long endTime = System.nanoTime();
        generatorLog(startTime, endTime);
    }
}