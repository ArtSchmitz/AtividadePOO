package AtividadePOO;
import java.util.HashMap;
import java.util.Scanner;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public class Hatn {
        private HashMap<Integer, Functonarto> funcionarios;
        private HashMap<Integer, Produto> estoque;
        private Scanner scanner;

        public Hatn() {
            this.funcionarios = new HashMap<>();
            this.estoque = new HashMap<>();
            this.scanner = new Scanner(System.in);
        }

        public void cadastrarFuncionario(int matricula, String senha, String nome) {
        	Functonarto funcionario = new Functonarto(matricula, senha, nome);
            funcionarios.put(matricula, funcionario);
        }

        public boolean fazerLogin(int matricula, String senha) {
            if (funcionarios.containsKey(matricula)) {
            	Functonarto funcionario = funcionarios.get(matricula);
                if (funcionario.getSenha().equals(senha)) {
                    System.out.println("Bem-vindo, " + funcionario.getNome() + "!");
                    return true;
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else {
                System.out.println("Matrícula não encontrada.");
            }
            return false;
        }

        public void fazerLogout() {
            System.out.println("Logout realizado com sucesso.");
        }

        public void exibirMenu() {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Registrar uma venda");
            System.out.println("2 - Alterar o preço de um produto");
            System.out.println("3 - Repor o estoque de um produto");
            System.out.println("4 - Fazer logout");
        }

        public void registrarVenda(int codigo, int quantidade) {
            if (estoque.containsKey(codigo)) {
                Produto produto = estoque.get(codigo);
                if (produto.getEstoque() >= quantidade) {
                    produto.diminuirEstoque(quantidade);
                    System.out.println("Venda registrada com sucesso!");
                } else {
                    System.out.println("Estoque insuficiente.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
   
        public void alterarPreco(int codigo) {
            System.out.print("Digite o novo preço: ");
            double novoPreco = scanner.nextDouble();
            if (estoque.containsKey(codigo)) {
                Produto produto = estoque.get(codigo);
                produto.setPreco(novoPreco);
                System.out.println("Preço atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
          }
        }

	public void diminuirEstoque(int quantidade) {
		if (quantidade > 0 && quantidade <= this.estoque) {
            this.estoque -= quantidade;
        } else {
            System.out.println("Quantidade inválida.");
        }
		
	}
  }
