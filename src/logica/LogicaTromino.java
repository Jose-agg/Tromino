package logica;

public class LogicaTromino {

	private static int [][] tablero;
	private static int nTA=1;				//Numero de tromino actual
	
	public static void tromino (int dimension, int xPos, int yPos, boolean pintar){
		if((Math.log(dimension) / Math.log(2)) % 1 == 0){
			tablero = new int [dimension][dimension];
			tablero[xPos][yPos] = -1;
			nTA++;
			trominoRec(tablero,tablero[0].length,xPos,yPos,0,0);
			if(pintar) pintar(dimension);
		}else
			System.out.println("Introduzca una potencia de 2. "+dimension+" no es una potencia de 2.");
	}
	
	private static void pintar(int d){
		for (int i=0; i<d; i++){
			for (int j=0; j<d; j++){
				if(tablero[i][j]<10 && tablero[i][j] != -1)
					System.out.print("|      "+tablero[i][j]+"      |");
				
				else if((tablero[i][j]>=10 && tablero[i][j]<=99) || tablero[i][j] == -1)
					System.out.print("|     "+tablero[i][j]+"      |");
				
				else if(tablero[i][j]>=100 && tablero[i][j]<=999)
					System.out.print("|    "+tablero[i][j]+"      |");
				
				else if(tablero[i][j]>=1000 && tablero[i][j]<=9999)
					System.out.print("|    "+tablero[i][j]+"      |");
				
				else if(tablero[i][j]>=10000 && tablero[i][j]<=99999)
					System.out.print("|   "+tablero[i][j]+"      |");
				
				else
					System.out.print("| "+tablero[i][j]+"      |");
			}
			System.out.println();
		}
				
	}

	private static void trominoRec(int[][] t, int dimension, int xPos, int yPos, int xCoordenada, int yCoordenada) {
		nTA++;
		int tCuadrante = dimension/2;
		int alg1= xCoordenada+tCuadrante-1;
		int alg2= yCoordenada+tCuadrante-1;
		
		if(dimension<=2){
			int punto = t[xPos][yPos];
			t[alg1][alg2]=nTA;
			t[alg1][alg2+1]=nTA;
			t[alg1+1][alg2]=nTA;
			t[alg1+1][alg2+1]=nTA;
			t[xPos][yPos]=punto;
			nTA++;
		}
		else if(dimension>=4){
			int xCuadrante1 = alg1; int yCuadrante1 = alg2;
			int xCuadrante2 = alg1;	int yCuadrante2 = alg2+1;
			int xCuadrante3 = alg1+1; int yCuadrante3 = alg2;
			int xCuadrante4 = alg1+1; int yCuadrante4 = alg2+1;
			
			// Pones un trominó en el centro mirando el agujero a la celda resuelta
			if(xPos<=alg1 && yPos<=alg2){				// Celda resuelta en el primer cuadrante
				xCuadrante1=xPos;
				yCuadrante1=yPos;
				t[alg1][alg2+1]=nTA;
				t[alg1+1][alg2]=nTA;
				t[alg1+1][alg2+1]=nTA;
				nTA++;
			}else if(xPos<=alg1 && yPos>alg2){			// Celda resuelta en el segundo cuadrante
				xCuadrante2=xPos;
				yCuadrante2=yPos;
				t[alg1][alg2]=nTA;
				t[alg1+1][alg2]=nTA;
				t[alg1+1][alg2+1]=nTA;
				nTA++;
			}else if(xPos>alg1 && yPos<=alg2){			// Celda resuelta en el tercer cuadrante
				xCuadrante3=xPos;
				yCuadrante3=yPos;
				t[alg1][alg2]=nTA;
				t[alg1][alg2+1]=nTA;
				t[alg1+1][alg2+1]=nTA;
				nTA++;
			}else{										// Celda resuelta en el cuarto cuadrante
				xCuadrante4=xPos;
				yCuadrante4=yPos;
				t[alg1][alg2]=nTA;
				t[alg1+1][alg2]=nTA;
				t[alg1][alg2+1]=nTA;
				nTA++;
			}
			
			trominoRec(t,tCuadrante,xCuadrante1,yCuadrante1,xCoordenada,yCoordenada);
			trominoRec(t,tCuadrante,xCuadrante2,yCuadrante2,xCoordenada,yCoordenada+tCuadrante);
			trominoRec(t,tCuadrante,xCuadrante3,yCuadrante3,xCoordenada+tCuadrante,yCoordenada);
			trominoRec(t,tCuadrante,xCuadrante4,yCuadrante4,xCoordenada+tCuadrante,yCoordenada+tCuadrante);
						
		}
	}
}