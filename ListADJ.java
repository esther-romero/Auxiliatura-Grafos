import java.util.ArrayList;

public class ListADJ extends Grafo {
    ArrayList<Arista> [] adj;
    private boolean dirigido;
    private int numNodos;
    private int numEdges;
    
    public static void main(String [] args){
        ListADJ ladj = new ListADJ(true,3);
        ladj.run();
    }
    
    private void run(){
        adj = new ArrayList[numNodos];
        for (int i =0;i<numNodos;i++) {
            adj[i] = new ArrayList<>();
        }
        
        insertarArista(1,2);
        insertarArista(1,0,4);
        
        //System.out.println(getPesoArista(10,8));
        
        ArrayList<Arista> prueba = getAdyacentes(1);
        for(Arista b : prueba){
            System.out.println(b.getDestino());
        }
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
        try{
            for (Arista u : adj[origen]) {
                if(u.getDestino()==destino)
                    return true;
            }
        }catch (Exception e){
            System.out.println("El origen esta fuera de rango "+ e.getMessage());
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
            System.out.println("El origen esta fuera de rango "+ e.getMessage());
        }
        return -1;        
    }
    
    public void insertarArista(int i, int j){
        if(dirigido)
            adj[i].add(new Arista(j,0));
        else{
            adj[i].add(new Arista(j,0));
            adj[i].add(new Arista(j,0));
        }
    }
    
    public void insertarArista(int i, int j, double peso){
        if(dirigido)
            adj[i].add(new Arista(j,peso));
        else{
            adj[i].add(new Arista(j,peso));
            adj[i].add(new Arista(j,peso));
        }
    }
    
    public ArrayList<Arista> getAdyacentes(int vertice){
        ArrayList<Arista> res = new ArrayList<>();
        try{
            for (Arista u : adj[vertice]) {
                res.add(u);
            }
        }catch (Exception e){
            System.out.println("El origen esta fuera de rango "+ e.getMessage());
        }
        return res;        
    }/// valor de retorno puede ser diferente
    
    /*
    public void dibujarGrafo(){}
    public boolean quitarArista(int origen, int destino){
        return false;
    }
    public boolean esCompleto(){
        return false;
    }
    /*
    public boolean esGrafoCiclo(){
        return false;
    }
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
