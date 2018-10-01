import java.util.ArrayList;
import java.util.Arrays;


public abstract class Grafo {
	protected ArrayList[][] arestas;
	
	private int tam = 0;
	
	public Grafo(int vs) {
		arestas = new ArrayList[vs][vs];
		tam = vs;
	}
	
	public void setVertices(int v1, int v2, int peso) {
		this.arestas[v1-1][v2-1] = new ArrayList<Aresta>();
		this.arestas[v1-1][v2-1].add(new Aresta(peso));
	}
	
	public int getTam() {
		return this.tam;
	}

	@Override
	public String toString() {
		StringBuilder valor = new StringBuilder();
		valor.append("\nGrafo: \n");
		for(int i=0; i<this.tam; i++) {
			for(int j=0; j<this.tam; j++) {
				if(arestas[i][j]!= null) {
					ArrayList<Aresta> arrayList = arestas[i][j];
					for (int k = 0; k < arrayList.size(); k++) {
						Aresta a = arrayList.get(k);
						valor.append("Vertice "+(i+1)+" -----\t     P:"+a.getPeso()+"\t----> Vertice "+(j+1)+"\n");
					}
				
				}
			}
		}
		
		return valor.toString();
	}
	
	


}
