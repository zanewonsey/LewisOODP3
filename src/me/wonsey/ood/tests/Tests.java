package me.wonsey.ood.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import me.wonsey.ood.AirFryer;
import me.wonsey.ood.AirFryerOffCommand;
import me.wonsey.ood.AirFryerOnCommand;
import me.wonsey.ood.KitchenAid;
import me.wonsey.ood.KitchenAidOffCommand;
import me.wonsey.ood.KitchenAidOnCommand;
import me.wonsey.ood.SmartKitchenController;
import me.wonsey.ood.Stove;
import me.wonsey.ood.StoveOffCommand;
import me.wonsey.ood.StoveOnCommand;

public class Tests
{

   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;
   private final PrintStream originalErr = System.err;
   
   @Before
   public void setUp() throws Exception
   {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
   }
   
   @After
   public void tearDown() throws Exception
   {
      System.setOut(new PrintStream(originalOut));
      System.setErr(new PrintStream(originalErr));
   }
   
   @Test
   public void test()
   {
      SmartKitchenController skc = new SmartKitchenController();
      Assert.assertNotEquals(skc, null);
      
      KitchenAid ka = new KitchenAid();
      KitchenAidOnCommand ka_on = new KitchenAidOnCommand(ka);
      KitchenAidOffCommand ka_off = new KitchenAidOffCommand(ka);
      
      outContent.reset();
      
      skc.setCommand(0, ka_on, ka_off);
      skc.turnOn(0);
      Assert.assertEquals("Kitchenaid was turned on\r\n", outContent.toString());
      outContent.reset();
      skc.turnOff(0);
      Assert.assertEquals("Kitchenaid was turned off\r\n", outContent.toString());
      outContent.reset();
      
      AirFryer af = new AirFryer();
      AirFryerOnCommand af_on = new AirFryerOnCommand(af);
      AirFryerOffCommand af_off = new AirFryerOffCommand(af);
      
      skc.setCommand(1, af_on, af_off);
      skc.turnOn(1);
      Assert.assertEquals("Air fryer was turned on\r\n", outContent.toString());
      outContent.reset();
      skc.turnOff(1);
      Assert.assertEquals("Air fryer was turned off\r\n", outContent.toString());
      outContent.reset();
      
      Stove s = new Stove();
      StoveOnCommand s_on = new StoveOnCommand(s);
      StoveOffCommand s_off = new StoveOffCommand(s);
      
      skc.setCommand(2, s_on, s_off);
      skc.turnOn(2);
      Assert.assertEquals("Stove was turned on\r\nStove starts to heat up\r\n", outContent.toString());
      outContent.reset();
      skc.turnOff(2);
      Assert.assertEquals("Stove was turned off\r\nStove starts to cool down\r\n", outContent.toString());
      outContent.reset();
      
   }

}
