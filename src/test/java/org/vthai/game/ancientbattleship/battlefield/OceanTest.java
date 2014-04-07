package org.vthai.game.ancientbattleship.battlefield;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OceanInvalidCoordinates;

public class OceanTest {
   
   private Random random;
   
   @Rule
   public ExpectedException thrown = ExpectedException.none();
   
   @Before
   public void setUp() {
      random = new Random(System.currentTimeMillis());
   }

   @Test
   public void testOceanInit() {
      final int row = 100;
      final int column = 50;
      
      Ocean ocean = new Ocean(row, column);
      
      Coordinate coordinateToBeExamined = ocean.queryCoordinate(0, 0);
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
   
   @Test
   public void testOceanInitShouldThrowExceptionIfCoordinateExceeds() {
      final int row = 100;
      final int column = 50;
      
      Ocean ocean = new Ocean(row, column);
      
      int randomX = column + random.nextInt(column);
      int randomY = random.nextInt(row);
      
      ocean.queryCoordinate(randomX, randomY);
      
      thrown.expect(OceanInvalidCoordinates.class);
      thrown.expectMessage("The coordinate x exceeds max column " + column);
   }
}
