package org.vthai.game.ancientbattleship.battlefield.validator.impl;

public class ComparisonValidatorImpl<T extends Comparable<T>> extends ValidatorExceptionHandlerImpl {

   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, T value, T lowerBound,
         T upperBound) {
      if (value.compareTo(lowerBound) < 0 || value.compareTo(upperBound) > 0) {
         throwExpection(exceptionClass, errorMessage);
      }
   }
}
