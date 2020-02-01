package me.wonsey.ood;

public class AirFryerOnCommand implements Command
{
   AirFryer airFryer;

   public AirFryerOnCommand(AirFryer airFryer)
   {
      this.airFryer = airFryer;
   }

   public void Execute()
   {
      this.airFryer.on();
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }

}
