package Service;// Localização do pacote

// Bibliotecas importadas
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa { 
    // ATRIBUTOS DA CLASSE MÃE PESSOA
    private String nome;
    private int anoNascimento;
    private int rg;
    private int id;
    public List<Pessoa> lista = new ArrayList<>();
    
    
    public Pessoa(){} // CONSTRUTOR "DEFAULT" PARA FLEXIBILIZAR A INSTANCIAÇÃO DOS OBJETOS
    
    public Pessoa(String nome, Integer ano, Integer rg, Integer id){ // CONSTRUTOR DA CLASSE PESSOA
        this.nome = nome;
        this.anoNascimento = ano;
        this.rg = rg;
        this.id = id;
    }
    
    Scanner entrada = new Scanner(System.in); // CHAMADA DA CLASSE SCANNER PARA PERMITIR ENTRADA DE DADOS
    
//////////////////////////////////    
/////// MÉTODOS PRINCIPAIS ///////
//////////////////////////////////    
    
    public void cadastrarPessoa(){
        do{ 
            System.out.print("Nome da Pessoa : " );
            String nom = entrada.nextLine();
            this.setNome(nom);            
        }while(this.consistirValor(getNome()));
        
        do{
            System.out.print("Ano de Nascimento : " );
            int ano = entrada.nextInt();
            this.setAnoNascimento(ano);
        }while(consistirValor(this.getAnoNascimento()));    //Valida o ano de nascimeto

        do{
            System.out.print("Insira ID : " );
            setId(entrada.nextInt());
        }while(this.consistir(this.getId())); // valida o ID
        
        do{
            System.out.print("RG : " );
            int rgg = entrada.nextInt();
            this.setRg(rgg);            
        }while(this.consistir(this.getRg()));   //Valida o RG
    }
    
     public void adicionarGeral(Pessoa pessoa ){    
        lista.add(pessoa);    
    }
    
    public void listarGeral(){
        System.out.print(" ================================= " + " \n " + 
                         " **** LISTAGEM GERAL DAS VENDAS **** " + " \n " + 
                         " ================================= " + " \n ");
         
        for (Pessoa vai : lista){
            System.out.print(vai.toString());
            System.out.print(" \n \n");
        }
    }
    
   
    ////////////////////////////////////////////////////    
    /////// MÉTODOS PARA VALIDAR INPUT DE DADOS ////////
    ////////////////////////////////////////////////////
    
    
    // Método para consistir entradas de tipo String. Método de sobrecarga
    public boolean consistirValor(String entrada){   
        if(entrada.isEmpty()){    //Verifica se o nome não está vazio
            System.out.print("Erro! Nome não pode ser vazio!");
            return true;
        }
        return false;
    }
    
    
    
    // Método para consistor entradas de valor inteiro relacionado a idade. Método de sobrecarga
    public boolean consistirValor(int idade){
        if(this.getAnoNascimento() <= 1899 || this.getAnoNascimento() > 2021){ // avalia o intervalo da idade
           System.out.print("Erro! Valor não pode ser vazio ou fora dos padrões menor que 1899 ou acima do anoa atual!");
            return true;
        }
        return false;
    }
    
    
    // Método para consistir entrada ponto flutuante. Método de sobregarga
    public boolean consistirValor(double entrada){   
        if(entrada < 0 ){    //Verifica se está abaixo de zero
            System.out.print("Erro! Valor não pode ser negativo!");
            return true;
        }
        return false;
    }
    
    
    // Método para consistir entrada inteira apenas abaixo de zero
    public boolean consistir(int entrada){  
        if(entrada < 0 ){    //Verifica se está abaixo de zero
            System.out.print("Erro! Valor não pode ser negativo!");
            return true;
        }
        return false;
    }
    
    
    
    ////////////////////////////////////
    /////// GETTERS AND SETTERS ////////
    ///////////////////////////////////

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
}
