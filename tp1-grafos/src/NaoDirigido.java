
public class NaoDirigido extends Grafo{
	public NaoDirigido(int vs) {
		super(vs);
	}
	
	public void inserirVertices(int v1, int v2, int peso, int dir) {
		this.setVertices(v1, v2, peso);
		this.setVertices(v2, v1, peso);
	}

}
