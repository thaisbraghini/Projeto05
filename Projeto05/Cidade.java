package Projeto05;

import java.util.Objects;

public class Cidade implements Comparable<Cidade>{
    private String nome;
    private String estado;
    private int populacao;

    public Cidade(String nome, String estado, int populacao){
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    @Override
    public int compareTo(Cidade outraCidade) {
        return this.nome.compareToIgnoreCase(outraCidade.getNome());
    }
    @Override
    public String toString(){
        return nome + " - " + estado + " - " + populacao + " habitantes";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cidade)) return false;
        Cidade cidade = (Cidade) obj;
        return nome.equalsIgnoreCase(cidade.nome);
    }
    @Override
    public int hashCode(){
        return Objects.hash(nome.toLowerCase());
    }



    


}
