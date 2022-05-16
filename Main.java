import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        ListADJ ladj = new ListADJ(false,4);
        
        ladj.insertarArista(0,1);
        ladj.insertarArista(0,3);
        ladj.insertarArista(0,2);
        ladj.insertarArista(1,3);
        ladj.insertarArista(1,2);
        ladj.insertarArista(2,3);

        System.out.println("Numero de vertices: " + ladj.getNumVertices());
        System.out.println("Numero de aristas: "+ ladj.getNumAristas());
        System.out.println("Existe arista en los vertices 1 ->3 : " + ladj.existeArista(1, 3));
        System.out.println("El peso de los nodos 2 -> 3 es: "+ladj.getPesoArista(2, 3));
        ladj.insertarArista(2, 2);
        ladj.insertarArista(0, 0, 8);
        System.out.println("La arista 2 -> 2 sin peso y la arista 0 -> 0 con peso 8 se inserto exitosamente");
        System.out.print("La lista adyacente del vertice 1 es: ");
        ArrayList<ListADJ.Arista> prueba = ladj.getAdyacentes(1);
        for(ListADJ.Arista b : prueba){
            System.out.print(b.getDestino()+" ");
        }
        System.out.println("\nLa estructura dibujada del grafo es: ");
        ladj.dibujarGrafo();
        System.out.println("\nSe quito las aristas 2 -> 2: " + ladj.quitarArista(2,2));
        System.out.println("Se quito las aristas 2 -> 2: " + ladj.quitarArista(2,2));
        System.out.println("Se quito las aristas 0 -> 0: " + ladj.quitarArista(0,0));
        System.out.println("Se quito las aristas 0 -> 0: " + ladj.quitarArista(0,0));
        ladj.dibujarGrafo();
        System.out.println("\nEl grafo es completo: "+ladj.esCompleto());
        System.out.println("El grafo es ciclo: "+ ladj.esGrafoCiclo());
        System.out.println("El grafo es rueda: "+ladj.esGrafoRueda());
        System.out.println("Existe un bucle en el grafo: "+ ladj.existeBucle());    
    }
}