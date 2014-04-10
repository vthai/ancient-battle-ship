package org.vthai.game.ancientbattleship.battlefield;

import javax.inject.Inject;
import javax.inject.Named;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OceanInvalidCoordinatesException;
import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.message.Message;


public class Ocean {
   
   private OccupiableCoordinate[][] coordinates;
   
   private int row;
   
   private int column;
   
   @Inject
   @Named("oceanRangeValidator")
   private Validator rangeValidator;
   
   public Ocean(int row, int column) {
      defineRowColumn(row, column);
      initializeArea();
   }
   
   public void initializeArea() {
      coordinates = new OccupiableCoordinate[column][row];
      Occupiable voidness = new Voidness();
      
      for(int x = 0; x < column; x++) {
         for(int y = 0; y < row; y++) {
            coordinates[x][y] = new OccupiableCoordinate(x, y, voidness);
         }
      }
   }
   
   public OccupiableCoordinate queryCoordinate(int x, int y) {
      rangeValidator.validate(OceanInvalidCoordinatesException.class,
            Message.getString("ocean.invalid.coordinate.x", column), x, 0, column);
      
      rangeValidator.validate(OceanInvalidCoordinatesException.class,
            Message.getString("ocean.invalid.coordinate.y", row), y, 0, row);
      
      return coordinates[x][y];
   }
   
   private void defineRowColumn(int row, int column) {
      // validation code can go here
      this.row = row;
      this.column = column;
   }

   public void occupyAtCoordinate(Coordinate coordinate, Occupiable eventOriginator) {
      coordinates[coordinate.getX()][coordinate.getY()].setOccupiable(eventOriginator);
   }

   public void removeAtCoordinate(Coordinate coordinate, Occupiable eventOriginator) {
      // TODO Auto-generated method stub
      
   }
}
