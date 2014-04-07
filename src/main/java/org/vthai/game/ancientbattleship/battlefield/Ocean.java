package org.vthai.game.ancientbattleship.battlefield;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;


public class Ocean {
   private Coordinate[][] coordinates;
   
   private int row;
   
   private int column;
   
   public Ocean(int row, int column) {
      defineRowColumn(row, column);
      initializeArea();
   }
   
   public void initializeArea() {
      coordinates = new Coordinate[column][row];
      Occupiable voidness = new Voidness();
      
      for(int x = 0; x < column; x++) {
         for(int y = 0; y < row; y++) {
            coordinates[x][y] = new Coordinate(x, y, voidness);
         }
      }
   }
   
   public Coordinate queryCoordinate(int x, int y) {
      assert (x >= 0 && x < column) : "The coordinate x exceeds max column " + column;
      assert (y >= 0 && y < row) : "The coordinate y exceeds max row " + row;
      return coordinates[x][y];
   }
   
   private void defineRowColumn(int row, int column) {
      // validation code can go here
      this.row = row;
      this.column = column;
   }
}
