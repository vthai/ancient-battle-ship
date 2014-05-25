package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.battlefield.validator.impl.ComparisonValidatorImpl;
import org.vthai.game.ancientbattleship.battlefield.validator.impl.CoordinateValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.impl.IntegerComparisonValidator;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ValidatorModule {

   public static final String oceanRangeValidatorId = "oceanRangeValidator";
   
   public static final String oceanCoordinateValidatorId = "oceanCoordinateValidator";

   @Provides
   @Singleton
   @Named(ValidatorModule.oceanRangeValidatorId)
   public ComparisonValidatorImpl<Integer> provideRangeValidator() {
      return new IntegerComparisonValidator();
   }
   
   @Provides
   @Singleton
   @Named(ValidatorModule.oceanCoordinateValidatorId)
   public Validator<OccupiableCoordinate, String> provideCoordinateValidator() {
      return new CoordinateValidator();
   }
}
