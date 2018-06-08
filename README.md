# Tromino #

Este proyecto contiene un algoritmo "divide y vencerás" para la resolución de un L-Trominó.

Un L-Trominó es un caso particular del problema de los poliominós. Este caso está formado por 3 cuadrados que forman una L. Para más información del problema de los poliominós visite el siguiente [enlace](http://culturacientifica.com/2014/07/16/embaldosando-con-l-triominos-un-ejemplo-de-demostracion-por-induccion)

El problema original que se plantearon los matemáticos consistía en coger un tablero 8 x 8, del que se “quitaba” uno de los cuadrados, y ver si se podía recubrir con piezas con forma de L-trominó, exactamente 21 piezas (puesto que 64 – 1 = 3 x 21). En la siguiente imagen vemos un tablero 8 x 8 al que se le ha eliminado un cuadrado, pintado de blanco, y una de las fichas de L-triominó con las que hay que cubrir este tablero deficiente.

![tablero](https://github.com/MrKarrter/Tromino/blob/master/imagenes/tablero.png)

Para aplicar dicho formato al algoritmo del proyecto se sustituye la celda vacía por el valor **-1** y las figuras en forma de L por conjuntos de tres números iguales escogidos de manera aleatoria.

# Ejecución #

Para probar la ejecución del algoritmo es necesario ejecutar la aplicación pasándole como argumentos:

> juego A B C

*Leyenda:*
- A: el tamaño de tablero, A x A.
- B: la posición en el eje x de la casilla vacía.
- C: la posición en el eje y de la casilla vacía.
- *La posición de la casilla vacía tiene que estar dentro del tablero.*

Esta versión del algoritmo cuenta con un segundo formato de ejecución. En esta versión se ejecutará el algoritmo de manera automática con tableros que irán aumentando de tamaño con potencias de 2 (16, 32, 64, 128, 264 ...), y se medirá el tiempo que tarda en ejecutar cada uno de los tableros. Debido a que los tableros pequeños se solucionan casi de manera instantánea se ha de añadir como argumento a la ejecución el número de veces que se quiere que se ejecute el algoritmo.

> tiempo X

*Leyenda:*
- X: número de veces que se ejecuta el mismo tamaño del tablero.

Esta versión de ejecución lanzará una excepción cuando alcance se desborde el heap que tiene asignada la ejecución del programa.