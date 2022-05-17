import java.util.ArrayList;
public class Main {
    public static void main(String [] args){
        //Grafo 3:
        ListADJ ladj = new ListADJ(false,5);
        
        ladj.insertarArista(0,1);
        ladj.insertarArista(0,2);
        ladj.insertarArista(0,3);
        ladj.insertarArista(0,4);
        ladj.insertarArista(1,2);
        ladj.insertarArista(1,3);
        ladj.insertarArista(1,4);
        ladj.insertarArista(2,3);
        ladj.insertarArista(2,4);
        ladj.insertarArista(3,4);


        System.out.println("Numero de vertices: " + ladj.getNumVertices());
        System.out.println("Numero de aristas: "+ ladj.getNumAristas());
        System.out.println("Existe arista en los vertices 2 -> 1 : " + ladj.existeArista(2, 1));
        System.out.println("El peso de los nodos 3 -> 2 es: "+ladj.getPesoArista(3, 2));
        ladj.insertarArista(2, 2);
        ladj.insertarArista(0, 0, 8);
        System.out.println("La arista 2 -> 2 sin peso y la arista 0 -> 0 con peso 8 se inserto exitosamente");
        System.out.print("La lista adyacente del vertice 3 es: ");
        ArrayList<ListADJ.Arista> prueba = ladj.getAdyacentes(3);
        for(ListADJ.Arista b : prueba){
            System.out.print(b.getDestino()+" ");
        }
        System.out.print("\nLa estructura dibujada del grafo es:\n");
        ladj.dibujarGrafo();
        System.out.println("Se quito las aristas 2 -> 2: " + ladj.quitarArista(2,2));
        System.out.println("Se quito las aristas 2 -> 2: " + ladj.quitarArista(2,2));
        System.out.println("Se quito las aristas 0 -> 0: " + ladj.quitarArista(0,0));
        System.out.println("Se quito las aristas 0 -> 0: " + ladj.quitarArista(0,0));
        System.out.print("La estructura dibujada del grafo es:\n");
        ladj.dibujarGrafo();
        System.out.println("\nEl grafo es completo: "+ladj.esCompleto());
        System.out.println("El grafo es ciclo: "+ ladj.esGrafoCiclo());
        System.out.println("El grafo es rueda: "+ladj.esGrafoRueda());
        System.out.println("Existe un bucle en el grafo: "+ ladj.existeBucle());    
    }
}

/*
        // Grafo 1:

        ListADJ ladj = new ListADJ(true,4);

        ladj.insertarArista(0,1,3);
        ladj.insertarArista(2,1,6);
        ladj.insertarArista(2,0,6);
        ladj.insertarArista(3,0,3);
        ladj.insertarArista(3,1,2);
        ladj.insertarArista(3,2,10);
    
        //Grafo 2:

        ListADJ ladj = new ListADJ(false,4);
        ladj.insertarArista(0,1);
        ladj.insertarArista(0,3);
        ladj.insertarArista(0,2);
        ladj.insertarArista(1,3);
        ladj.insertarArista(1,2);
        ladj.insertarArista(2,3);
    
    */