import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipuladorFile {
	public static Grafo ler(String path) throws IOException {
		Grafo g;
		Dirigido d = new Dirigido(0);
		NaoDirigido f = new NaoDirigido(0);
		int vertices = 0;					// numero de vertices no grafo
		int inteiros[] = new int[4];		// vetor = [verticeU, verticeV, peso, direção]
		boolean criado = true;
		boolean dirigido = true;
		String aux = "";
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(path)); 
			String linha = "";
			int i = 0;
			linha = buffRead.readLine();		// Primeira linha é lida
			vertices = Integer.parseInt(linha); // Primeiro valor é do numero de vertices, converte para inteiro
			while ((linha = buffRead.readLine()) != null) {		// ler todas as linhas do arquivo
				aux = "";
				i = 0;
				System.out.println(linha);	
				for(char c : linha.toCharArray()) {		// A linha é dividida char a char para guardar no vetor
					if(c == ';') {
						inteiros[i++] = Integer.parseInt(aux);
						aux = "";
						
					} else if (c == ' ') {
						continue;
					} else {
						aux = aux + c;		// Concatena os char na string porque pode ser um numero mais de 1 digito
					}
				}
				inteiros[i] = Integer.parseInt(aux);
				if ((inteiros[3] == 1 || inteiros[3] == -1) && criado) {
					
					d = new Dirigido(vertices);
					d.inserirVertices(inteiros[0],inteiros[1], inteiros[2], inteiros[3]);
					criado = false;
					dirigido = true;
					
				}
				else if(criado){
					f = new NaoDirigido(vertices);
					f.inserirVertices(inteiros[0],inteiros[1], inteiros[2], inteiros[3]);
					criado = false;
					dirigido = false;
				}
				if(dirigido) {
					d.inserirVertices(inteiros[0],inteiros[1], inteiros[2], inteiros[3]);
				}
				else {
					f.inserirVertices(inteiros[0],inteiros[1], inteiros[2], inteiros[3]);
				}
				
				
			}
			System.out.println("Grafo gerado com suceso!!!!");
			System.out.println("============================");
			
			buffRead.close();
			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s. \n", e.getMessage());
		}
		if(dirigido) {
			return d;
		}
		else {
			return f;
		}
	}
}
