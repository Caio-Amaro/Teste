package Service; // Localização do pacote

// bibliotecas importadas
import static Service.Funcionario.TIPO;
import java.util.ArrayList;
import java.util.List;

// Definição da classe com seus atributos e contrutores
public class Cliente extends Pessoa {
    
    private Integer clienteDesde;
    private double compra;
    private double compraDesconto; 
    public static final String TIPO = "CLIENTE";
    List<Pessoa> cliente = new ArrayList<>();
    
    public Cliente(){}
    
    public Cliente(String nome, Integer ano, Integer rg, Integer id, int clienteDesde, double compra, double compraDesconto) {
        super(nome, ano, rg, id);
        this.clienteDesde = clienteDesde;
        this.compra = compra;
        this.compraDesconto = compraDesconto;   
    }
    
    
    // ************************************************//
    
    //////////////////////////////////////////////
    // MÉTODOS PRINCIPAIS DA CLASSE FUNCIONÁRIO //
    //////////////////////////////////////////////
    
    
    // Método para adicionar objetos na lista
    public void adicionarCliente(Pessoa pessoa ){
        cliente.add(pessoa);
    }
    
    // método remover Não está sendo utilizado mas já está implantado
     public void removerCliente(Pessoa pessoa ){
        cliente.remove(pessoa);
    }
     
    
     // Método para calcular desconto
    public double calcularDesconto (double compra){
        this.compraDesconto = compra;    
        double aux  = compra * 0.10;
        return this.compraDesconto - aux ;
    }
    
    // ********************************************************// 
    

    /////////////////////////////////////////////////////// 
    // MÉTODOS PARA CAPTURAR E LISTAR OS OBJETOS DA LISTA//
    /////////////////////////////////////////////////////// 
    
         
    public void listarCliente(){
        System.out.print(" =================================================== " + " \n " +
                         " **LISTAGEM DE CLIENTES CADASTRADOS E SUAS COMPRAS** " + " \n " + 
                         " ================================================== " + " \n ");
         
        for (Pessoa vai : cliente){
            System.out.print(vai.toString());
        }
    }
    

    @Override  // sobreencrevendo o método "toString
    public String toString(){
        return  "TIPO DE PESSOA: " + TIPO + " \n " +
                "ID: " + this.getId() + " \n " +
                "Nome do Funcionário: " + super.getNome() + " \n " + 
                "Ano de Nascimento: " + super.getAnoNascimento() + " \n " +
                "Número do RG: " + super.getRg() + " \n " + 
                "É cliente desde : " + this.getClienteDesde() + " \n " +
                "Valor da Compra: " + this.getCompra() + " \n " + 
                "Valor da Compra com Desconto: " + this.getCompraDesconto() + " \n ";
    }

    
////////////////////////////// GETTERS AND SETTERS /////////////////////////////

    public Integer getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(Integer clienteDesde) {
        this.clienteDesde = clienteDesde;
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
