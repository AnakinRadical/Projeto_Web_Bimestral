// Classe Piloto.java
public class Piloto {
    private String nome;
    private int idade;
    private String equipe;

    // Construtor
    public Piloto(String nome, int idade, String equipe) {
        this.nome = nome;
        this.idade = idade;
        this.equipe = equipe;
    }

    public Piloto(){

    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    // Método para exibir informações do piloto
    public void exibirInformacoes() {
        System.out.println("Piloto: " + nome + " (" + idade + " anos), Equipe: " + equipe);
    }
}