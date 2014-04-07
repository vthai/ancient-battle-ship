package org.vthai.game.ancientbattleship.battlefield.service;

import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.event.Event;
import org.vthai.game.ancientbattleship.battlefield.event.EventType;

public class OceanEventServiceImpl implements OceanEventService {

   private Ocean ocean;

   public OceanEventServiceImpl(Ocean ocean) {
      this.ocean = ocean;
   }

   @Override
   public void processEvent(Event event) {
      EventType eventType = event.getEventType();
      Coordinate coordinate = event.getEventTarget();
      
      switch (eventType) {
         case PLACE:
            ocean.occupyAtCoordinate(coordinate, event.getEventOriginator());
            break;
         case MOVE:
            ocean.removeAtCoordinate(coordinate, event.getEventOriginator());
            ocean.occupyAtCoordinate(coordinate, event.getEventOriginator());
            break;
         case ATTACK:
         case REPAIR:
            OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
            occupiableCoordinate.getOccupiable().absorbEvent(event);
            break;
      }
   }

}
