package AtividadePOO;

public class Functonarto {
    private String nome;
    private int matricula;
    private String senha;

    public Functonarto(int matricula, String senha, String nome) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
