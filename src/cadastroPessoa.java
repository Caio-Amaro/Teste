//Importa as bibliotecas
import Service.Cliente;
import Service.Funcionario;
import Service.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class cadastroPessoa {
    public static void main(String[] args) {
        //Declara as classes, listas e outros
        Scanner entrada = new Scanner(System.in);
        Funcionario func1 = new Funcionario();
        Cliente cliente = new Cliente();
        Pessoa pessoa = new Pessoa();
        List<Pessoa> lista = new ArrayList<>();
        
        int prod;   //Declara essa variável para ser usada em toda a classe. Declarar dentro do Do-While faz com que ele somente seja visível nesse bloco
        char tipo;
        
        
        
        //Título do programa
        System.out.println( " ============================================ ");
        System.out.println( " +++  - MÓDULO DE DESCONTO LOJA BARATÃO - +++ ");
        System.out.println( " ============================================ ");
        
        do{
            System.out.println("Quantos vendas deseja cadastrar?");
            prod = entrada.nextInt();
            if(prod <= 0 || prod >= 10){ //Valida quantidade de produtos
                System.out.println("Erro! Somente pode-se cadastrar de 1 a 9 vendas!");
            }
        }while(prod <= 0 || prod >= 10);
        
        
        for (int i = 1; i <= prod; i++){
            //entrada.nextLine();
            pessoa.cadastrarPessoa();
            
            entrada.nextLine();
            
            do{
                System.out.println("Cadastro número " + i + ":");
                System.out.println("*-------------------------------------------------------------------------------* ");
                System.out.println("|A venda é para cliente ou funcionário?\n|FUNCIONÁRIO -> f\n|CLIENTE -> c ");
                System.out.println("*-------------------------------------------------------------------------------*");
                tipo = entrada.next().charAt(0); //Recebe o caracterer para decidir o tipo do livro


                // CONDIÇÃO QUE PODE VIRAR UM MÉTODO NAS CLASSES ESTENDIDAS FUNCIONÁRIOS E CLIENTES
                switch (tipo) {
                    case 'f':
                        {
                            System.out.print(" Salário do Funcionário R$: ");
                            Double salario = entrada.nextDouble();
                            System.out.print(" Qual foi o valor da compra R$: ");
                            Double compra = entrada.nextDouble();
                            // Lista com a inclusão apenas de objetos Funcionários
                            func1.adicionarFuncionario(new Funcionario(pessoa.getNome(), pessoa.getAnoNascimento(), pessoa.getRg(), pessoa.getId(), salario, compra, func1.calcularDesconto(compra)));
                            // Para efeito de exercício criamos uma lista universal que inclui objetos Funcionário como Clientes
                            pessoa.adicionarGeral(new Funcionario(pessoa.getNome(), pessoa.getAnoNascimento(), pessoa.getRg(), pessoa.getId(), salario, compra, func1.calcularDesconto(compra)));
                            break;
                        }
                    case 'c':
                        {
                            System.out.print(" É cliente desde o ano : ");
                            int desde = entrada.nextInt();
                            System.out.print(" Qual foi o valor da compra R$: ");
                            Double compra = entrada.nextDouble();
                            // Lista com a inclusão apenas de objetos Clientes
                            cliente.adicionarCliente(new Cliente(pessoa.getNome(), pessoa.getAnoNascimento(), pessoa.getRg(), pessoa.getId(), desde, compra, cliente.calcularDesconto(compra)));
                            // Para efeito de exercício criamos uma lista universal que inclui objetos Funcionário como Clientes
                            pessoa.adicionarGeral(new Cliente(pessoa.getNome(), pessoa.getAnoNascimento(), pessoa.getRg(), pessoa.getId(), desde, compra, cliente.calcularDesconto(compra)));
                            break;
                        }
                    default:
                        System.out.println("Erro! Nenhuma das opções válidas foi selecionada! Tente novamente!\n\n\n");
                        break;
                }
            }while(!(tipo == 'f' || tipo == 'c'));  //Verifica se nenhuma das opções válidas foi selecionada, então tenta novamente.             
        }
     
        // listagem de Funcionários e Compras
        func1.listarFuncionario();            
        cliente.listarCliente();
        
        ///////////////////////////////////////////////////////////////////////////////////////////////
        // É possível tratar as listas para aparacerem apenas caso possuam objetos com condicionais ///
        // Possível criar um "Case" para escolher qual listagen deseja mostrar ///////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////
        
        // Lista universal
        pessoa.listarGeral(); 
    }
}