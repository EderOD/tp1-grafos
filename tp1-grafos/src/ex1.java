import java.io.IOException;

public class ex1 {

	public static void main(String[] args) throws IOException {
		Grafo g = ManipuladorFile.ler("file.txt");
		
		System.out.println(g.getClass());
		System.out.println(g.toString());
//-------------------------------------------------------------------------
//------Grafo Dirigido-----------------------------------------------------
		if(g instanceof Dirigido) {
			Dirigido f = (Dirigido) g;
			System.out.println("Grau Saida:\t"+f.getGrauSaida(1));
			System.out.println("Grau Entrada:\t"+f.getGrauEntrada(1));
		}
		
		
//-------------------------------------------------------------------------
//------Grafo Nao Dirigido-----------------------------------------------------
		if(g instanceof NaoDirigido) {
			NaoDirigido f = (NaoDirigido) g;
			System.out.println("Isolado:\t"+f.isIsolado(1));
			System.out.println("Pendente:\t"+f.isPendente(1));
			System.out.println("Regular:\t"+f.isRegular());
			System.out.println("Completo:\t"+f.isCompleto());
			System.out.println("Nulo:\t\t"+f.isNulo());
			System.out.println("Adjacente:\t"+f.isAdjacente(1, 2));
			System.out.println("Conexo: \t"+f.isConexo());
			System.out.println("\nComplementar:\t"+f.getComplementar().toString());
		}

	}

}
