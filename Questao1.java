import java.util.*;
import java.time.*;

class Questao1 {
  public static void main(String[] args) {
    Agenda agenda = new Agenda();

    agenda.armazenaPessoa("Cleytin", 24, 2.35);
    agenda.armazenaPessoa("Matusalem", 934, 1.65);
    System.out.println(agenda.buscaPessoa("Cleytin"));
    agenda.imprimeAgenda();
    agenda.imprimePessoa(1);
    agenda.removePessoa("Cleytin");
    agenda.imprimeAgenda();
  }
}

class Pessoa {
  private String nome = "";
  private Date dataNascimento;
  private double altura;
  private int idade;

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getIdade() {
    return idade;
  }

  public void setNome(String name) {
    this.nome = name;
  }

  public void setData(Date date) {
    this.dataNascimento = date;
  }

  public void setAltura(double height) {
    this.altura = height;
  }

  public String getNome() {
    return nome;
  }

  public Date getData() {
    return dataNascimento;
  }

  public double getAltura() {
    return altura;
  }

  public void imprimeTudo() {
    System.out.println("Nome: " + nome);
    System.out.println("Data de nascimento: " + dataNascimento);
    System.out.println("Altura: " + altura);
  }

  public int calcAge() {
    Calendar dateOfBirth = new GregorianCalendar();
    dateOfBirth.setTime(dataNascimento);
    Calendar today = Calendar.getInstance();
    int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
    this.idade = age;
    return age;
  }
}

class Agenda {
  private Pessoa pessoas[] = new Pessoa[10];

  public Agenda() {
    for (int i = 0; i <= 9; i++) {
      pessoas[i] = new Pessoa();
    }
  }

  public void armazenaPessoa(String nome, int idade, double altura) {
    for (int i = 0; i <= 9; i++) {
      if (pessoas[i].getNome() == "") {
        pessoas[i].setNome(nome);
        pessoas[i].setAltura(altura);
        pessoas[i].setIdade(idade);
        i = 10;
      }
    }
  }

  public void removePessoa(String nome) {
    for (int i = 0; i < 10; i++) {
      if (pessoas[i].getNome() == nome) {
        pessoas[i].setNome("");
        pessoas[i].setAltura(0);
        pessoas[i].setIdade(0);
        i = 10;
      }
    }
  }

  public int buscaPessoa(String nome) {
    for (int i = 0; i < 10; i++) {
      if (pessoas[i].getNome() == nome) {
        return i;
      }
    }
    return -1;
  }

  public void imprimeAgenda() {
    for (int i = 0; i < 10; i++) {
      pessoas[i].imprimeTudo();
      System.out.println("");
    }
  }

  public void imprimePessoa(int index) {
    pessoas[index].imprimeTudo();
  }
}