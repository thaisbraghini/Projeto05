package Projeto05;

public class Rota {
    private Cidade destino; 
    private int distancia; 

    public Rota (Cidade destino, int distancia){
        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    @Override
    public String toString(){
        return " -> " + destino.getNome() + " ( " + distancia + " Km" + " )";
    }

}
