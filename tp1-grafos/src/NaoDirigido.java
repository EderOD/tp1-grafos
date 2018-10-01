
public class NaoDirigido extends Grafo{
	public NaoDirigido(int vs) {
		super(vs);
	}
	
	public void inserirVertices(int v1, int v2, int peso, int dir) {
		this.setVertices(v1, v2, peso);
		this.setVertices(v2, v1, peso);
	}
	
	public int getGrau (int v1) {
		int cont=0;
		for(int i=0; i<this.getTam(); i++) {
			if(this.arestas[i][v1-1]!=null) {
				cont = cont + this.arestas[i][v1-1].size();
			}
		}
		return cont;
	}
	
	public boolean isIsolado (int v1) {
		for(int i=0; i<this.getTam(); i++) {
			if(this.arestas[i][v1-1]!=null && i!=v1-1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isPendente (int v1) {
		if(this.getGrau(v1)==1) {
			return true;
		}
		return false;
	}
	
	public boolean isRegular () {
		for(int i=1; i<this.getTam()-1; i++) {
			if(this.getGrau(i)!=this.getGrau(i+1)) {
				return false;
			}
		}
		return true;
	}

	public Grafo getComplementar() {
		Grafo complementar = new NaoDirigido(this.getTam());
		for(int i=0; i<this.getTam(); i++) {
			for(int j =0; j<this.getTam(); j++)
				if(arestas[i][j]==null) {										
					if(i!=j) {						
						complementar.setVertices(i+1, j+1, 1);						
					}
			    }
		}
		return complementar;
	}
	
	public boolean isCompleto() {				
		for(int i=0; i<arestas.length; i++) {						
			for(int j=0; j<arestas.length; j++) {								
				if(arestas[i][j]!=null) {
					
					continue;			
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isNulo() {
		for(int i=0; i<arestas.length; i++) {
			for(int j=0; j<arestas.length; j++) {
				if(arestas[i][j]==null) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isAdjacente(int v1,int v2) {
		if(this.arestas[v1-1][v2-1]!=null) { //verifica na matriz de adj se existe ligação entre os dois vertices
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isConexo() {
		int vet[] = new int[getTam()-1];
		int valida;
		for(int i=0; i<getTam(); i++) {
			//vet[i] = 0;
			for(int j=0; j<getTam(); j++) {
				if(j>i) {
					if(this.arestas[i][j]!=null) {
						vet[i] = vet[i] + this.arestas[i][j].size();
					}
				}
			}
		}
		valida = 1;
		for(int i=0; i<getTam()-1; i++) {
			valida = valida * vet[i];
			vet[i] = 0;
		}
		if(valida!=0) {
			return true;
		}
		
		for(int i=0; i<getTam(); i++) {
			//vet[i] = 0;
			for(int j=0; j<getTam(); j++) {
				if(j>i) {
					if(this.arestas[i][j]!=null) {
						vet[j] = vet[j] + this.arestas[i][j].size();
					}
				}
			}
		}
		valida = 1;
		for(int i=0; i<getTam()-1; i++) {
			valida = valida * vet[i];
			vet[i] = 0;
		}
		if(valida!=0) {
			return true;
		}
		return false;
		
	}

}
