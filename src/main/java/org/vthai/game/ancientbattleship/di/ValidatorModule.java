package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.validator.RangeValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ValidatorModule {

   public static final String oceanRangeValidatorId = "oceanRangeValidator";

   @Provides
   @Singleton
   @Named(ValidatorModule.oceanRangeValidatorId)
   public Validator providesRangeValidator() {
      return new RangeValidator();
   }
}
