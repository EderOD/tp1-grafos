import java.io.IOException;

public class ex1 {

	public static void main(String[] args) throws IOException {
		Grafo g = ManipuladorFile.ler("file.txt");
		
		System.out.println(g.getClass());
//-------------------------------------------------------------------------
//------Grafo Dirigido-----------------------------------------------------
		if(g instanceof Dirigido) {
			Dirigido f = (Dirigido) g;
			System.out.println("Grau Saida:\t"+f.getGrauSaida(1));
			System.out.println("Grau Entrada:\t"+f.getGrauEntrada(1));
		}
		
		
//-------------------------------------------------------------------------
//------Grafo Dirigido-----------------------------------------------------
		if(g instanceof NaoDirigido) {
			System.out.println("Isolado:\t"+g.isIsolado(1));
			System.out.println("Pendente:\t"+g.isPendente(1));
			System.out.println("Regular:\t"+g.isRegular());
			System.out.println("Complementar:\t"+g.getComplementar());
			System.out.println("Completo:\t"+g.isCompleto());
			System.out.println("Nulo:\t\t"+g.isNulo());
			System.out.println("Adjacente:\t"+g.isAdjacente(1, 2));
			System.out.println("Conexo:\t"+g.isConexo());
		}
		
		
	}

}
