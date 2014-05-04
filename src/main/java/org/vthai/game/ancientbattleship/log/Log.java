package org.vthai.game.ancientbattleship.log;

import java.util.List;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.observerable.Observerable;
import org.vthai.game.ancientbattleship.observerable.ObserverableAction;
import org.vthai.game.ancientbattleship.observerable.ObserverableObject;
import org.vthai.game.ancientbattleship.observerable.ObserverablePhenomenon;


public interface Log {
   public Coordinate whereYouWere();
   
   public List<Observerable<ObserverableObject>> whatYouSaw();
   
   public Observerable<ObserverablePhenomenon> whatYouGot();
   
   public Observerable<ObserverableAction> whatYouDid();
}
