package me.wonsey.ood;

public class AirFryerOffCommand implements Command
{
   AirFryer airFryer;

   public AirFryerOffCommand(AirFryer airFryer)
   {
      this.airFryer = airFryer;
   }

   public void Execute()
   {
      this.airFryer.off();
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }

}
