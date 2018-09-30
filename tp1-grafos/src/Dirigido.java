
public class Dirigido extends Grafo {

	public Dirigido(int vs) {
		super(vs);
		// TODO Auto-generated constructor stub
	}
	
	public void inserirVertices(int v1, int v2, int peso, int dir) {
		if(dir == 1) {
			this.setVertices(v1, v2, peso);
		}
		else if(dir == -1) {
			this.setVertices(v2, v1, peso);
		}
		
	}
	public int getGrauEntrada(int v1) {
		 int grau=0;
		for(int j =0;j<this.getTam(); j++) {
			if(this.arestas[v1][j]!=null) {
				grau=grau+arestas[v1][j].size();
			}
		}
		return grau;
		
	}
	
	public int getGrauSaida(int v1) {
			int grau=0;
			for(int j =0;j<this.getTam(); j++) {
				if(this.arestas[j][v1]!=null) {
					grau=grau+arestas[j][v1].size();
				}
			}
			return grau;
	}

}
