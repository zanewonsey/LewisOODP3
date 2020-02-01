package me.wonsey.ood;

public class StoveOnCommand implements Command
{
   
   Stove s;
   
   public StoveOnCommand(Stove s)
   {
      this.s = s;
   }

   @Override
   public void Execute()
   {
      s.on();
      s.heatUp();
      
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }

}
