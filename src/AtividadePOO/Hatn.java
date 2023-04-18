package AtividadePOO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hatn {
    private ArrayList<Functonarto> funcionarios;
    private Functonarto usuarioLogado;
    private HashMap<Integer, Produto> estoque;

    public Hatn() {
        this.funcionarios = new ArrayList<>();
        this.estoque = new HashMap<>();
        this.usuarioLogado = null;
    }
    
    public void criarUsuarioTeste() {
        this.funcionarios.add(new Functonarto(12345, "12345678901", "Douglas"));
    }
        
    public void natn() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite a matrícula do funcionário: ");
			int matricula = scanner.nextInt();

			System.out.print("Digite a senha (CPF) do funcionário: ");
			String senha = scanner.next();

			System.out.print("Digite o nome do funcionário: ");
			String nome = scanner.next();

			this.funcionarios.add(new Functonarto(matricula, senha, nome));
		}
    }

    public void logtn(int matricula, String senha) {
        for (Functonarto funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula && funcionario.getSenha().equals(senha)) {
                this.usuarioLogado = funcionario;
                System.out.println("Login efetuado com sucesso!");
                System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");
                return;
            }
        }

        System.out.println("Matrícula ou senha inválidos!");
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto(0, "Camisa Polo", 50.0, 10);


        System.out.println("Selecione uma opção:");
        System.out.println("1 - Registrar uma venda");
        System.out.println("2 - Alterar o preço de um produto");
        System.out.println("3 - Repor o estoque de um produto");
        System.out.println("4 - Fazer logout");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o código do produto: ");
                int codigo = scanner.nextInt();

                System.out.print("Digite  a quantidade vendida: ");
                int quantidade = scanner.nextInt();

                registrarVenda(codigo, quantidade);
                break;
            case 2:
                System.out.print("Digite o código do produto: ");
                codigo = scanner.nextInt();

                System.out.print("Digite o novo preço:");
                double novoPreco = scanner.nextDouble();
                if (estoque.containsKey(codigo)) {
                    produto = estoque.get(codigo);
                    System.out.println(produto.getPreco());
                    produto.setPreco(novoPreco);
                    System.out.println(produto.getPreco());
                    System.out.println("Preço não encontrado!");
                } else {
                    System.out.println("Preço alterado com sucesso para " + novoPreco);
                }
            case 3:
            	System.out.println("Cadastrar um produto");
                
            	System.out.print("Digite o código do produto: ");
                codigo = scanner.nextInt();

                System.out.print("Digite o novo preço:");
                double novoPreco1 = scanner.nextDouble();
            	estoque.put(codigo, produto);
            	
            	
            	
            break;
        }
        scanner.close();
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

    public void setPreco(int codigo, double novoPreco) {
        if (estoque.containsKey(codigo)) {
            Produto produto = estoque.get(codigo);
            produto.setPreco(novoPreco);
            System.out.println("Preço atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    
    public static void main(String[] args) {
    	 Hatn hatn = new Hatn();
    	 hatn.criarUsuarioTeste();
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (hatn.usuarioLogado == null) {
                System.out.print("Digite a matrícula: ");
                int matricula = scanner.nextInt();

                System.out.print("Digite a senha (CPF): ");
                String senha = scanner.next();

                hatn.logtn(matricula, senha);
            }

            while (true) {
                hatn.menu();
                if (hatn.usuarioLogado == null) {
                    break;
                    
                }
        }
       }
    }
   }