package org.vthai.game.ancientbattleship.battlefield.event;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;

public class Event {

   private Occupiable eventOriginator;

   private Coordinate eventOriginatedLocation;

   private Coordinate eventTarget;

   private EventType eventType;

   public Occupiable getEventOriginator() {
      return eventOriginator;
   }

   public void setEventOriginator(Occupiable eventOriginator) {
      this.eventOriginator = eventOriginator;
   }

   public Coordinate getEventOriginatedLocation() {
      return eventOriginatedLocation;
   }

   public void setEventOriginatedLocation(OccupiableCoordinate eventOriginatedLocation) {
      this.eventOriginatedLocation = eventOriginatedLocation;
   }

   public Coordinate getEventTarget() {
      return eventTarget;
   }

   public void setEventTarget(Coordinate eventTarget) {
      this.eventTarget = eventTarget;
   }

   public EventType getEventType() {
      return eventType;
   }

   public void setEventType(EventType eventType) {
      this.eventType = eventType;
   }

}
