package org.vthai.game.ancientbattleship.battlefield.validator;

public interface ValidatorExceptionHandler {

   public void throwExpection(Class<? extends RuntimeException> exceptionClass, String errorMessage);
}
