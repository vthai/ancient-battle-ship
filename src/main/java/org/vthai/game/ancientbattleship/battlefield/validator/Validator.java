package org.vthai.game.ancientbattleship.battlefield.validator;

public interface Validator<T, A> {

   @SuppressWarnings("unchecked")
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, T value, A... arguments);
}
