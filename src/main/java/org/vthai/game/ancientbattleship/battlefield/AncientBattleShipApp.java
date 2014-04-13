package org.vthai.game.ancientbattleship.battlefield;

import javax.inject.Inject;

import org.vthai.game.ancientbattleship.battlefield.service.OceanEventService;


public class AncientBattleShipApp {
   private OceanEventService oceanEventService;
   
   @Inject
   public AncientBattleShipApp(OceanEventService oceanEventService) {
      this.oceanEventService = oceanEventService;
   }
   
   public OceanEventService getOceanService() {
      return oceanEventService;
   }
}
