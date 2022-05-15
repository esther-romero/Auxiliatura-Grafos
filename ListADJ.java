import java.util.ArrayList;

public class ListADJ extends Grafo {
    ArrayList<Arista> [] adj;
    private boolean dirigido;
    private int numNodos;
    private int numEdges;
    
    public static void main(String [] args){
        ListADJ ladj = new ListADJ(false,4);
        ladj.run();
    }
    
    private void run(){
        adj = new ArrayList[numNodos];
        for (int i =0;i<numNodos;i++) {
            adj[i] = new ArrayList<>();
        }
        
        insertarArista(0,1);
        insertarArista(0,3);
        insertarArista(0,2);
        insertarArista(1,3);
        insertarArista(1,2);
        insertarArista(2,3);

        dibujarGrafo();
        //quitarArista(0,1);
        //quitarArista(1,0);
        dibujarGrafo();
        System.out.println("el grafo es completo: "+esCompleto());
        System.out.println("Existe peso entre el vertice 1,6: "+getPesoArista(1,6));
        System.out.println("Existe arista entre el vertice 1,6: "+existeArista(1,6));
        
        /*
        ArrayList<Arista> prueba = getAdyacentes(1);
        for(Arista b : prueba){
            System.out.println(b.getDestino());
        }*/
    }
    
    public ListADJ (boolean dirigido, int numNodos){
        this.dirigido = dirigido;
        this.numNodos = numNodos;
    }
     
    public int getNumVertices(){
        return numNodos;
    }
     
    public int getNumAristas(){
        return numEdges;
    } 
    
    public boolean existeArista(int origen, int destino) {
        if(getPesoArista(origen, destino) != -1){
            return true;
        }
        return false;
    }
     
    public double getPesoArista(int i, int j){
        try{
            for (Arista u : adj[i]) {
                if(u.getDestino()==j)
                    return u.getPeso();
            }
        }catch (Exception e){
            System.out.println("El vertice origen esta fuera de rango "+ e.getMessage());
        }
        return -1;        
    }
    
    public void insertarArista(int i, int j){
        insertar(i,j,0);
    }
    
    public void insertarArista(int i, int j, double peso){
        insertar(i,j,peso);
    }
    
    private void insertar(int i, int j, double p){
        adj[i].add(new Arista(j,p));
        if(!dirigido)
            adj[j].add(new Arista(i,p)); 
        
    }

    public ArrayList<Arista> getAdyacentes(int vertice){
        ArrayList<Arista> res = new ArrayList<>();
        try{
            for (Arista u : adj[vertice]) {
                res.add(u);
            }
        }catch (Exception e){
            System.out.println("El vertice origen esta fuera de rango "+ e.getMessage());
        }
        return res;        
    }/// valor de retorno puede ser diferente
    
    public void dibujarGrafo(){
        int n=0;
        System.out.println("\nNodo -- peso -- Nodo\n");
        for(int i=0; i<adj.length;i++){
            for (Arista u : adj[i]){
                System.out.println(" "+i+"----"+u.getPeso()+"---->"+u.getDestino());
            }
        }
    }
    
    public boolean quitarArista(int origen, int destino){
        boolean res =  false;
        try{
            for(Arista u:adj[origen]){
                if(u.getDestino()==destino){
                    res = adj[origen].remove(u);
                    return res;
                }
            }
        }catch(Exception e){
            System.out.println("El vertice origen esta fuera de rango "+ e.getMessage());
        }
        return res;
    }
    
    public boolean esCompleto(){
        int tamanio = adj[0].size();
        for(int i=1;i<adj.length;i++){
            int size = adj[i].size();
            if(tamanio != size)
                return false;
        }
        return true;
    }
    
    public boolean esGrafoCiclo(){
        return false;
    }
    
    /*
    public boolean esGrafoRueda(){
        return false;
    }
    public boolean existeBucle(){
        return false;
    }*/
    
    
    public class Arista {
        private int    destino;
        private double peso;

        public Arista(int destino,double peso){
            this.destino = destino;
            this.peso    = peso;
        }
        
        public int getDestino(){
            return destino;
        }
        
        public double getPeso(){
            return peso;
        }
    }
}
