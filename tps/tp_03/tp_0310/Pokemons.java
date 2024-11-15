import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Pokemons {

    // Variáveis globais
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static ArrayList<Pokemons> listPokemons = new ArrayList<Pokemons>();
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
                listPokemons.add(pokemon); // Adiciona na lista de pokemons TODOS POKEMONS
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

    public static void main(String[] args) throws Exception {
        setListPokemons();
        Scanner input = new Scanner(System.in);
        List pokemonsInsert = new List();
        String ln = input.nextLine();

        // Inserção inicial
        while (!ln.equals("FIM")) {
            int id = Integer.parseInt(ln);
            Pokemons pokemon = findID(id, listPokemons);

            if (pokemon != null) {
                pokemonsInsert.insertStart(pokemon);
            } else {
                System.out.println("Pokemon não encontrado!");
            }
            ln = input.nextLine();
        }
        pokemonsInsert.quickSort();
        pokemonsInsert.show();
    }

}

class Cel {
    Pokemons el;
    Cel prev, next;

    public Cel() {
        this(null);
    }

    public Cel(Pokemons el) {
        this.el = el;
        this.prev = null;
        this.next = null;
    }
}

class List {

    private Cel first;
    private Cel last;

    public List() {
        first = new Cel();
        last = first;
    }

    // INSERÇÕES
    // Inserir no início
    public void insertStart(Pokemons x) {
        Cel tmp = new Cel(x);
        tmp.next = first.next;
        tmp.prev = first;

        if (first.next != null) {
            first.next.prev = tmp;
        }

        first.next = tmp;

        if (first == last) {
            last = tmp;
        }
    }

    // Inserir no fim
    public void insertEnd(Pokemons x) {
        Cel tmp = new Cel(x);
        tmp.prev = last;
        last.next = tmp;
        last = tmp;
    }

    // Inserir em qualquer posição
    public void insert(Pokemons x, int pos) throws Exception {
        int size = size();

        if (pos < 0 || pos > size) {
            throw new Exception("Erro ao inserir: posição inválida (" + pos + " / size = " + size + ")");
        } else if (pos == 0) {
            insertStart(x);
        } else if (pos == size) {
            insertEnd(x);
        } else {
            Cel i = first;
            for (int j = 0; j < pos; j++, i = i.next);

            Cel tmp = new Cel(x);
            tmp.next = i.next;
            tmp.prev = i;

            if (i.next != null) {
                i.next.prev = tmp;
            }

            i.next = tmp;
        }
    }

    // REMOÇÕES
    // Remover do início
    public Pokemons removeStart() throws Exception {
        if (first == last) {
            throw new Exception("Erro ao remover (lista vazia)!");
        }

        Cel tmp = first.next;
        Pokemons resp = tmp.el;

        first.next = tmp.next;
        if (tmp.next != null) {
            tmp.next.prev = first;
        }

        if (tmp == last) {
            last = first;
        }

        tmp.next = tmp.prev = null; // Limpar referências
        return resp;
    }

    // Remover do fim
    public Pokemons removeEnd() throws Exception {
        if (first == last) {
            throw new Exception("Erro ao remover (lista vazia)!");
        }

        Pokemons resp = last.el;
        last = last.prev;

        if (last != null) {
            last.next = null;
        } else {
            first = last; // Lista ficou vazia
        }

        return resp;
    }

    // Remover em qualquer posição
    public Pokemons remove(int pos) throws Exception {
        int size = size();

        if (first == last) {
            throw new Exception("Erro ao remover (lista vazia)!");
        }

        if (pos < 0 || pos >= size) {
            throw new Exception("Erro ao remover: posição inválida (" + pos + " / size = " + size + ")");
        }

        if (pos == 0) {
            return removeStart();
        } else if (pos == size - 1) {
            return removeEnd();
        } else {
            Cel i = first.next;
            for (int j = 0; j < pos; j++, i = i.next);

            Pokemons resp = i.el;

            i.prev.next = i.next;
            i.next.prev = i.prev;

            i.next = i.prev = null; // Limpar referências
            return resp;
        }
    }

    // Mostrar elementos
    public void show() {
        for (Cel i = first.next; i != null; i = i.next) {
            i.el.print();
        }
        System.out.println();
    }

    // Mostrar elementos de trás para frente
    public void showReverse() {
        for (Cel i = last; i != first; i = i.prev) {
            System.out.print(i.el + " ");
        }
        System.out.println();
    }

    // Tamanho da lista
    public int size() {
        int size = 0;
        for (Cel i = first.next; i != null; i = i.next, size++);
        return size;
    }

    private void swapNodes(Cel nodeA, Cel nodeB) {
        if (nodeA == null || nodeB == null) {
            throw new IllegalArgumentException("Erro: Não é possível trocar nós nulos.");
        }

        Pokemons temp = nodeA.el;
        nodeA.el = nodeB.el;
        nodeB.el = temp;
    }

    // Partição do QuickSort
    private Cel partition(Cel low, Cel high) {
        if (low == null || high == null) {
            throw new IllegalArgumentException("Erro: Nós 'low' ou 'high' estão nulos.");
        }

        Pokemons pivot = high.el; // Pivô
        Cel i = low.prev;         // Nó anterior a 'low'

        for (Cel j = low; j != high; j = j.next) {
            if (j.el.getGeneration() < pivot.getGeneration() ||
                (j.el.getGeneration() == pivot.getGeneration() &&
                 j.el.getName().compareTo(pivot.getName()) < 0)) {
                i = (i == null) ? low : i.next;
                swapNodes(i, j);
            }
        }

        i = (i == null) ? low : i.next;
        swapNodes(i, high);
        return i;
    }

    // Método principal do QuickSort
    public void quickSort(Cel low, Cel high) {
        if (low != null && high != null && low != high && low != high.next) {
            Cel pi = partition(low, high);

            quickSort(low, pi.prev);
            quickSort(pi.next, high);
        }
    }

    // Método para iniciar o QuickSort
    public void quickSort() {
        if (first != null && first.next != null) {
            quickSort(first.next, last);
        }
    }
}

