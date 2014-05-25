package org.vthai.game.ancientbattleship.battlefield.validator;

public interface ComparisonValidator<T extends Comparable<T>> {

   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, T value, T lowerBound,
         T upperBound);
}
