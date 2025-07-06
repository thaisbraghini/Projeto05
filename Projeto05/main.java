package Projeto05;

public class main {

        public static void main(String[] args) {
        MapaCidades mapa = new MapaCidades();

        Cidade c1 = new Cidade("São Sebastião do Paraíso", "MG", 70000);
        Cidade c2 = new Cidade("Itamogi", "MG", 10700);
        Cidade c3 = new Cidade("Monte Santo de Minas", "MG", 20800);
        Cidade c4 = new Cidade("São Tomás de Aquino", "MG" , 6740);
        Cidade c5 = new Cidade("Carrancas", "MG", 5000);

        mapa.adicionarCidade(c1);
        mapa.adicionarCidade(c2);
        mapa.adicionarCidade(c3);
        mapa.adicionarCidade(c4);
        mapa.adicionarCidade(c5);

        mapa.conectarCidades(c1, c2, 30);
        mapa.conectarCidades(c2, c3, 20);
        mapa.conectarCidades(c1, c4, 15);
        // c5 ficará sem conexão

        mapa.listarConexoes(c1);
        System.out.println("----------------------------------------------------------");
        mapa.listarConexoes(c3);

        System.out.println("----------------------------------------------------------");

        System.out.println("\nExiste caminho entre Paraíso e São Tomás de Aquino? " +
                mapa.existeCaminho(c1, c4));
        System.out.println("----------------------------------------------------------");
        System.out.println("Existe caminho entre Paraíso e Carrancas? " +
                mapa.existeCaminho(c1, c5));
        System.out.println("----------------------------------------------------------");
        System.out.println("\nCidades sem conexão:");
        mapa.listarCidadesSemConexao();
        System.out.println("----------------------------------------------------------");
        //Exibir a cidade mais populosa do sistema.
        Cidade maisPopulosa = mapa.MaisPopulosa();
        System.out.println("\nCidade mais populosa: \n" + maisPopulosa.getNome() + " - " + maisPopulosa.getEstado() + " ("  + maisPopulosa.getPopulacao() + " habitantes) " ); 
        System.out.println("----------------------------------------------------------");       
        // caminho entre cidades mais distantes
        mapa.exibirCaminhoComDistancias(c4, c3);
    }


}
