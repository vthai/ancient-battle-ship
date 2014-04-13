package org.vthai.game.ancientbattleship.di;

import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.AncientBattleShipApp;
import org.vthai.game.ancientbattleship.battlefield.service.OceanEventService;
import org.vthai.game.ancientbattleship.battlefield.service.OceanEventServiceImpl;

import dagger.Module;
import dagger.Provides;

@Module(injects = AncientBattleShipApp.class, includes = { ValidatorModule.class, ConfigureModule.class }, complete = false)
public class DependencyModule {

   @Provides
   @Singleton
   public OceanEventService provideOceanEventService(OceanEventServiceImpl oceanEventService) {
      return oceanEventService;
   }
}
