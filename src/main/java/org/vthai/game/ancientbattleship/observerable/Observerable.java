package org.vthai.game.ancientbattleship.observerable;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;


public class Observerable<T> extends Coordinate {
   private T observerable;
   
   public Observerable(int x, int y, T observerable) {
      super(x, y);
      this.observerable = observerable;
   }
   
   public T getObserverable() {
      return observerable;
   }
}
