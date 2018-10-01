
public class Aresta {
	private int peso;
	
	public Aresta(int p) {
		setPeso(p);
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getPeso() {
		return this.peso;
	}
	@Override
	public String toString() {
		return "peso=" + peso;
	}
	
	
}
