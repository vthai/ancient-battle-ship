package org.vthai.game.ancientbattleship;

import javax.inject.Inject;
import javax.inject.Named;

import org.vthai.game.ancientbattleship.battlefield.Commander;
import org.vthai.game.ancientbattleship.battlefield.service.OceanEventService;
import org.vthai.game.ancientbattleship.di.CommanderModule;
import org.vthai.game.ancientbattleship.queue.OceanEventQueue;


public class AncientBattleShipApp {
   
   private OceanEventService oceanEventService;
   
   private Commander partyA;
   
   private Commander partyB;
   
   private OceanEventQueue oceanEventQueue;
   
   @Inject
   public AncientBattleShipApp(OceanEventService oceanEventService,
         @Named(CommanderModule.commanderPartyA) Commander partyA, @Named(CommanderModule.commanderPartyB) Commander partyB) {
      this.oceanEventService = oceanEventService;
      this.partyA = partyA;
      this.partyB = partyB;
   }
   
   public OceanEventService getOceanEventService() {
      return oceanEventService;
   }

   
   public Commander getPartyA() {
      return partyA;
   }

   
   public Commander getPartyB() {
      return partyB;
   }
   
   
}
