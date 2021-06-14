package Service; // Localização do pacote

// bibliotecas importadas
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definição da classe com seus atributos e contrutores
public class Funcionario extends Pessoa {
    private double salario;
    private double compra;
    private double compraDesconto;
    public static final String TIPO = "FUNCIONARIO";
    List<Pessoa> funcionario = new ArrayList<>();
    
    
    //Construtores
    public Funcionario(){}
    
    public Funcionario(String nome, Integer ano, Integer rg, Integer id, double salario, double compra, double compraDesconto) {
        super(nome, ano, rg, id);
        this.salario = salario;
        this.compra = compra;
        this.compraDesconto = compraDesconto;
    }
    
    Scanner entrada = new Scanner(System.in); // Classe para liberar entrada de dados
    
    
    // ************************************************//
    
    //////////////////////////////////////////////
    // MÉTODOS PRINCIPAIS DA CLASSE FUNCIONÁRIO //
    //////////////////////////////////////////////
    
    
    // Método para adicionar objetos na lista
    public void adicionarFuncionario(Pessoa pessoa ){ 
        funcionario.add(pessoa);
    }
    
    // método remover não está sendo utilizado mas já está implantado
     public void removerFuncionario(Pessoa pessoa ){
        funcionario.remove(pessoa);
    }
     
     // Método para calcular desconto
    public double calcularDesconto (double compra){
        this.compraDesconto = compra;    
        double aux  = compra * 0.30;
        return this.compraDesconto - aux ;
    }
    
    // ********************************************************// 
    

    /////////////////////////////////////////////////////// 
    // MÉTODOS PARA CAPTURAR E LISTAR OS OBJETOS DA LISTA//
    /////////////////////////////////////////////////////// 
    
    public void listarFuncionario(){
        System.out.print(" ================================= " + " \n " + 
                         " **** LISTAGEM DE FUNCIONÁRIO **** " + " \n " + 
                         " ================================= " + " \n ");
         
        for (Pessoa vai : funcionario){
            System.out.print(vai.toString());
        }
    }
    
    @Override
    public String toString(){
        return  "TIPO DE PESSOA: " + TIPO + " \n " +
                "ID: " + this.getId() + " \n " +
                "Nome do Funcionário: " + super.getNome() + " \n " + 
                "Ano de Nascimento: " + super.getAnoNascimento() + " \n " +
                "Número do RG: " + super.getRg() + " \n " + 
                "Salário do Funcionário: " + this.getSalario() + " \n " +
                "Valor da Compra: " + this.getCompra() + " \n " + 
                "Valor da Compra com Desconto: " + this.getCompraDesconto() + " \n ";
    }
    
  // ***************************************************************************************//
    
  ///////////////////////
  // GETTERS E SETTERS //
  ///////////////////////  

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
   
    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }

    public double getCompraDesconto() {
        return compraDesconto;
    }

    public void setCompraDesconto(double compraDesconto) {
        this.compraDesconto = compraDesconto;
    }   
}

