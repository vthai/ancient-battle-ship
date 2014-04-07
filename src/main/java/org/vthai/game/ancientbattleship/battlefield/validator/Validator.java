package org.vthai.game.ancientbattleship.battlefield.validator;


public interface Validator {
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, Object value, Object... arguments);
}
