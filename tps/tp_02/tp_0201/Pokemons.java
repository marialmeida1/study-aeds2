import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

class Pokemons {

    // Variáveis globais
    public static ArrayList<Pokemons> listPokemons;
    public static String PATH = "/tmp/pokemon.csv";

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
                        "->" + this.getName() +
                        ":" + this.getDescription() +
                        " - [" + this.getTypes() +
                        "] - [" + getAbilities() +
                        "] - " + this.getWeight() +
                        " - " + this.getHeight() +
                        " - " + this.getCaptureRate() +
                        " - " + this.getIsLegendary() +
                        " - " + this.getGeneration() +
                        "] - " + this.getCaptureDate());
    }

    // Recebe uma linha e seta valores
    public void read(String line) {

        int start = 0;
        int end = 0;

        // Pegando o ID
        end = line.indexOf(",");
        String id_str = line.substring(start, end);
        int id = Integer.parseInt(id_str);
        setId(id);

        start = end;

        // Pegando o Name
        end = line.indexOf(",");
        String name = line.substring(start, end);
        setName(name);

    }

    /*
     * ======================================================
     * MÉTODOS DE INTERAÇÃO DOS DADOS
     * =========================================================
     */

    // Seta dentro da Lista Total os valores do CSV
    public void setListPokemons() throws IOException {
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
            // seguintes atributos
            pokemon.read(ln);
            listPokemons.add(pokemon); // Adiciona na lista de pokemons
        }
    }

}