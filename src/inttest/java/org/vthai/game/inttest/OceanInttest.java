package org.vthai.game.inttest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.di.RootBundle;

import se.jbee.inject.Dependency;
import se.jbee.inject.Injector;
import se.jbee.inject.bootstrap.Bootstrap;

public class OceanInttest {

   private Random random;

   @BeforeClass
   public static void setupSilkDi() {
      Injector injector = Bootstrap.injector(RootBundle.class);
      Dependency<Validator> validatorDependencies = Dependency.dependency(Validator.class);
      injector.resolve(validatorDependencies);
   }

   @Before
   public void setUp() {
      random = new Random(System.currentTimeMillis());
   }

   @Test
   public void testOceanInit() {
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

      OccupiableCoordinate coordinateToBeExamined = ocean.queryCoordinate(0, 0);
      assertThat(coordinateToBeExamined.getX(), equalTo(0));
      assertThat(coordinateToBeExamined.getY(), equalTo(0));

      int randomX = random.nextInt(column);
      int randomY = random.nextInt(row);

      coordinateToBeExamined = ocean.queryCoordinate(randomX, randomY);
      assertThat(coordinateToBeExamined.getX(), equalTo(randomX));
      assertThat(coordinateToBeExamined.getY(), equalTo(randomY));

      coordinateToBeExamined = ocean.queryCoordinate(column - 1, row - 1);
      assertThat(coordinateToBeExamined.getX(), equalTo(column - 1));
      assertThat(coordinateToBeExamined.getY(), equalTo(row - 1));
   }
}
