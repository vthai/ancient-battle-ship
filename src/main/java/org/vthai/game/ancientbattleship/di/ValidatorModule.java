package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.validator.CoordinateValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.RangeValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ValidatorModule {

   public static final String oceanRangeValidatorId = "oceanRangeValidator";
   
   public static final String oceanCoordinateValidatorId = "oceanCoordinateValidator";

   @Provides
   @Singleton
   @Named(ValidatorModule.oceanRangeValidatorId)
   public Validator provideRangeValidator() {
      return new RangeValidator();
   }
   
   @Provides
   @Singleton
   @Named(ValidatorModule.oceanCoordinateValidatorId)
   public Validator provideCoordinateValidator() {
      return new CoordinateValidator();
   }
}
