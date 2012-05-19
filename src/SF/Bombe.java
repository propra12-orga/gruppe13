import java.util.Date;

import SF.Feld;

public class Bombe {

	public static void Bombe(int X,int Y){
		int Radius = 5;
		FieldEntry[][] map = Feld.StartBomberman.getmap();
		Feld.StartBomgerman.setmap(X,Y,FieldEntry(4,true,0));//Bombe legen
		
		//Countdown bis zur Explosion starten
		double Start = new Date().getTime();
		double zeit = 0;

		while (zeit <= Start + 2000) {
			zeit = new Date().getTime();
		}

		System.out.println("BUMM");

		//Explosion
		for (int i=0;i<Radius;i++){
			if ((map[X+i][Y]!=FieldEntry(0,false,0)) && (map[X+i][Y]!=FieldEntry(3,true,0))){
				Feld.StartBomerman.setmap(X+i,Y,FieldEntry(5,true,0));
			}
			else break;
		}
		for (int i=0;i<Radius;i++){
			if ((map[X][Y+i]!=FieldEntry(0,false,0)) && (map[X][Y+i]!=FieldEntry(3,true,0))){
				Feld.StartBomerman.setmap(X,Y+i,FieldEntry(5,true,0));
			}
			else break;
		}
		for (int i=0;i<Radius;i++){
			if ((map[X-i][Y]!=FieldEntry(0,false,0)) && (map[X-i][Y]!=FieldEntry(3,true,0))){
				Feld.StartBomerman.setmap(X-i,Y,FieldEntry(5,true,0));
			}
			else break;
		}
		for (int i=0;i<Radius;i++){
			if ((map[X][Y-i]!=FieldEntry(0,false,0)) && (map[X][Y-i]!=FieldEntry(3,true,0))){
				Feld.StartBomerman.setmap(X,Y-i,FieldEntry(5,true,0));
			}
			else break;
		}
		//Countdown2 bis Abklingen der Explosion
		double Start1 = new Date().getTime();
		double zeit1 = 0;

		while (zeit1 <= Start1 + 200) {
			zeit1 = new Date().getTime();
		}
	//Feuer entfernen
		for (int i=0;i<Radius;i++){
			if (map[X+i][Y]==FieldEntry(5,true,0)){
				Feld.StartBomberman.setmap(X+i,Y,FieldEntry(1,true,0))
			}
			else break;
		}
		for (int i=0;i<Radius;i++){
			if (map[X-i][Y]==FieldEntry(5,true,0)){
				Feld.StartBomberman.setmap(X-i,Y,FieldEntry(1,true,0))
			}
			else break;
		}
		for (int i=0;i<Radius;i++){
			if (map[X][Y+i]==FieldEntry(5,true,0)){
				Feld.StartBomberman.setmap(X,Y+i,FieldEntry(1,true,0))
			}
			else break;
		}
			for (int i=0;i<Radius;i++){
				if (map[X][Y-i]==FieldEntry(5,true,0)){
					Feld.StartBomberman.setmap(X,Y-i,FieldEntry(1,true,0))
				}
				else break;
			}
	}
}
