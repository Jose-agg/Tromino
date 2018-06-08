package launcher;


import logica.LogicaTromino;

public class Launcher {

	public static void main(String arg []) {
		String tipoPrueba = arg[0];
		switch (tipoPrueba){
		case "juego":
			launcherJuegoTromino(arg[1], arg[2], arg[3]);
			break;
		case "tiempos":
			launcherTiemposTromino(Integer.parseInt(arg[1]));
			break;
		default:
			System.out.println("Tipo de prueba para el trominó no válida");
			break;
		}

	}

	private static void launcherJuegoTromino(String d, String x, String y) {
		int dimensiones = Integer.parseInt (d);
		int xPos = Integer.parseInt (x);
		int yPos = Integer.parseInt (y);
		LogicaTromino.tromino(dimensiones, xPos, yPos, true);
		
	}
	
	private static void launcherTiemposTromino(int nVeces) {
		long t1,t2;
		int xPos, yPos;
		double r1 = Math.random();
		double r2 = Math.random();
		System.out.println("Número de veces a repetir: "+nVeces);
		for(int i=16; i<32769; i*=2){
			xPos = (int) (r1*i);
			yPos = (int) (r2*i);
			t1 = System.currentTimeMillis ();
			for(int j=0; j<=nVeces; j++)
				LogicaTromino.tromino(i, xPos, yPos, false);
			t2 = System.currentTimeMillis ();
			
			System.out.println("Tablero de tamaño "+i+". TIEMPO= "+(t2-t1));
		}
	}

}
