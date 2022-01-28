import java.util.*;
import java.time.*;

public class Questao2 {
  public static void main(String args[]) {

    Empresa apple = new Empresa("apple", "123.456.789");
    apple.CriarDepartamento("PeD");
    apple.CriarDepartamento("Marketing");
    apple.AdicionarFunc("PeD", "Jorge", 1000, new Date());
    apple.AdicionarFunc("Marketing", "Adorian Barbosa", 10000, new Date());
  }
}

class Empresa {
  private String nome;
  private String CNPJ; // Em string para colocar "-" e "."
  private Departamento departs[] = new Departamento[10];

  public Empresa(String nome, String CNPJ) {
    this.nome = nome;
    this.CNPJ = CNPJ;
  }

  public void CriarDepartamento(String nomeDep) {
    int i;
    for (i = 0; i <= 9; i++) {
      if (departs[i] == null) {
        departs[i] = new Departamento(nomeDep);
        i = 11;
      }
    }
    if (i == 10) {
      System.out.println("Limite de departamentos!");
    }
  }

  public void AdicionarFunc(String nomeDep, String nome, double salario, Date data) {
    for (int i = 0; i <= 9; i++) {
      if (departs[i].getNome() == nomeDep) {
        departs[i].AdicionarFuncionario(nome, salario, data);
      }
    }
  }
}

class Departamento {
  private String nome;
  private Funcionario funcs[] = new Funcionario[100];

  public Departamento(String nomeDep) {
    this.nome = nomeDep;
  }

  public String getNome() {
    return nome;
  }

  public void AdicionarFuncionario(String nome, double salario, Date data) {
    int i;
    for (i = 0; i <= 100; i++) {
      if (funcs[i] == null) {
        funcs[i] = new Funcionario(nome, salario, data);
        i = 102;
      }
    }
    if (i == 102) {
      System.out.println("Limite de funcionarios por departamento!");
    }
  }
}

class Funcionario {
  private String nome;
  private double salario;
  private Date dataEmissao;

  public Funcionario(String nome, double salario, Date data) {
    this.nome = nome;
    this.salario = salario;
    this.dataEmissao = data;
  }

}
