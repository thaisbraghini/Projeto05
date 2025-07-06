package Projeto05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MapaCidades {
    private TreeSet<Cidade> cidades = new TreeSet<>();
    private HashMap<Cidade , Set<Rota>> rotas = new HashMap<>();

    public void adicionarCidade(Cidade cidade){
        cidades.add(cidade);
        rotas.putIfAbsent(cidade, new HashSet<>());
    }
    public void conectarCidades(Cidade origem, Cidade destino, int distancia){
        if (!rotas.containsKey(origem) || !rotas.containsKey(destino)){
            System.out.println("Alguma das cidades nao foi encontrada no mapa!!");
        return;
        }
        rotas.get(origem).add(new Rota(destino, distancia));
        rotas.get(destino).add(new Rota(origem, distancia));
    }
    public void listarConexoes(Cidade cidade){
        Set<Rota> rota = rotas.get(cidade);
        System.out.println(" Conexoes de " + cidade.getNome() + " - " + cidade.getEstado() + ": " );
        if (rota == null || rota.isEmpty()){
            System.out.println(" Sem conexoes! ");
        }
        else{
            for (Rota rotas: rota){
                System.out.println(rotas);
            }
        }
    }
    public boolean existeCaminho(Cidade origem, Cidade destino){
        Set<Cidade> visitadas = new HashSet<>();
        return busca (origem, destino , visitadas);
    }
    private boolean busca(Cidade atual, Cidade destino, Set<Cidade> visitadas){
        if (atual.equals(destino))
        return true;
        visitadas.add(atual);
        for (Rota rota : rotas.getOrDefault(atual, Set.of())){
            if (visitadas.contains(rota.getDestino())){
                if (busca(rota.getDestino(), destino, visitadas)) 
                return true;
            }
        }
        return false;        
    }
    public void listarCidadesSemConexao(){
        for (Cidade cidade : cidades){
            Set<Rota> rota = rotas.get(cidade);
            if (rotas == null || rota.isEmpty()){
                System.out.println(cidade);
            }
        }
    }
    //Exibir a cidade mais populosa do sistema.
    public Cidade MaisPopulosa(){
        return cidades.stream().max(Comparator.comparingInt(Cidade::getPopulacao)).orElse(null) ;
    }
    // caminho entre cidades mais distantes
    public List<Cidade> caminhoEntreCidades(Cidade origem, Cidade destino){
        List<Cidade> caminho = new ArrayList<>();
        Set<Cidade> visitadas = new HashSet<>(); 
        if (buscaCaminho(origem, destino, visitadas, caminho)){
            return caminho;
        }
        return List.of();
    }
    private boolean buscaCaminho(Cidade atual, Cidade destino, Set<Cidade> visitadas, List<Cidade> caminho){
        caminho.add(atual);
        visitadas.add(atual);
        if (atual.equals(destino))
        return true;
        for (Rota rota : rotas.getOrDefault(atual, Set.of())){
            if (!visitadas. contains(rota.getDestino())){
                if (buscaCaminho(rota.getDestino() , destino, visitadas, caminho)){
                    return true;
                }
                }
            }
            caminho.remove(caminho.size()-1);
            return false;
        }
        public void exibirCaminhoComDistancias(Cidade origem, Cidade destino){
                List<Cidade> caminho = caminhoEntreCidades(origem, destino);
        if (caminho.isEmpty()){
            System.out.println(" Nenhum caminho encontrado entre" + origem.getNome() + " e " + destino.getNome());
            return;
        }

        int distanciaTotal = 0; 
        System.out.println(" Caminho entre " + origem.getNome() + " e " + destino.getNome() + ": ");
        
        for (int i = 0; i < caminho.size() -1; i++){
            Cidade atual = caminho.get(i);
            Cidade proxima = caminho.get(i +1) ;
            int distancia = encontrarDistancia(atual, proxima);
            distanciaTotal += distancia;
        
        System.out.println(" - De " + atual.getNome() + " para " + proxima.getNome() + ": " + distancia + " km");
        }
        System.out.println("----------------------------------------------------------");
        System.out.println(" Distancia total: " + distanciaTotal + " km");
    }
    private int encontrarDistancia(Cidade origem, Cidade destino){
        for (Rota rota : rotas.getOrDefault(origem, Set.of())){
            if (rota.getDestino().equals(destino)){
                return rota.getDistancia();
            }
        }
        return 0; // caso não encontre nenhuma rota 
    }
}
    


