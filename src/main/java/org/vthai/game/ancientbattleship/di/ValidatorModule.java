package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.validator.RangeValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ValidatorModule {

   @Provides
   @Singleton
   @Named("oceanRangeValidator")
   public Validator providesRangeValidator() {
      return new RangeValidator();
   }
}
