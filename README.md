# Auxiliatura-Grafos

## 👩🏻‍💻 Datos del Estudiante: 
_**Nombre completo:** Esther Romero Aguilar_

_**Carrera:** Ingeniera Informática_

---

# Implementación Base (Primer Parcial)

_Elaboración de la estructura, métodos y atributos de un Grafo_
## 1) Conceptos básicos 📖

_Teoría de conceptos basicos y consideraciones que se tomaron en cuenta al momento de la implementación._

### 📌Grafos Completos 

_Grafos dirigidos/no dirigido: se considera un grafo completo cuando de cada vertice se puede llegar a otro sin problema, es decir, para que sea completo cada par de vértices debe tener dos aristas, una de ida y otra de vuelta._
<p align="center"><img width="200" src="http://matematicas.uam.es/~pablo.angulo/doc/laboratorio/_images/cell_24_sage0.png" alt="Imagen Grafo Completo"></p>

### 📌Grafos Ciclos 

_Grafos no dirigido: se considera grafo ciclo cuando se parte de un vertice y pasamos por todos los vertices y aristas una sola vez, de tal modo que llegamos al vertice de partida (siendo el único que se repite)._
<p align="center"><img width="200" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Undirected_6_cycle.svg/640px-Undirected_6_cycle.svg.png" alt="Imagen Grafo Ciclo no dirigido"></p>

_Grafos dirigidos: aplicamos la misma teoria de los grafos no dirigidos, sin embargo, respetando la direccion que tiene cada grafo._

<p align="center"><img width="300" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaLETu86554kcQKYyONVm8TvVzLFkzN0Bqkg&usqp=CAU" alt="Imagen Grafo Ciclo dirigido"></p>

### 📌Grafos Rueda 

_Grafos dirigidos/no dirigido: se considera grafo rueda cuando el grado de cada vertice es igual a 3 ( g(v)=3 ) exceptuando el vertice rueda, que su grado es el numero de vertices -1, cabe destacar que para grafos dirigidos, tomamos al vertice rueda como fuente; de tal forma que llegamos a la conclusion que un grafo rueda es igual a (numVertices-1)*3 + (numVertices-1). Factorizando: (numVertices-1)*4, siendo el resultado igual a nuestro número de aristas._

<p align="center"><img width="200" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Wagner_graph_ham.svg/240px-Wagner_graph_ham.svg.png" alt="Imagen Grafo Rueda"></p>

## 2) Explicación de Clases 📖

_Se cuenta con tres clases: Clase Abstracta Grafo, Clase ListADJ y Clase Main_


<p align="center"><img width="350" src="https://github.com/esther-romero/Auxiliatura-Grafos/blob/main/img/Estructura.png" alt="Imagen Estructura"></p>

_Clase Abstracta Grafo: Esta clase nos muestra todos los metodos basicos que puede realizar un grafo, sin realizar alguna implementación._

<p align="center"><img width="600" src="https://github.com/esther-romero/Auxiliatura-Grafos/blob/main/img/Clase%20Grafo.png" alt="Imagen Clase abstracta"></p>

_Clase ListADJ: Esta clase se encarga de la implementación de todos los métodos existentes en la clase abstracta Grafo, por tanto, extiende de Grafo._

_A su vez, se utilizo listas de adyacencia para la representacion de los grafos._

_Clase Main: Es la clase principal, por donde hacemos correr todos los metodos implementados en nuestra clase ListADJ._

## 3) Explicación de métodos y su tipo de retorno 🚀

_El grafo contiene 13 metodos, mostrando las capacidades básicas que puede realizar un Grafo._

### getNumVertices() 📋

_Retorna el numero de vertices que contiene el Grafo_

```
@param  No necesita parametros
@return int - numero entero
```

### getNumAristas() 📋

_Retorna el numero de aristas que contiene el Grafo_

```
@param  No necesita parametros
@return int - numero entero
```

### existeArista(int origen, int destino) 📋

_Verifica si existe una arista entre dos vertices_

```
@param int -> origen del vertice
@param int -> destino del vertice a buscar
@return true/false - true si la estructura del grafo contiene la arista, falso si la estructura del grafo no contiene la arista
```

### getPesoArista(int i, int j) 📋

_Retorna el peso que tiene una arista, entre dos vertices_

```
@param int -> origen del vertice (i)
@param int -> destino del vertice (j)
@return double - numero decimal
```

### insertarArista(int i, int j) 📋

_Inserta una arista entre dos vertices, retorna una exception si ingresa un vertice no existente_

```
@param int -> origen del vertice (i)
@param int -> destino del vertice (j)
@return void - sin retorno de valores
```

### insertarArista(int i, int j, double peso) 📋

_Inserta una arista entre dos vertices, retorna una exception si ingresa un vertice no existente_

```
@param int -> origen del vertice (i)
@param int -> destino del vertice (j)
@param double -> peso de la arista (peso)
@return void - sin retorno de valores
```

### ArrayList <Arista<Arista>> getAdyacentes(int vertice) 📋

_Encuentra todos los vertices adyacentes a un vertice, retorna una exception si ingresa un vertice no existente_

```
@param  int -> vertice de origen
@return ArrayList<Arista> -> lista de Aristas adyacentes al vertice
```

### dibujarGrafo() 📋

_Imprime el grafo bajo la siguiente estructura:_ 
  
_NodoOrigen  -- peso --> NodoDestino_

```
@param  No necesita parametros
@return void - sin retorno de valores
```

### quitarArista(int origen, int destino) 📋

_Elimina una arista en la estructura del grafo_

```
@param int -> origen del vertice 
@param int -> destino del vertice
@return true/false - true si fue eliminado, false si no fue eliminado
```

### esCompleto() 📋

_Indica si la estructura de un Grafo es completo_

```
@param  No necesita parametros
@return true/false - true si es grafo completo, false si no es grafo completo
```

### existeBucle() 📋

_Verifica si en la estructura de un grafo existe al menos un bucle_

```
@param  No necesita parametros
@return true/false - true si existe un bucle, false si no existe ningun bucle
```

### esGrafoCiclo() 📋

_Verifica si la estructura de un grafo es considerado como Grafo ciclo_

```
@param  No necesita parametros
@return true/false - true si el Grafo es ciclo, false si no es Grafo ciclo
```

### esGrafoRueda() 📋

_Verifica si la estructura de un grafo es considerado como Grafo Rueda_

```
@param  No necesita parametros
@return true/false - true si el Grafo es Rueda, false si no es Grafo Rueda
```

## 4) Casos especiales 📖

_En proceso XD_
  
## 5) Ejecutando Pruebas ⚙️

_**Grafo 1:**_  
  
<p align="center"><img width="250" src="https://github.com/esther-romero/Auxiliatura-Grafos/blob/main/img/Grafo%201.png" alt="Imagen Grafo 1"></p>
  
_Resultados Grafo 1:_ 

_**Grafo 2:**_  
  
<p align="center"><img width="300" src="https://github.com/esther-romero/Auxiliatura-Grafos/blob/main/img/Grafo%202.png" alt="Imagen Grafo 2"></p>
  
_Resultados Grafo 2:_ 

_**Grafo 3:**_  
  
<p align="center"><img width="250" src="https://github.com/esther-romero/Auxiliatura-Grafos/blob/main/img/Grafo%203.png" alt="Imagen Grafo 3"></p>
  
_Resultados Grafo 3:_ 


## 5) Analizando las Pruebas con casos especiales ⚙️
  


## Construido con 🛠️

_Herramientas que se utilizaron para el proyecto_

* Java - Lenguaje de programación
* Visual Studio Code - IDE de programación
