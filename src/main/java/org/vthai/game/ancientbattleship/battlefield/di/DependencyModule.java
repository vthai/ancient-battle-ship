package org.vthai.game.ancientbattleship.battlefield.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.validator.RangeValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;

import dagger.Module;
import dagger.Provides;

@Module (injects=AncientBattleShipApp.class)
public class DependencyModule {
   
   @Provides
   @Singleton
   @Named("oceanRangeValidator")
   public Validator providesRangeValidator() {
      return new RangeValidator();
   }
}
