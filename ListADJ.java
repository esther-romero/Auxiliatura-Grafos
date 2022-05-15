import java.util.ArrayList;

public class ListADJ extends Grafo {
    ArrayList<Arista> [] adj;
    private boolean dirigido;
    private int numNodos;
    private int numEdges;
    private boolean[] vis;
    private int recorrido[];
    
    
    public static void main(String [] args){
        ListADJ ladj = new ListADJ(true,5);
        ladj.run();
    }
    
    private void run(){
        adj = new ArrayList[numNodos];
        for (int i =0;i<numNodos;i++) {
            adj[i] = new ArrayList<>();
        }
        /*
        insertarArista(0,1);
        insertarArista(0,3);
        insertarArista(0,2);
        insertarArista(1,3);
        insertarArista(1,2);
        insertarArista(2,3);*/

        insertarArista(0,1);
        insertarArista(0,3);
        insertarArista(2,1);
        insertarArista(4,1);
        insertarArista(3,4);



        vis = new boolean [numNodos];
        recorrido  = new int [numNodos];

        dibujarGrafo();
        //quitarArista(0,1);
        //quitarArista(1,0);
        //dibujarGrafo();
        System.out.println("es completo: "+ esCompleto() );
        System.out.println("existe bucle: "+ existeBucle() );
        System.out.println("Es grafo ciclo: "+ esGrafoCiclo() );
        System.out.println("Numero de Aristas: "+ getNumAristas() );
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
        numEdges++;
        if(!dirigido){
            adj[j].add(new Arista(i,p)); 
            numEdges++;
        }
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
        return ((numNodos*(numNodos-1))==numEdges)? true:false;
    }

    public boolean existeBucle(){
        for(int i=0;i<adj.length;i++){
            for(Arista a: adj[i]){
                if(a.getDestino()==i)
                    return true;
            }
        }
        return false;
    }
    
    public boolean esGrafoCiclo(){
        boolean res=false;
        if(!dirigido){
            res = numEdges == (numNodos*2);
        }else {
            if(numEdges == numNodos){
                int i = 0;
                while(!res && i<numNodos){
                    recorrido[0] = i;
                    res = dfs(i,1,1);
                    i++;
                }
            }
        }
        return res;
    }

    private boolean dfs(int v, int contNodos, int contEdges) {
        boolean res=false;
        vis[v] = true;
        if(numNodos==contNodos && contEdges==contNodos) {
            int cont=0;
            while(!res && cont<adj[v].size()){
                Arista u = adj[v].get(cont);
                if(recorrido[0]==u.getDestino())
                    res=true;
                cont++; 
            }
            cont=0;
            vis[v] = false;
        }
        for (Arista a : adj[v]) {
            int u = a.getDestino();
            if(!vis[u]) {
                recorrido[contNodos] = u;
                res = dfs(u,contNodos+1,contEdges+1);
            }
        }
        vis[v] = false;
        return res;
    }
    
    public boolean esGrafoRueda(){
        return false;
    }
    
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